import java.awt.Color;
import java.awt.Graphics;

public class RainDrop {
    private int x;
    private int y;
    private Color blue;
     
    public RainDrop() {
        x = (int)(Math.random() * 800);
        y = (int)(Math.random() * 600);
        blue = new Color(0, 0, 255);
    }
     
    public void drawMe(Graphics g) {
        g.setColor(blue);
        g.fillRect(x, y, 2, 5);
    }
     
    public void move() {
        y++;
        
        if( y > 600 ) {
            y = 0;
            x = (int)(Math.random() * 800);
        }
    }
}