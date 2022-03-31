package Lab_5_Homework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();
        Book b = new Book("4", "Accidentul", "C:\\Users\\Amalia\\Desktop\\Anul 1 sem 2\\OOP\\Laboratoare-JAVA\\Laboratorul_5_Compulsory");
        Magazine m = new Magazine("6", "Invitatia la vals", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
        Article a = new Article("74646", "Orasul cu salcami", "https://www.101books.ru/carte/descarca-mihail-sebastian-accidentul-si-orasul-cu-salcami-pdf");

//        b.addTag("author", "Mihail Sebastian");
//        b.addTag("year", "1920");
//        m.addTag("author", "Mihail Drumes");
//        a.addTag("year", "2020");

        //AddCommand adaugare = new AddCommand(b);
        //AddCommand adaugare1 = new AddCommand(m);
        //AddCommand adaugare2 = new AddCommand(a);
        //c.addToCatalog(b);
        //c.addToCatalog(m);
        //c.addToCatalog(a);
        //c.save("./catalog.json");

        //Catalog c2=new Catalog();
        //c2.load("./catalog.json");
        //System.out.println(c2);

        AddCommand ad = new AddCommand();
        ad.AddCom(items, b);
        AddCommand ad2 = new AddCommand();
        ad2.AddCom(items, m);
        AddCommand ad3 = new AddCommand();
        ad3.AddCom(items, a);

        Catalog c = new Catalog("Bibliography", items);

        ListCommand l = new ListCommand();
        l.ListCom(c);

        ViewCommand v = new ViewCommand();
        v.ViewCom(c);

        c.save("./catalog.json");

        LoadCommand lc = new LoadCommand();
        try {
            lc.loadCom("./catalog.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ReportCommand rc = new ReportCommand();
        rc.ReportCom(c);
    }
}