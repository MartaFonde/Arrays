package app;
public class AulaMain{
    public static void main(String[] args) {
        Aula aulaNueva=new Aula(15, 4);
        MenuAula menu=new MenuAula(aulaNueva);
        menu.mostrarMenu();
    }
}