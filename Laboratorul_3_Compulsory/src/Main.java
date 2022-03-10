/**
 * @author Gradinariu Amalia-Laura
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){

            Node v1 = new Computer("A", "6353", 512);
            Node v2 = new Router("M", "363");
            Node v3 = new Switch("B", "74645");
            Node v4 = new Router("Z", "64646");
            Node v5 = new Computer("A", "6454", 1028);
            Node v6 = new Switch("A", "2553");

            v1.setCost(v2, 10);
            v1.setCost(v3, 50);
            v2.setCost(v3, 20);
            v2.setCost(v4, 20);
            v2.setCost(v5, 10);
            v3.setCost(v4, 20);
            v4.setCost(v5, 30);
            v4.setCost(v6, 10);
            v5.setCost(v6, 20);

            List<Node> nodes = new ArrayList<>();
            nodes.add(v1);
            nodes.add(v2);
            nodes.add(v3);
            nodes.add(v4);
            nodes.add(v5);
            nodes.add(v6);

            Network net1 = new Network(nodes);
            Collections.sort(net1.getNodes());
            System.out.println(net1);
    }
}
