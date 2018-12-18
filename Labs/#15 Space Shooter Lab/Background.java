import java.awt.Color;
import java.awt.Graphics;

public class Background {
    private double x;
    private Color black;
    private Color gray;
    private Color purple;
    private Color green;
    private Color yellow;
    private Color blue;
    private Color orange;

    public Background(int x) {
        this.x = x;
        black = new Color(0, 0, 0);
        gray = new Color(136, 145, 160);
        purple = new Color(86, 43, 119);
        green = new Color(54, 196, 151);
        yellow = new Color(237, 221, 54);
        blue = new Color(65, 244, 143);
        orange = new Color(244, 149, 70);
    }

    public void drawMe(Graphics g) {
        g.setColor(black);
        g.fillRect(0, 0, 850, 650);

        g.setColor(gray);
        g.fillOval((int)(x), 500, 1500, 1500);

        g.setColor(purple);
        g.fillOval((int)(x) + 700, 200, 100, 100);

        g.setColor(green);
        g.fillOval((int)(x) + 400, 100, 30, 30);

        g.setColor(yellow);
        g.fillOval((int)(x) + 1000, 300, 70, 70);
    }

    public void drawMe2(Graphics g) {
        g.setColor(black);
        g.fillRect(0, 0, 850, 650);

        g.setColor(blue);
        g.fillOval((int)(x) + 500, 100, 250, 250);

        g.setColor(orange);
        g.fillOval((int)(x) + 300, 400, 50, 50);

        g.setColor(purple);
        g.fillOval((int)(x) + 800, 200, 75, 75);
    }

    public void move() {
        x -= 1;
    }

    public void resetPosition() {
        x = 500;
    }
}