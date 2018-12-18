import java.awt.Color;
import java.awt.Graphics;

public class Player {
    private int x;
    private int y;     
    private int width;
    private int height;  
    private Color red;

    public Player(int x, int y){
        this.x = x;
        this.y = y;    
        width = 50;
        height = 50;  
        red = new Color(244, 110, 66);
    }
 
    public void drawMe(Graphics g){
        g.setColor(red);
        // cannon body
        g.fillOval(x, y, width, height);
        // cannon barrel
        g.fillRect(x + 10, y + 5, 80, 10);
    }

    public boolean checkCollision(Target t) {   // checking if targets collides with player
        int tX = t.getX();
        int tY = t.getY();
        int tWidth = t.getWidth();
        int tHeight = t.getHeight();
        
        if ( tX + tWidth >= x && tX <= x + width && tY + tHeight >= y && tY <= y + height ) {
            return true;
        }
        return false;
    }
     
    public void moveUp() {
        y = y - 5;
    }
     
    public void moveDown() {
        y = y + 5;
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