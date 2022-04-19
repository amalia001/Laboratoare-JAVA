import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> bag = new ArrayList<Tile>();

    public Bag() {
        for(int i=0;i<10;i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                Random r = new Random();
                int x = r.nextInt(10);
                bag.add(new Tile(c, x));
            }
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (bag.isEmpty()) {
                break;
            }
            Random r = new Random();
            int x = r.nextInt(bag.size());
            extracted.add(bag.get(x));
            bag.remove(x);
        }
        return extracted;
    }

    public List<Tile> getBag() {
        return bag;
    }
}
