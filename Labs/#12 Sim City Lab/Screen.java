import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class Screen extends JPanel {
    Houses h1;
    Trees t1;
    Buildings b1;

    int R = 0;
    int G = 0;
    int B = 0;
    int posOrNeg = 1;
    Color brown = new Color(122, 38, 0);
    Color yellow = new Color(218, 237, 11);
    Color gray = new Color(173, 173, 173);
    
    int sunY = 200;
    int moonY = 450;

    public Screen(){
        h1 = new Houses(600, 500, 3, 4);
        t1 = new Trees(50, 500, 2, 5);
        b1 = new Buildings(50, 250, 3, 3);
    }
 
    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800, 600);
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //creates sky
        g.setColor(new Color(R, G, B));
        g.fillRect(0, 0, 800, 200);

        //creates sun
        g.setColor(yellow);
        g.fillOval(375, sunY, 50, 50);

        //creates moon
        g.setColor(gray);
        g.fillOval(375, moonY, 50, 50);

        //creates ground
        g.setColor(brown);
        g.fillRect(0, 200, 800, 600);

        h1.drawMe(g);
        t1.drawMe(g);
        b1.drawMe(g);
    }

    public void animate() {
        while(true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            sunY--;
            moonY--;

            // transitions color of sky
            if ( sunY % 10 == 0 && R >= 0 ) {
                R += posOrNeg;
            }
            if ( G >= 0 && B >= 0 ) {
                G += posOrNeg;
                B += posOrNeg;
            }

            repaint();

            // re-cycles moon and sun
            if ( sunY == -50 ) {
                sunY = 450;
                posOrNeg = -1;
            }

            if ( moonY == -50 ) {
                moonY = 450;
                posOrNeg = 1;
            }
        }
    }
}