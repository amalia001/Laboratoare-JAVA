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

       /*
        public int compareTo() {
            return this.getCapacity().compareTo(r.getCapacity());
        }

        public boolean compare(Object object1, Object object2) {
        return object1.getStartDate().before(object2.getStartDate());
    }
        Comparator<Room> compareByCapacity = new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o1.getCapacity().compareTo(o2.getCapacity());
            }
        };

        Collections.sort(listaSali, );

        */
    }
}
