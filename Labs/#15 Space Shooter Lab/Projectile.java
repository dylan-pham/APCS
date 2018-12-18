import java.awt.Color;
import java.awt.Graphics;
 
public class Projectile {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Color red;
     
    public Projectile(int x, int y) {
        this.x = x;
        this.y = y; 
        width = 10;
        height = 10;
        visible = false;
        red = new Color(255, 0, 0);
    }
     
    public void drawMe(Graphics g) {
        if ( visible ) {
            g.setColor(red);
            g.fillOval(x, y, width, height);
        }
    }

    public void moveRight() {
        if ( visible ) {
            x += 15;
        }

        if ( x > 850 ) {    
            setVisible(false);  // bullet disappears after leaving screen
        }
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setPosition(int x, int y) { // resetting bullet to initial positions
        if ( visible == false ) {
            this.x = x;
            this.y = y;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}