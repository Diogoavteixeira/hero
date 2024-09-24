import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Hero {
    int x;
    int y;

    public Hero(int x, int y) {
        this.x=x;
        this.y=y;

    }
    public void draw(Screen screen) throws IOException{
        screen.setCharacter(this.x, this.y, TextCharacter.fromCharacter('X')[0]);
    }
    public void moveup() {
        this.y =this.y -1;

    }
    public void movedown() {
        this.y = this.y + 1;
    }
    public void moveleft() {
        this.x =this.x -1;

    }
    public void moveright() {
        this.x = this.x + 1;
    }
}
