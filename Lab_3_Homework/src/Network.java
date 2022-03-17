/**
 * @author Gradinariu Amalia-Laura
 */
import java.util.*;

public class Network {
    private List<Node> nodes;

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    //functie pentru a sorta nodurile dupa address
    public static void sortIdentifiables(List<Node> list)
    {
        list.sort(Comparator.comparing(Node::getAddress));
    }

    //functie care afiseaza nodurile Identifiable sortate dupa adresa
    public void showIdentifiable(){
        List<Node> nodesIdentifiables=new ArrayList<>();
        for( Node n : nodes) {
            if(n instanceof Identifiable)
                 nodesIdentifiables.add(n);
        }
        sortIdentifiables(nodesIdentifiables);
        System.out.println("Nodurile Identifiable sortate dupa adresa: ");
        System.out.println(nodesIdentifiables);
    }

    @Override
    public String toString(){
        Collections.sort(nodes);
        return
                " Network - nodes : " + '\n' +  nodes + " ";
    }


}
