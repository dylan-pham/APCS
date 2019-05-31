import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class EndGameScreen {
    private boolean isVisible;
    Image image;

    public EndGameScreen() {
        isVisible = false;
        
        try {
            image = ImageIO.read(new File("images/end-game.jpg"));
            image = image.getScaledInstance(800, 450, Image.SCALE_DEFAULT);
        } catch ( IOException e ){
            System.out.println(e);
        }
    }

    public void drawMe(Graphics g) {
        if (isVisible) {
            g.drawImage(image, 0, 0, null);
        }
    }
    
    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;  
    }

    public boolean getVisible() {
        return isVisible;
    }
}