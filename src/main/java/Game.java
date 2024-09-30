import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;

public class Game {
    private final TerminalScreen screen;
    //private int x =10;
    //private int y =10;
    //private Hero hero ;
    private Arena arena;


    public Game(int  width, int height) throws IOException {

        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
        //TerminalSize terminalSize = new TerminalSize(width, height);
        //hero = new Hero (10,10);
        arena = new Arena(width, height);
    }
    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen);
        screen.refresh();
        //hero.draw(screen);

    }
    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                screen.close();
            if (key.getKeyType() == KeyType.EOF)
                break;
            //processKey(key);
            arena.processKey(key);
        }
    }
    /*private void processKey (KeyStroke key){
        System.out.println(key);
        String keyT = key.getKeyType().toString();
        switch (keyT){
            case"ArrowUp":
                moveHero(hero.moveUp());
                break;
            case"ArrowDown":
                moveHero(hero.moveDown());
                break;
            case"ArrowLeft":
                moveHero(hero.moveLeft());
                break;
            case"ArrowRight":
                moveHero(hero.moveRight());
                break;

        }*/
}

   // private void moveHero(Position position) {
        //hero.setPosition(position);
    //}



