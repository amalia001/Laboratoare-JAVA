package Lab_5_Homework;

import java.util.ArrayList;
import java.util.List;

public class AddCommand extends Command{
    private List<Item> items = new ArrayList<>();
    private Catalog c;

    public AddCommand(Catalog c) {
        this.c = c;
        this.items=items;
    }

//    public void AddCom(List<Item> items, Item i)
//    {
//        items.add(i);
//    }

    public void execute() {
        items.add(i);
    }
}
