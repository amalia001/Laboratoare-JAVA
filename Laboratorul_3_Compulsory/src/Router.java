/**
 * @author Gradinariu Amalia-Laura
 */
public class Router extends Node implements Identifiable{
    private String address;

    public Router(String name, String address) {
        super(name);
        this.address=address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return  '\n' +
                "Router{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
