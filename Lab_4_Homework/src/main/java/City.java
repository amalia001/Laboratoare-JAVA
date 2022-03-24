import java.util.*;
import java.util.stream.Collectors;

public class City {
    private List<Street> strazi = new LinkedList<>();
    private Set<Intersection> intersectii = new HashSet<>();

    public City(List<Street> strazi, Set<Intersection> intersectii) {
        this.strazi = strazi;
        this.intersectii = intersectii;
    }

    public List<Street> getStrazi() {
        return strazi;
    }

    public void setStrazi(List<Street> strazi) {
        this.strazi = strazi;
    }

    public Set<Intersection> getIntersectii() {
        return intersectii;
    }

    public void setIntersectii(Set<Intersection> intersectii) {
        this.intersectii = intersectii;
    }

    public void displayStreets(int value){
        System.out.println("Strazile cu lungime mai mare decat " + value + " si care intra intr-o intersectie in care mai intra minim 3 strazi sunt: ");
        strazi.stream()
                .filter(str->str.getLength()>value)
                .filter(str -> str.getNrOfAdjacentStreets()>3)
                .forEach(System.out::println);

    }

}


