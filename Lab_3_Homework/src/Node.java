/**
 * @author Gradinariu Amalia-Laura
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Node implements Comparable<Node> {

    protected String name;
    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    private Map<Node, Integer> cost = new HashMap<>();

    abstract public String getType();

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public String getAddress();

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String printCosts(Map<Node, Integer> cost){
        StringBuilder result= new StringBuilder();
        for(Map.Entry<Node, Integer> element : cost.entrySet()){
            Node n = element.getKey();
            Integer c= element.getValue();
            result.append("catre ").append(n.getType()).append(' ').append(n.getName()).append(" este ").append(c).append(", ");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return " Node {" +
                "name='" + name +
                ", cost: " + printCosts(this.cost) + ',';
    }

    @Override
    public int compareTo(Node other) {
        if (name != null)
            return this.name.compareTo(other.name);
        return 0;
    }


}
