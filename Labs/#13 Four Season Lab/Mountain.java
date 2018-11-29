import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Mountain {
    private int[] y = new int[3];
    private int[] x = new int[3];

    public Mountain() {
        y[0] = 400; // making sure base of mountain is lined up with horizon
        y[1] = 400;

        int firstPoint = (int)(Math.random() * 800);
        int secondPoint = (int)(Math.random() * 800);

        while ( Math.abs(firstPoint - secondPoint) < 50 ) { // to make mountain wide enough
            firstPoint = (int)(Math.random() * 800);
            secondPoint = (int)(Math.random() * 800);
        }

        x[0] = firstPoint;  // setting points after criteria is met
        x[1] = secondPoint;

        x[2] = (firstPoint + secondPoint)/2;    // lining up tip of mountain with center of base
        y[2] = (int)(Math.random() * 200 + 100);
    }

    public void drawMe(Graphics g, Color c) {
        g.setColor(c);
        g.fillPolygon(x, y, 3);
    }
}