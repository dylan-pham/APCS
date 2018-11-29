import java.awt.Color;
import java.awt.Graphics;

public class Tree {
    private int x;
    private int y;
    
    public Tree() {
        x = (int)(Math.random() * 800);
        y = (int)(Math.random() * 150 + 400);
    }

    public void drawMe(Graphics g, Color c1, Color c2) {
        g.setColor(c1);
        g.fillRect(x, y, 20, 50);

        g.setColor(c2);
        g.fillOval(x - 10, y - 30, 40, 40);
    }

    public void drawTrunk(Graphics g, Color c1) {
        g.setColor(c1);
        g.fillRect(x, y, 20, 50);
    }
}