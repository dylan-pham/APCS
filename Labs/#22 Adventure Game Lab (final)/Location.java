import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Location {
    private boolean isVisible;
    private String fileName;
    private Image image;
    
    public Location(boolean isVisible, String fileName, int width, int height) {
        this.isVisible = isVisible;
        this.fileName= fileName;

        try {
            image = ImageIO.read(new File("images/locations/" + fileName));
            image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
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

    public boolean isVisible() {
        return isVisible;
    }
}