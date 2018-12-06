import java.awt.Color;
import java.awt.Graphics;

public class Player {
    private int x;
    private int y;     
    private int width;
    private int height;
     
    private Color black;

    public Player(int x, int y){
        this.x = x;
        this.y = y;    
        width = 50;
        height = 50;
         
        black = new Color(0, 0, 0);
    }
 
    public void drawMe(Graphics g){
        g.setColor(black);
        // cannon body
        g.fillOval(x, y, width, height);
        // cannon barrel
        g.fillRect(x + 10, y + 5, 80, 10);
    }
     
    public void moveUp(){
        y = y - 5;
    }
     
    public void moveDown(){
        y = y + 5;
    }
     
    public int getX(){
        return x;
    }
     
    public int getY(){
        return y;
    }
}