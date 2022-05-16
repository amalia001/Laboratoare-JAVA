import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Room> listaSali = new ArrayList<Room>();
        listaSali.add(new LectureHall("L302", 35, true));
        listaSali.add(new ComputerLab("L544", 45, "Linux"));
        listaSali.add(new LectureHall("L404", 30, false));

        ArrayList<Event> listaEvenimente = new ArrayList<Event>();
        listaEvenimente.add(new Event("Seminar Eng", 25));
        listaEvenimente.add(new Event("Seminar IP", 30));
        listaEvenimente.add(new Event("Seminar PA", 35));

        System.out.println(listaEvenimente);
        System.out.println(listaSali);


    }
}
