package Laboratorul_5_Homework;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Book b = new Book("45666", "Accidentul", "Desktop");
        Magazine m=new Magazine("64638", "Invitatia la vals", "Desktop");
        Article a=new Article("74646", "Orasul cu salcami", "Desktop");

        b.addTag("author", "Mihail Sebastian");
        b.addTag("year", "1920");
        m.addTag("author", "Mihail Drumes");
        a.addTag("year", "2020");

        Catalog c = new Catalog("Bibliography");
        c.addToCatalog(b);
        c.addToCatalog(m);
        c.addToCatalog(a);
        c.save("./catalog.json");

        Catalog c2=new Catalog();
        c2.load("./catalog.json");
        System.out.println(c2);
    }
}
