import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Character {
    private int x;
    private int y;
    private Image image;
    private int width;
    private int height;
    private boolean visible;

    public Character(String fileName, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.visible = false;

        try {
            image = ImageIO.read(new File("images/characters/" + fileName));
            image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        } catch ( IOException e ){
            System.out.println(e);
        }
    }

    public void drawMe(Graphics g) {
        if (visible)
            g.drawImage(image, x, y, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }
} 