import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> bag = new ArrayList<>();

    public Bag() {

        bag.add(new Tile('J', 8));
        bag.add(new Tile('K', 5));
        bag.add(new Tile('Q', 10));
        bag.add(new Tile('X', 8));
        bag.add(new Tile('Z', 10));

        for(int i=0;i<9;i++) {
            bag.add(new Tile('A', 1));
            bag.add(new Tile('I', 1));
        }
        for(int i=0;i<2;i++){
            bag.add(new Tile('B', 3));
            bag.add(new Tile('C', 3));
            bag.add(new Tile('H', 4));
            bag.add(new Tile('P', 3));
            bag.add(new Tile('V', 4));
            bag.add(new Tile('Y', 4));
            bag.add(new Tile('M', 1));
            bag.add(new Tile('F', 4));
            bag.add(new Tile('W', 4));
        }
        for(int i=0;i<4;i++) {
            bag.add(new Tile('S', 1));
            bag.add(new Tile('L', 1));
            bag.add(new Tile('U', 1));
        }
        for(int i=0;i<12;i++)
            bag.add(new Tile('E', 1));

        for(int i=0;i<8;i++)
            bag.add(new Tile('O', 1));

        for(int i=0;i<6;i++) {
            bag.add(new Tile('N', 1));
            bag.add(new Tile('R', 1));
            bag.add(new Tile('T', 1));
        }
    }

    public int charPoints(char c){
        for(Tile t : bag){
            if(t.getLetter()==c)
            {return t.getPoints();}
        }
        return 0;
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
