package Lab_5_Homework;

import java.io.IOException;

public class FileInaccessibleException extends Exception {
    public FileInaccessibleException(IOException e) {
        super(e);
    }
}
