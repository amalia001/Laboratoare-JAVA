import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        System.out.println(this.getName());
        System.out.println(extracted.toString());


        String word=null;
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       try {
            word = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int scor=0;
        for(int i=0;i<word.length();i++){
            scor+=game.getBag().charPoints(word.charAt(i));
        }

        game.getBoard().addWord(this, word);
       System.out.println(scor);
        sleep(500);

        return true;

    }


    public void run(){
        try {
            while(submitWord()){
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}


