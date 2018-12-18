import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Life {
    private int x;
    private int y;
    private boolean visible;
    private BufferedImage lives;
 
    public Life(int x, int y) {
        this.x = x;
        this.y = y;
        visible = true;

        try {
            lives = ImageIO.read(new File("heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMe(Graphics g) {
        if ( visible = true ) {
            g.drawImage(lives, x, y, null);
        }
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}