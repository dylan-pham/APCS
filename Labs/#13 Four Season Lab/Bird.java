import java.awt.Color;
import java.awt.Graphics;

public class Bird {
    private int x;
    private int y;
    
    public Bird() {
        x = (int)(Math.random() * 800);
        y = (int)(Math.random() * 600);
    }
     
    public void drawMe(Graphics g, Color c) {
        g.setColor(c);
        g.fillRect(x, y, 7, 2);
        g.fillRect(x + 2, y - 2, 2, 4);
    }
     
    public void move() {
        x += (int)(Math.random() * 10);
        y += (int)(Math.random() * 10);
        
        if ( y > 600 || x > 800 ) {
            y = (int)(Math.random() * 600);
            x = (int)(Math.random() * 800);
        }
    }
}