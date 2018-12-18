import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Target {
    private int x;
    private int y;
    private boolean upOrDown;
    private int width;
    private int height;
    private int direction;
    private boolean visible;
    private Color green;
    private Color orange;
    private boolean otherSide;

    public Target(int x, int y, boolean upOrDown) {
        this.x = x;
        this.y = y;
        this.upOrDown = upOrDown;
        width = 25;
        height = 25;
        green = new Color(130, 191, 65);
        orange = new Color(247, 123, 34);
        visible = true;

        if ( upOrDown ) {
            direction = 1;
        } else {
            direction = -1;
        }
    }

    public void drawMe(Graphics g) {
        if ( visible == true ) {
            g.setColor(green);
            g.fillOval(x, y, width, height);
            g.setColor(orange);
            g.fillOval(x + 5, y + 5, width - 10, height - 10);
        }
    }

    public void resetPosition() {
        x = 850;
    }

    public void move() {
        if ( visible && y >= 0 && y <= 625 ) {
            // changes direction when border is reached
            if ( y == 0 || y == 625 ) {
                direction = -direction;
            }
            // resets target to right side after reaching border
            if ( x <= 0 ) {
                x = 850;
            }
        
            y += direction;
            x -= 1;
        }
    }

    public void move2() {
        if ( visible && y >= 0 && y <= 625 ) {
            // changes direction when border is reached
            if ( y == 0 || y == 625 ) {
                direction = -direction;
            }
            // resets target to right side after reaching border
            if ( x <= 0 ) {
                x = 850;
            }
        
            y += direction;
            x -= 2;
        }
    }

    public void checkCollision(Projectile p) {
        if ( visible == true ) {
            int pX = p.getX();
            int pY = p.getY();
            int pWidth = p.getWidth();
            int pHeight = p.getHeight();
            
            // eliminates target and plays sound if target is hit
            if ( pX + pWidth >= x && pX <= x + width && pY + pHeight >= y && pY <= y + height ) {
                playSound2();
                visible = false;
            }
        }
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean checkVisible() {
        return visible;
    }

    public boolean reachOtherSide() {
        if ( x == 0 ) {
            return true;
        } else {
            return false;
        }
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

    public void playSound2() {
        try {
            URL url = this.getClass().getClassLoader().getResource("hit.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}