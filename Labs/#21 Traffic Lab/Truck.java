import java.awt.Graphics;
import java.awt.Color;

public class Truck extends BigCar {
    public Truck(Color bodyColor, int x, int y) {
        super(bodyColor, x, y);
    }

    public void drawMe(Graphics g) {
        drawFrame(g);
        drawWindowsAndDoors(g);
        drawWheels(g);
    }

    @Override
    public void drawWindowsAndDoors(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(getX()+50, getY()-40, 1, 60);
        g.fillRect(getX()+20, getY()-40, 1, 60);
        g.drawRect(getX()+20, getY()-40, 30, 30);
    }

    public void move() {
        if (getX() < 0) {
            setX(800);
        }

        setX(getX()-1);
    }
}