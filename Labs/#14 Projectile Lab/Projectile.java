import java.awt.Color;
import java.awt.Graphics;
 
public class Projectile {
    private int x;
    private int y;
    private int width;
    private int height;
     
    private Color red;
    private boolean visible;
     
    public Projectile(int x, int y) {
        this.x = x;
        this.y = y; 
        width = 10;
        height = 10;
         
        red = new Color(255, 0, 0);
        visible = false;
    }
     
    public void drawMe(Graphics g) {
        if ( visible ) {
            g.setColor(red);
            // drawing bullet
            g.fillOval(x, y, width, height);
        }
    }

    public void moveRight() {
        // moving bullet
        if ( visible ) {
            x++;
        }

        // bullet disappears after leaving screen
        if ( x > 850 ) {
            setVisible(false);
        }
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setPosition(int x, int y) {
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