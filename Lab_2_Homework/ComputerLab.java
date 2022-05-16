public class ComputerLab extends Room {
    private String sistemOperare;

    public ComputerLab() {
    }

    public ComputerLab(String name, int capacity, String sistemOperare) {
        this.name = name;
        this.capacity = capacity;
        this.sistemOperare = sistemOperare;
    }

    public void setSistemOperare(String sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    public String getSistemOperare() {
        return sistemOperare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "ComputerLab{" +
                "sistemOperare='" + sistemOperare + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
