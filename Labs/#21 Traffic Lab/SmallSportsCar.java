import java.awt.Graphics;
import java.awt.Color;
 
public class SmallSportsCar extends SmallCar {
    public SmallSportsCar(Color bodyColor, int x, int y) {
        super(bodyColor, x, y);
    }

    @Override
    public void drawFrame(Graphics g) {
        super.drawFrame(g);

        g.setColor(getBodyColor());

        int[] xValues = new int[3];
        int[] yValues = new int[3];

        xValues[0] = getX();
        yValues[0] = getY();
        xValues[1] = getX();
        yValues[1] = getY() + getHeight();
        xValues[2] = getX() - 15;
        yValues[2] = getY() + getHeight();

        g.fillPolygon(xValues, yValues, 3);
    }
}