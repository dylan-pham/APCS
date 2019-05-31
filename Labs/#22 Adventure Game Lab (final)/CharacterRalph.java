import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CharacterRalph {
    private int x;
    private int y;
    private Image image;
    private int width;
    private int height;
    private boolean visible;
    private boolean speedBoost;
    private boolean timeToEscape;
    private boolean requestingToDrop;

    public CharacterRalph(String fileName, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.visible = false;
        this.speedBoost = false;
        this.timeToEscape= false;
        this.requestingToDrop = false;

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

    public void move(String direction) {
        if (visible && speedBoost) {
            if (direction.equals("up")) {
                y -= 40; 
            } else if (direction.equals("down")) {
                y += 40;
            } else if (direction.equals("left")) {
                x -= 40;
            } else if (direction.equals("right")) {
                x += 40;
            }
        } else if (visible) {
            if (direction.equals("up")) {
                y -= 20; 
            } else if (direction.equals("down")) {
                y += 20;
            } else if (direction.equals("left")) {
                x -= 20;
            } else if (direction.equals("right")) {
                x += 20;
            }
        }
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

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean checkCollision(Item i) {
        int iX = i.getX();
        int iY = i.getY();
        int iWidth = i.getWidth();
        int iHeight = i.getHeight();
        
        if ( iX + iWidth >= x && iX <= x + width && iY + iHeight >= y && iY <= y + height ) {
            return true;
        }
        
        return false;
    }

    public boolean checkInRangeOtherCharacters(Character i) {
        if (i.isVisible()) {
            int iX = i.getX();
            int iY = i.getY();
            int iWidth = i.getWidth();
            int iHeight = i.getHeight();
            
            if ( iX + iWidth >= x && iX <= x + width + 50 && iY + iHeight >= y && iY <= y + height ) {
                return true;
            }
        }
            return false;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setSpeedBoost(boolean speedBoost) {
        this.speedBoost = speedBoost;
    }

    public void setTimeToEscape(boolean timeToEscape) {
        this.timeToEscape = true;
    }

    public boolean isTimeToEscape() {
        return timeToEscape;
    }

    public void setRequestingToDrop(boolean requestingToDrop) {
        this.requestingToDrop = requestingToDrop;
    }

    public boolean isRequestingToDrop() {
        return requestingToDrop;
    }
} 