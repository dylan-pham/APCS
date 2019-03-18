import java.awt.Graphics;
import java.awt.Color;

public class Sedan extends MediumCar {
    public Sedan(Color bodyColor, int x, int y) {
        super(bodyColor, x, y);
    }

    public void drawMe(Graphics g) {
        drawFrame(g);
        drawWindowsAndDoors(g);
        drawWheels(g);
    }

    @Override
    public void drawWindowsAndDoors(Graphics g) {
        super.drawWindowsAndDoors(g);

        // 4 door frame
        g.setColor(Color.BLACK);
        g.fillRect(getX()+35, getY()-20, 1, 40);
        g.fillRect(getX()+60, getY()-20, 1, 40);
        g.fillRect(getX()+10, getY()-20, 1, 40);
    }

    public void move() {
        if (getX() < 0) {
            setX(800);
        }

        setX(getX()-3);
    }
}