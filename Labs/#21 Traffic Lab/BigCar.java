import java.awt.Graphics;
import java.awt.Color;

public class BigCar extends Automobile {
    public BigCar(Color bodyColor, int x, int y) {
        super(bodyColor, x, y);
    }

    public void drawMe(Graphics g) {
        drawFrame(g);
        drawWindowsAndDoors(g);
        drawWheels(g);
    }

    @Override
    public void drawFrame(Graphics g) {
        // frame
        g.setColor(getBodyColor());
        g.fillRect(getX(), getY()-10, 100, 30);

        // lights
        g.setColor(Color.YELLOW);
        g.fillOval(getX(), getY()-10, 15, 15);
    }
    
    public void drawWindowsAndDoors(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(getX()+20, getY()-40, 60, 30);
    }

    public void drawWheels(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(getX() + 10, getY() + 10, 20, 20);
        g.fillOval(getX() + 70, getY() + 10, 20, 20);

        g.setColor(Color.GRAY);
        g.fillRect(getX() + 15, getY() + 20, 10, 3);
        g.fillRect(getX() + 75, getY() + 20, 10, 3);
    }
}