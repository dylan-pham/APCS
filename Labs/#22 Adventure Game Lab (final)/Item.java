import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Item {
    private boolean visible;
    private String fileName;
    private Image image;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean collected;
    private String dialogueBoxMessage;
    private boolean hasPlayedSound;

    public Item(String fileName, int x, int y, int width, int height, String dialogueBoxMessage) {
        this.fileName = fileName;
        this.visible = false;
        this.collected = false;
        this.dialogueBoxMessage = dialogueBoxMessage;
        this.hasPlayedSound= false;

        try {
            image = ImageIO.read(new File("images/items/" + fileName));
            image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        } catch ( IOException e ){
            System.out.println(e);
        }

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void drawMe(Graphics g, int x, int y) {
        g.drawImage(image, x, y, null);
    }

    public void drawMe(Graphics g) {
        if (visible)
            g.drawImage(image, x, y, null);
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public String getDialogueBoxMessage() {
        return dialogueBoxMessage;
    }

    public boolean hasPlayedSound() {
        return hasPlayedSound;
    }

    public void setHasPlayedSound(boolean hasPlayedSound) {
        this.hasPlayedSound= hasPlayedSound;
    }
}