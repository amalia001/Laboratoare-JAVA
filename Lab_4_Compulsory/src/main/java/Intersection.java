/**
 * @author Gradinariu Amalia-laura 2E3
 */
public class Intersection implements Comparable<Intersection> {
    private  String name;

    public Intersection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Intersection { " +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Intersection)) return false;
        Intersection that = (Intersection) o;
        return name.equals(that.name);
    }

    @Override
    public int compareTo(Intersection o) {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
