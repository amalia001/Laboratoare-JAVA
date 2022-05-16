//package Lab_5_Compulsory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private List<Item> items = new ArrayList<>();
    private String name;

    public Catalog(String name) {this.name=name;}

    public void addToCatalog(Item i)
    {
        items.add(i);
    }

    public void save(String filename){
        //var mapper = new ObjectMapper();
        //mapper.writeValue(new File("./catalog.json"), catalog);
        //JSONObject
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Catalog: " + name + "\n");
        sb.append("----------------------------------------------------\n");
        for (Item item : items) {
            sb.append(item.toString() + "\n");
        }
        sb.append("----------------------------------------------------\n");
        return sb.toString();
    }
}
