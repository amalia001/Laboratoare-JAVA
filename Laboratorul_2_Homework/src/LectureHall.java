public class LectureHall extends Room {
    private boolean videoProjector;

    public LectureHall(){}

    public LectureHall(String name, int capacity, boolean videoProjector){
        this.name=name;
        this.capacity=capacity;
        this.videoProjector=videoProjector;
    }

    public void setVideoProjector(boolean videoProjector) {
        this.videoProjector = videoProjector;
    }

    public boolean isVideoProjector() {
        return videoProjector;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity=capacity;
    }

    @Override
    public String toString() {
        return " Room: LectureHall {" +
                "videoProjector=" + videoProjector +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}' ;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
