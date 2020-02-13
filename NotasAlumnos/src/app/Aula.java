package app;

public class Aula {
    private int[][] notas;
    private String[] alumnos;
    private String[] materias;

    public Aula(int numAlumnos, int numMaterias) {
        this.alumnos = new String[numAlumnos];
        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i] = "Alumno " + i;
        }
        this.materias = new String[numMaterias];
        for (int i = 0; i < materias.length; i++) {
            materias[i] = "Materia " + i;
        }
        this.notas = new int[numAlumnos][numMaterias];
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                int prob = (int) (Math.random() * 101);
                if (prob < 5) {
                    notas[i][j] = 0;
                } else if (prob < 10) {
                    notas[i][j] = 1;
                } else if (prob < 15) {
                    notas[i][j] = 2;
                } else if (prob < 25) {
                    notas[i][j] = 3;
                } else if (prob < 40) {
                    notas[i][j] = 4;
                } else if (prob < 55) {
                    notas[i][j] = 5;
                } else if (prob < 70) {
                    notas[i][j] = 6;
                } else if (prob < 80) {
                    notas[i][j] = 7;
                } else if (prob < 90) {
                    notas[i][j] = 8;
                } else if (prob < 95) {
                    notas[i][j] = 9;
                } else {
                    notas[i][j] = 10;
                }
            }
        }
    }

    public void setNotas(int nota, int numAlumno, int numMateria) {
        this.notas[numAlumno][numMateria] = nota;
    }

    public int[][] getNotas() {
        return notas;
    }

    public String[] getAlumnos() {
        return alumnos;
    }

    public String[] getMaterias() {
        return materias;
    }

    public double mediaNotasTotal(){
        double suma=0;
        
        for(int i=0; i<alumnos.length; i++){
            for(int j=0; j<materias.length; j++){
                suma+=notas[i][j];
            }
        }
        return suma/(materias.length*alumnos.length);

    }
    
    public double mediaAlumno(int alumno){
        double suma=0;
        for(int j=0; j<notas[alumno].length; j++){
            suma+=notas[alumno][j];
        }
        return suma/notas[alumno].length;
    }

    public double mediaMateria(int materia){
        double suma=0;
        for(int i=0; i<notas.length; i++){
            suma+=notas[i][materia];
        }
        return suma/notas.length;
    }

    public int maxNotaMateria(int materia){
        int max=0;
        for(int i=0; i < notas.length; i++){
            if(notas[i][materia]>max){
                max=notas[i][materia];
            }
        }
        return max;
    }

    public int minNotaMateria(int materia){
        int min=10;
        for(int i=0; i < notas.length; i++){
            if(notas[i][materia]<min){
                min=notas[i][materia];
            }
        }
        return min;
    }
           
}


