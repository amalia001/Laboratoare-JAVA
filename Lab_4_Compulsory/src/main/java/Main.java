/**
 * @author Gradinariu Amalia-laura 2E3
 */

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main (String[] args) {

         Set<Intersection> nodeList = new HashSet<>();
         List<Street> retea = new LinkedList<>();

        var nodes = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        Collections.addAll(nodeList, nodes);

        retea.add(new Street("a", 2, nodes[1], nodes[2]));
        retea.add(new Street("b", 2, nodes[1], nodes[4]));
        retea.add(new Street("c", 2, nodes[1], nodes[3]));
        retea.add(new Street("d", 3, nodes[2], nodes[6]));
        retea.add(new Street("e", 2, nodes[2], nodes[4]));
        retea.add(new Street("f", 1, nodes[3], nodes[4]));
        retea.add(new Street("g", 2, nodes[4], nodes[5]));
        retea.add(new Street("h", 2, nodes[4], nodes[7]));
        retea.add(new Street("i", 1, nodes[5], nodes[6]));
        retea.add(new Street("j", 3, nodes[5], nodes[9]));
        retea.add(new Street("k", 1, nodes[7], nodes[9]));
        retea.add(new Street("l", 2, nodes[6], nodes[9]));
        retea.add(new Street("m", 1, nodes[8], nodes[9]));
        retea.add(new Street("n", 1, nodes[7], nodes[8]));
        retea.add(new Street("o", 1, nodes[6], nodes[8]));
        retea.add(new Street("p", 3, nodes[3], nodes[5]));

        retea.sort(Street::compareTo);
        retea.forEach(System.out::println);

    }

}
