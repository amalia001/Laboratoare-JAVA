/**
 * @author Gradinariu Amalia-laura 2E3
 */

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main (String[] args) {

        Set<Intersection> intersectii = new HashSet<>();
        List<Street> strazi = new LinkedList<>();

        var nodes = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        Collections.addAll(intersectii, nodes);

        strazi.add(new Street("a", 2, nodes[1], nodes[2]));
        strazi.add(new Street("b", 2, nodes[1], nodes[4]));
        strazi.add(new Street("c", 2, nodes[1], nodes[3]));
        strazi.add(new Street("d", 3, nodes[2], nodes[6]));
        strazi.add(new Street("e", 2, nodes[2], nodes[4]));
        strazi.add(new Street("f", 1, nodes[3], nodes[4]));
        strazi.add(new Street("g", 2, nodes[4], nodes[5]));
        strazi.add(new Street("h", 2, nodes[4], nodes[7]));
        strazi.add(new Street("i", 1, nodes[5], nodes[6]));
        strazi.add(new Street("j", 3, nodes[5], nodes[9]));
        strazi.add(new Street("k", 1, nodes[7], nodes[9]));
        strazi.add(new Street("l", 2, nodes[6], nodes[9]));
        strazi.add(new Street("m", 1, nodes[8], nodes[9]));
        strazi.add(new Street("n", 1, nodes[7], nodes[8]));
        strazi.add(new Street("o", 1, nodes[6], nodes[8]));
        strazi.add(new Street("p", 3, nodes[3], nodes[5]));

        strazi.sort(Street::compareTo);
        strazi.forEach(System.out::println);

        City oras = new City(strazi, intersectii);
        System.out.println();
        oras.displayStreets(2);


        Set<Intersection> intersections = new HashSet<>();
        List<Street> streets = new LinkedList<>();

        Faker faker = new Faker();

        var intersectiiFake = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Intersection(faker.address().state()))
                .toArray(Intersection[]::new);

        Collections.addAll(intersections, intersectiiFake);

        streets.add(new Street(faker.address().streetName(), 2, intersectiiFake[1], intersectiiFake[2]));
        streets.add(new Street(faker.address().streetName(), 2, intersectiiFake[1], intersectiiFake[4]));
        streets.add(new Street(faker.address().streetName(), 2, intersectiiFake[1], intersectiiFake[3]));
        streets.add(new Street(faker.address().streetName(), 3, intersectiiFake[2], intersectiiFake[6]));
        streets.add(new Street(faker.address().streetName(), 2, intersectiiFake[2], intersectiiFake[4]));
        streets.add(new Street(faker.address().streetName(), 1, intersectiiFake[3], intersectiiFake[4]));
        streets.add(new Street(faker.address().streetName(), 2, intersectiiFake[4], intersectiiFake[5]));
        streets.add(new Street(faker.address().streetName(), 2, intersectiiFake[4], intersectiiFake[7]));
        streets.add(new Street(faker.address().streetName(), 1, intersectiiFake[5], intersectiiFake[6]));
        streets.add(new Street(faker.address().streetName(), 3, intersectiiFake[5], intersectiiFake[9]));
        streets.add(new Street(faker.address().streetName(), 1, intersectiiFake[7], intersectiiFake[9]));
        streets.add(new Street(faker.address().streetName(), 2, intersectiiFake[6], intersectiiFake[9]));
        streets.add(new Street(faker.address().streetName(), 1, intersectiiFake[8], intersectiiFake[9]));
        streets.add(new Street(faker.address().streetName(), 1, intersectiiFake[7], intersectiiFake[8]));
        streets.add(new Street(faker.address().streetName(), 1, intersectiiFake[6], intersectiiFake[8]));
        streets.add(new Street(faker.address().streetName(), 3, intersectiiFake[3], intersectiiFake[5]));

        System.out.println();
        streets.forEach(System.out::println);


        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        // Function call
        graph.KruskalMST();

    }

}
