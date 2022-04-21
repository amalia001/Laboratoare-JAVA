import java.io.*;
import java.util.ArrayList;

public class Dictionary {

    public boolean isWord(String str){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Amalia\\Desktop\\dictionar.txt"));
            String line = reader.readLine();
            while (line != null) {
                if(str.equals(line)){
                    return true;
                }
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
