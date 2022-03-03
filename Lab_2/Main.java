public class Main {
    public static void main(String[] args){
        Event c1 = new Event();
        c1.setName("C1");
        c1.setSize(100);
        c1.setStartTime(8);
        c1.setEndTime(10);
        System.out.println(c1);

        Event c2 = new Event();
        c2.setName("C2");
        c2.setSize(100);
        c2.setStartTime(10);
        c2.setEndTime(12);
        System.out.println(c2);

        Event c3 = new Event();
        c3.setName("L1");
        c3.setSize(30);
        c3.setStartTime(8);
        c3.setEndTime(10);
        System.out.println(c3);

        Event c4 = new Event();
        c4.setName("L2");
        c4.setSize(30);
        c4.setStartTime(8);
        c4.setEndTime(10);
        System.out.println(c4);

        Event c5 = new Event();
        c5.setName("L3");
        c5.setSize(30);
        c5.setStartTime(10);
        c5.setEndTime(12);
        System.out.println(c5);

        //Rooms: 401(cap=30, lab), 403(cap=30, lab), 405(cap=30, lab), 309(cap=100, lecture hall)
        Room d1 = new Room("401", RoomType.COMPUTER_LAB);
        d1.setCapacity(30);
        System.out.println(d1);

        Room d2 = new Room("403", RoomType.COMPUTER_LAB);
        d2.setCapacity(30);
        System.out.println(d2);

        Room d3 = new Room("405", RoomType.COMPUTER_LAB);
        d3.setCapacity(30);
        System.out.println(d3);

        Room d4 = new Room("309", RoomType.LECTURE_HALL);
        d4.setCapacity(100);
        System.out.println(d4);
    }
}
