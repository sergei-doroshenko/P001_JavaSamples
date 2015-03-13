package _7_inheritance;

/**
 * Created by Sergei on 04.03.2015.
 */

class Game{
    public void play() throws Exception{
        System.out.println("Playing...");
    }
}

public class Soccer extends Game {

    public void play(){
        System.out.println("Playing Soccer...");
    }

    public static void main(String[] args) throws Exception { // Soccer's play() method doesn't throws any exception
        // but it's super class throws, so you must handle this exception
        Game g = new Soccer();
        g.play();
    }
}
