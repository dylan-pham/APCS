import java.awt.Graphics;
import java.awt.Color;
 
public class SmallCar extends Automobile {
    public SmallCar(Color bodyColor, int x, int y) {
        super(bodyColor, x, y);

        setWidth(35);
        setHeight(15);
    }

    @Override
    public void drawWheels(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(getX()+3, getY()+9, 10, 10);
    }
}