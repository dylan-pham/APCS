import java.awt.Graphics;
import java.awt.Color;

public class MediumCar extends Automobile {
    public MediumCar(Color bodyColor, int x, int y) {
        super(bodyColor, x, y);
    }

    public void drawMe(Graphics g) {
        drawFrame(g);
        drawWindowsAndDoors(g);
        drawWheels(g);
    }
    
    @Override
    public void drawFrame(Graphics g) {
        super.drawFrame(g);

        // lights
        g.setColor(Color.YELLOW);
        g.fillOval(getX(), getY(), 10, 10);
    }

    public void drawWindowsAndDoors(Graphics g) {
         // windows
         g.setColor(Color.BLACK);
         g.drawRect(getX()+10, getY()-20, 50, 20);
         g.fillRect(getX()+35, getY()-20, 1, 20);
    }

    public void drawWheels(Graphics g) {
        super.drawWheels(g);

        // hubcaps
        g.setColor(Color.GRAY);
        g.fillOval(getX()+10, getY()+15, 5, 5);
        g.fillOval(getX()+55, getY()+15, 5, 5);
    }
}