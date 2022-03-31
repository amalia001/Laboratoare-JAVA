package Lab_5_Homework;

import java.io.IOException;

public class FileNotFoundException extends Exception {
    public FileNotFoundException(IOException e) {
        super(e);
    }
}
