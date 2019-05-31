import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class InventoryScreen {
    private boolean isVisible;
    private int x;
    private int y;

    public InventoryScreen() {
        isVisible = false;
        x = 70;
        y = 50;
    }

    public void drawMe(Graphics g, ArrayList<Item> collected) {
        if (isVisible) {
            g.fillRect(50, 50, 500, 200);

            for (Item each : collected) {
                each.drawMe(g, x, 50);
                x += 70;
            }
            x = 70;
        }
    }
    
    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;  
    }

    public boolean getVisible() {
        return isVisible;
    }
}