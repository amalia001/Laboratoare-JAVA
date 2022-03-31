package Lab_5_Homework;

public class Article extends Item{
    private String type;

    public Article(){}

    public Article(String id, String title, String location){
        super(id, title, location);
        type="Book";
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
        return "Article { " +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}' + '\'' ;
    }
}