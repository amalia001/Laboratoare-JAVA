package Lab_5_Homework;

import java.util.ArrayList;
import java.util.List;

public class AddCommand extends Command{
    private List<Item> items = new ArrayList<>();

    public void AddCom(List<Item> items, Item i)
    {
        items.add(i);
    }

    public void showCommand(){
        System.out.println("Comanda de adaugare in catalog");
    }
}
