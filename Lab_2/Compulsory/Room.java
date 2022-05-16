package Compulsory;
//import Compulsory.RoomType;

public class Room {
    private String name;
    private int capacity;
    private RoomType type;

   public Room(){}
    public Room(String name, RoomType type){
       this.name=name;
       this.type=type;
   }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", type=" + type +
                '}';
    }
}
