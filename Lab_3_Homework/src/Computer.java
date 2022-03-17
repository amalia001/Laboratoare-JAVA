/**
 * @author Gradinariu Amalia-Laura
 */
public class Computer extends Node implements Identifiable, Storage {

    private String address;
    private int storageCapacity;

    public Computer(String name, String address, int storageCapacity) {
        super(name);
        this.address=address;
        this.storageCapacity=storageCapacity;

    }

    public String getType() {
        return "Computer";}

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    @Override
    public String toString() {
        return  '\n' +
                "Computer{" +
                super.toString() + ' ' +
                "address='" + address + '\'' +
                ", storageCapacity = " + storageCapacity  + ' ' + getStorageUnit() +
                '}';
    }

}
