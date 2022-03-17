/**
 * @author Gradinariu Amalia-Laura
 */
import java.util.ArrayList;
import java.util.Arrays;

public interface Storage {

    int getStorageCapacity();

    //Create a default method in the interface Storage, that is able to return the storage capacity
    // in other units of storage (megabyte, kilobyte, byte).

    default String getStorageUnit(){
        ArrayList<String> storageUnits = new ArrayList<>(Arrays.asList("B", "KB", "MB", "TB"));
        int randomNum = (int) (Math.random() * 3);
        return storageUnits.get(randomNum);
    }
}
