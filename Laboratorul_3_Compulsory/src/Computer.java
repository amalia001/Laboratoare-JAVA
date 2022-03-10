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
                "name='" + name + '\'' +
                "address='" + address + '\'' +
                ", storageCapacity=" + storageCapacity +
                '}';
    }
}
