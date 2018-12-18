import java.awt.Color;
import java.awt.Graphics;

public class Star {
    private double x;
    private double y;
    private Color yellow;
    private Color blue;

    public Star(double x, double y) {
        this.x = x;
        this.y = y;
        yellow = new Color(237, 221, 54);
        blue = new Color(66, 152, 244);
    }

    public void drawMe(Graphics g) {
        g.setColor(yellow);
        g.fillOval((int)(x), (int)(y), 3, 3);
    }

    public void drawMe2(Graphics g) {
        g.setColor(blue);
        g.fillOval((int)(x), (int)(y), 3, 3);
    }

    public void move() {
        x -= 0.1;
    }
}