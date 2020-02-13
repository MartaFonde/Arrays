package app;
import java.util.Scanner;

public class MenuAula{
    private Scanner sc=new Scanner(System.in);
    private Aula aula;
    
    public MenuAula(Aula aulaNueva){
        this.aula=aulaNueva;
    }

    public void mostrarMenu(){
        int opcion;
        do{
            System.out.println("=== OPCIONES ===");
            System.out.println("1. Ver tabla de notas");
            System.out.println("2. Ver notas de un alumno");
            System.out.println("3. Ver notas de una materia");
            System.out.println("4. Calcular la media de notas global");
            System.out.println("5. Media de un alumno");
            System.out.println("6. Media de una materia");
            System.out.println("7. Nota máxima y mínima de una asignatura");
            System.out.println("8. Modificación de una nota");
            System.out.println("9. Salir");
            opcion=Integer.parseInt(sc.nextLine());
            switch(opcion){
                case 1: muestraTabla();
                break;
                case 2: muestraNotasAlumno();
                break;
                case 3: muestraNotasMateria();
                break;
                case 4: mediaNotasGlobal();
                break;
                case 5: mediaAlumno();
                break;
                case 6: mediaMateria();
                break;
                case 7: maxMinMateria();
                break;
                case 8: modificarNota();
                break;
                case 9: System.out.println("Abur!");
                break;
                default: System.out.println("Opción no válida");
            }
        }while(opcion!=9);

    }

    public void muestraTabla(){
        String espacio=" ";
        System.out.printf("%12s|", espacio);
        for(int i=0; i<aula.getMaterias().length; i++){
            System.out.printf("| %s |", aula.getMaterias()[i]);
        }
        System.out.println();
        for(int i=0; i<aula.getAlumnos().length; i++){
            System.out.printf("| Alumno %2d |", i);  
            for(int j=0; j<aula.getNotas()[i].length; j++){
                System.out.printf("|%4s%2d%5s|", espacio, aula.getNotas()[i][j], espacio);                
            }
            System.out.println();
        }
    }

    public void muestraNotasAlumno(){
        String espacio=" ";
        int alumno;
        System.out.printf("Introduce número de alumno\nRango: 0 a %d: ", aula.getAlumnos().length-1);
        alumno=Integer.parseInt(sc.nextLine());
        if(alumno<0 || alumno >= aula.getAlumnos().length){
            System.out.println("Posición no válida");
        }else{
            System.out.printf("%12s|", espacio);
            for(int i=0; i<aula.getMaterias().length; i++){
                System.out.printf("| %s |", aula.getMaterias()[i]);
            }
            System.out.println();
            System.out.printf("| Alumno %2d |",alumno);
            for(int j=0; j<aula.getNotas()[alumno].length; j++){
                System.out.printf("|%4s%2d%5s|", espacio, aula.getNotas()[alumno][j], espacio);                
            }
            System.out.println(); 
        }
        
    }

    public void muestraNotasMateria(){
        int materia;
        System.out.printf("Introduce número de materia\nRango: 0 a %d: ", aula.getMaterias().length-1);
        materia=Integer.parseInt(sc.nextLine());
        if(materia<0 || materia>=aula.getMaterias().length){
            System.out.println("Posición no válida");
        }else{
            String espacio=" ";
            System.out.printf("%12s|", espacio);
            System.out.printf("| Materia %d |\n", materia);
            for(int i=0; i<aula.getNotas().length; i++){
                System.out.printf("| %9s ||%4s%2d%5s|\n", aula.getAlumnos()[i], espacio, aula.getNotas()[i][materia], espacio); 
            }
        }
    }

    public void mediaNotasGlobal(){
        System.out.printf("Media de notas global: %.2f\n", aula.mediaNotasTotal());
    }

    public void mediaAlumno(){
        int alumno;
        System.out.printf("Introduce número de alumno\nRango: 0 a %d: ", aula.getAlumnos().length-1);
        alumno=Integer.parseInt(sc.nextLine());
        if(alumno<0 || alumno>=aula.getAlumnos().length){
            System.out.println("Posición no válida");
        }else{
            System.out.printf("Media del alumno: %.2f\n", aula.mediaAlumno(alumno));
        }
    }

    public void mediaMateria(){
        int materia;
        System.out.printf("Introduce número de materia\nRango: 0 a %d: ", aula.getMaterias().length-1);
        materia=Integer.parseInt(sc.nextLine());
        if(materia<0 || materia>=aula.getMaterias().length){
            System.out.println("Posición no válida");
        }else{
            System.out.printf("Media de la materia: %.2f\n", aula.mediaMateria(materia));
        }
    }

    public void maxMinMateria(){
        int materia;
        System.out.printf("Introduce número de materia\nRango: 0 a %d: ", aula.getMaterias().length-1);
        materia=Integer.parseInt(sc.nextLine());
        if(materia<0 || materia >= aula.getMaterias().length){
            System.out.println("Posición no válida");    
        }else{
            System.out.printf("Máximo: %d\nMínimo: %d\n", aula.maxNotaMateria(materia), aula.minNotaMateria(materia));
        }
    }

    public void modificarNota(){
        int alumno;
        int materia;
        int nota;
        System.out.printf("Introduce número de alumno\nRango: 0 a %d: ", aula.getAlumnos().length-1);
        alumno=Integer.parseInt(sc.nextLine());
        if(alumno<0|| alumno >= aula.getAlumnos().length){
            System.out.println("Posición no válida");
        }else{
            System.out.printf("Introduce número de materia\nRango: 0 a %d: ", aula.getMaterias().length-1);
            materia=Integer.parseInt(sc.nextLine());
            if(materia < 0 || materia >= aula.getMaterias().length){
                System.out.println("Posición no válida");
            }else{
                System.out.println("Introduce nota");
                nota=Integer.parseInt(sc.nextLine());
                if(nota < 0 || nota > 10){
                    System.out.println("Nota no válida");    
                }else{
                    aula.setNotas(nota, alumno, materia);
                }
            }
          
        }
        
    }

}