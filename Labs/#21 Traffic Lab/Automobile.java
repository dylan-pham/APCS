import java.awt.Graphics;
import java.awt.Color;
 
public class Automobile {
    private Color bodyColor;
    private int x;
    private int y;
    private int width;
    private int height;
     
    public Automobile(Color bodyColor, int x, int y) {
        this.bodyColor = bodyColor;
        this.x = x;
        this.y = y;
        this.width = 70;
        this.height = 20;
    }
     
    public void drawMe(Graphics g) {
        drawFrame(g);
        drawWheels(g);
    }

    public void move() {}
     
    public void drawFrame(Graphics g) {
        g.setColor(bodyColor);
        g.fillRect(x, y, width, height);
    }
     
    public void drawWheels(Graphics g) { 
        g.setColor(Color.black);
        g.fillOval(x+5,y+10, 15, 15);
        g.fillOval(x+50,y+10, 15, 15);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getBodyColor() {
        return bodyColor;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}