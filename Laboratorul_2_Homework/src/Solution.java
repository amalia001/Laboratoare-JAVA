import java.util.ArrayList;
public class Solution {
    private Problem p;
    ArrayList<Room> emptyRooms;
    ArrayList<Event> incomingEvents;

    public Solution(Problem p )
    {
        this.emptyRooms=p.getSali();
        this.incomingEvents=p.getEvenimente();
    }

    public void sortare(){
        for(int i=0;i< p.getSizeOfEvents()-1;i++)
        {
            for(int j=0;j< p.getSizeOfEvents();j++)
                if(emptyRooms[i])
        }
    }
    /*
    Comparator<Room> compareByCapacity = new Comparator<Room>() {
        public int compare(Room o1, Room o2) {
            return o1.getCapacity().compareTo(o2.getCapacity());
        }

     */
}


