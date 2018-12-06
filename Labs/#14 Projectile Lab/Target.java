import java.awt.Color;
import java.awt.Graphics;

import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Target {
    private int x;
    private int y;
    private boolean z;
    private int width;
    private int height;
    private int increment;

    private Color green;
    private Color orange;
    private boolean visible;

    public Target(int x, int y, boolean z) {
        this.x = x;
        this.y = y;
        this.z = z;
        width = 25;
        height = 25;

        green = new Color(130, 191, 65);
        orange = new Color(247, 123, 34);
        visible = true;

        if ( z ) {
            increment = 1;
        } else {
            increment = -1;
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

    public void move() {
        if ( visible && y >= 0 && y <= 625 ) {
            if ( y == 0 || y == 625 ) {
                increment = -increment;
            }
            y += increment;
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

    public boolean checkVisible() {
        return visible;
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