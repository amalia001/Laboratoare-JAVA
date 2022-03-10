/**
 * @author Gradinariu Amalia-Laura
 */
import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {

    protected String name;
    private Map<Node, Integer> cost = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(Node other) {
        if (name != null)
            return this.name.compareTo(other.name);
        return 0;
    }
}
