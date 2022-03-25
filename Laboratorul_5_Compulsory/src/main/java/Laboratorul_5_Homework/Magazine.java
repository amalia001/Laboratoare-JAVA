package Laboratorul_5_Homework;

public class Magazine extends Item{
    private String type;

    public Magazine(){}
    public Magazine(String id, String title, String location){
        super(id, title, location);
        type="Magazine";
    }

    public void addTag(String key, Object obj){
        tags.put(key, obj);
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Magazine { " +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}' + '\'' ;
    }
}
