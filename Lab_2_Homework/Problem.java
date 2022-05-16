import java.util.ArrayList;

public class Problem {
    private ArrayList<Event> listaEvenimente;
    private ArrayList<Room> listaSali;

    public void addEvent(Event e) {
        if (!(listaEvenimente.contains(e)))
            listaEvenimente.add(e);
    }

    public void addRoom(Room r) {
        if (!(listaSali.contains(r)))
            listaSali.add(r);
    }

    public ArrayList<Event> getEvenimente()
    {
        return listaEvenimente;
    }

    public ArrayList<Room> getSali()
    {
        return listaSali;
    }


}
