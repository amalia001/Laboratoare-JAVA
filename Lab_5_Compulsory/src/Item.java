//package Lab_5_Compulsory;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {
    protected String id;
    protected String title;
    protected String location;
    protected Map<String, Object> tags = new HashMap<>();

    public Item(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public abstract void addTag(String key, Object obj);

    @Override
    public String toString() {
        return "Item{" +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
