import javax.swing.JLabel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
 
public class Scenery extends JPanel {
    private RainDrop[] rain;
    private JLabel season;
    private String currentSeason;
    private Color brown;
    private Color yellow;
    private Color orange;
    private Color white;

    public Scenery() {
        currentSeason = "Spring";

        brown = new Color(102, 49, 0);
        yellow = new Color(244, 255, 53);
        orange = new Color(255, 167, 52);
        white = new Color(255, 255, 255);

        rain = new RainDrop[100];
        for ( int i = 0; i < rain.length; i++ ) {
            rain[i] = new RainDrop();
        }

        season = new JLabel(currentSeason);
        this.add(season);
    }
     
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         
        for ( int i = 0; i < rain.length; i++ ) {
            rain[i].drawMe(g);
        }

        // creates ground
        g.setColor(brown);
        g.fillRect(0, 400, 800, 200);

        // creates sun
        g.setColor(yellow);
        g.fillOval(600, 50, 50, 50);
        g.setColor(orange);
        g.fillOval(605, 55, 40, 40);

        // creates clouds
        g.setColor(white);
        g.fillOval(100, 50, 50, 50);
        g.fillOval(125, 50, 50, 50);
        g.fillOval(150, 50, 50, 50);
    }
 
    public void animate() {
        while ( true ) {

            try {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
             
            for ( int i = 0; i < rain.length; i++ ) {
                rain[i].move();
            }
 
            repaint();
        }
    }
}