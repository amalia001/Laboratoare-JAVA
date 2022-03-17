/**
 * @author Gradinariu Amalia-Laura
 */
public class Router extends Node implements Identifiable {
    private String address;

    public Router(String name, String address) {
        super(name);
        this.address = address;
    }

    @Override
    public String getType() {
        return "Router";
    }


    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return '\n' +
                "Router{" +
                super.toString() + ' ' +
                "address='" + address + '\'' +
                '}';
    }
}
