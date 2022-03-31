package Lab_5_Homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadCommand {

    public void loadCom(String filename) throws FileNotFoundException  {
        var mapper = new ObjectMapper();
        Catalog catalog = null;
        try {
            catalog = mapper.readValue(new File(filename), Catalog.class);
            catalog.load(filename);
            System.out.println("Catalog printat din fisierul catalog.json: ");
            //System.out.println(catalog);
            BufferedReader br = new BufferedReader(new FileReader("./catalog.json"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found.");
            throw new FileNotFoundException(e);
        }
    }
}

