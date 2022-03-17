/**
 * @author Gradinariu Amalia-laura 2E3
 */
public class Street implements Comparable<Street>{
    private String name;
    private int length;
    private Intersection i1, i2;

    public Street(String name, int length, Intersection i1, Intersection i2) {
        this.name = name;
        this.length = length;
        this.i1=i1;
        this.i2=i2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", i1=" + i1 +
                ", i2=" + i2 +
                '}';
    }

    @Override
    public int compareTo(Street other) {
        if(this.length>other.length)
            return 1;
        else
        if(this.length<other.length)
            return -1;
        return 0;
    }
}
