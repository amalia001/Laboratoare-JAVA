package Lab_5_Homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private List<Item> items = new ArrayList<>();
    private String name;

    public Catalog(){}

    public Catalog(String name, List<Item> items) {this.name=name; this.items=items;}

    public void addToCatalog(Item i)
    {
        items.add(i);
    }

    public void save(String filename) throws FileInaccessibleException {
        var mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filename), this);
        } catch (IOException e) {
            System.out.println("File inaccessible");
            throw  new FileInaccessibleException(e);
        }
    }

    public void load(String filename) throws IOException {
        var mapper = new ObjectMapper();
        var catalog = mapper.readValue(new File(filename), Catalog.class);
        this.name = catalog.name;
        this.items = catalog.items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Item findById(String id){
        for(Item i : items)
            if(i.getId().equals(id))
                return i;

        return null;
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
