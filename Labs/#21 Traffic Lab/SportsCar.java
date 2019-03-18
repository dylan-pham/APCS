import java.awt.Graphics;
import java.awt.Color;

public class SportsCar extends MediumCar {
    public SportsCar(Color bodyColor, int x, int y) {
        super(bodyColor, x, y);
    }

    public void drawMe(Graphics g) {
        drawFrame(g);
        drawWheels(g);
        drawWindowsAndDoors(g);
    }

    @Override
    public void drawWindowsAndDoors(Graphics g) {
        // 2 door frame
        int[] xValues = new int[4];
        int[] yValues = new int[4];

        xValues[0] = getX();
        yValues[0] = getY();
        xValues[1] = getX() + 20;
        yValues[1] = getY() - getHeight();
        xValues[2] = getX() + 69;
        yValues[2] = getY() - getHeight();
        xValues[3] = getX() + 69;
        yValues[3] = getY();

        g.setColor(Color.BLACK);
        g.drawPolygon(xValues, yValues, 4);

        g.fillRect(getX()+40, getY()-getHeight(), 1, 40);
        g.fillRect(getX()+15, getY(), 1, 20);
    }

    public void drawFrame(Graphics g) {
        super.drawFrame(g);

        g.setColor(Color.RED);
        int[] xValues = new int[3];
        int[] yValues = new int[3];

        xValues[0] = getX();
        yValues[0] = getY();
        xValues[1] = getX();
        yValues[1] = getY() + 20;
        xValues[2] = getX() - 20;
        yValues[2] = getY() + 20;

        g.fillPolygon(xValues, yValues, 3);
    }

    public void move() {
        if (getX() < 0) {
            setX(800);
        }

        setX(getX()-10);
    }
}