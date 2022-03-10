public abstract class Room {
    protected String name;
    protected int capacity;

    abstract public String getName();

    abstract public void setName(String name);

    abstract public int getCapacity();

    abstract public void setCapacity(int capacity);


}
