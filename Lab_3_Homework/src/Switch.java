/**
 * @author Gradinariu Amalia-Laura
 */
public class Switch extends Node implements Identifiable {
    private String address;

    public Switch(String name, String address) {
        super(name);
        this.address = address;
    }

    @Override
    public String getType() {
        return "Switch";
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return '\n' +
                "Switch{" +
                super.toString() + ' ' +
                "address='" + address + '\'' +
                '}';
    }
}
