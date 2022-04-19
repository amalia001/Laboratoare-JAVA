import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;

    public Player(String name) { this.name = name; }

    public void setGame(Game game) {
        this.game = game;
    }

    private boolean submitWord() throws InterruptedException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }

        //create a word with all the extracted tiles;
        String word = extracted.toString();

        game.getBoard().addWord(this, word);
        sleep(50);
        return true;
    }
    public void run(){
        try {
            submitWord();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}
