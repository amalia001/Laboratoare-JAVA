package Lab_5_Homework;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class ViewCommand extends Command{

    public void ViewCom(Catalog c){
        System.out.println("Enter the id of the item you want to view: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        Item item = c.findById(String.valueOf(id));

        if (item == null) {
            System.out.println("Item not found");
        } else {

            try {
                // Check if the location is a file or an URL open Desktop
                Desktop desktop = Desktop.getDesktop();
                if (item.getLocation().startsWith("http")) {
                    desktop.browse(new URI(item.getLocation()));
                } else {
                    desktop.open(new File(item.getLocation()));
                }
            } catch (Exception e) {
                System.out.println("Error opening file");
            }

        }
    }

    public void showCommand(){
        System.out.println("Comanda de afiasare a catalogului");
    }
}



