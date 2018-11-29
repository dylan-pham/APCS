import javax.swing.JLabel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
 
public class Scenery extends JPanel {
    private Color brown;
    private Color yellow;
    private Color red;
    private Color skyblue;
    private Color blue;
    private Color white;
    private Color gray;
    private Color graywhite;
    private Color lightbrown;
    private Color green;
    private Color orange;
    private Color darkorange;
    private Color black;
    private String currentSeason;
    private RainDrop[] rain;
    private Mountain[] mountain;
    private Tree[] tree;
    private Bird[] bird;
    private JLabel season;
    private int x;

    public Scenery() {
        brown = new Color(102, 49, 0);
        yellow = new Color(244, 255, 53);
        red = new Color(244, 89, 66);
        skyblue = new Color(163, 195, 247);
        blue = new Color(0, 0, 255);
        white = new Color(237, 241, 247);
        gray = new Color(128, 130, 132);
        graywhite = new Color(197, 203, 214);
        lightbrown = new Color(186, 113, 40);
        green = new Color(21, 142, 33);
        orange = new Color(252, 176, 25);
        darkorange = new Color(209, 110, 4);
        black = new Color(0, 0, 0);
        
        currentSeason = "Spring";
        
        rain = new RainDrop[100];
        for ( int i = 0; i < rain.length; i++ ) {
            rain[i] = new RainDrop();
        }

        mountain = new Mountain[10];
        for ( int i = 0; i < mountain.length; i++ ) {
            mountain[i] = new Mountain();
        }
        
        tree = new Tree[10];
        for ( int i = 0; i < tree.length; i++ ) {
            tree[i] = new Tree();
        }

        bird = new Bird[20];
        for ( int i = 0; i < bird.length; i++ ) {
            bird[i] = new Bird();
        }
        
        season = new JLabel(currentSeason);
        this.add(season);

        x = 800;
    }
     
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //creates sky
        g.setColor(skyblue);
        g.fillRect(0, 0, 800, 400);
        
        if ( currentSeason == "Spring" ) {
            g.setColor(brown);
            g.fillRect(0, 400, 800, 200);

            for ( int i = 0; i < mountain.length; i++ ) {
                mountain[i].drawMe(g, gray);
            }

            for ( int i = 0; i < rain.length; i++ ) {
                rain[i].drawMe(g, blue);
            }

            for ( int i = 0; i < tree.length; i++ ) {
                tree[i].drawMe(g, lightbrown, green);
            }

            for ( int i = 0; i < bird.length; i++ ) {
                bird[i].drawMe(g, black);
            }

            g.setColor(gray);
            g.fillOval(100, 50, 50, 50);
            g.fillOval(125, 50, 50, 50);
            g.fillOval(150, 50, 50, 50);

            g.fillOval(250, 50, 50, 50);
            g.fillOval(275, 50, 50, 50);
            g.fillOval(300, 50, 50, 50);
        }

        if ( currentSeason == "Summer" ) {
            g.setColor(brown);
            g.fillRect(0, 400, 800, 200);

            for ( int i = 0; i < mountain.length; i++ ) {
                mountain[i].drawMe(g, gray);
            }

            for ( int i = 0; i < tree.length; i++ ) {
                tree[i].drawMe(g, lightbrown, green);
            }

            for ( int i = 0; i < bird.length; i++ ) {
                bird[i].drawMe(g, black);
            }
        }

        if ( currentSeason == "Fall" ) {
            g.setColor(brown);
            g.fillRect(0, 400, 800, 200);

            for ( int i = 0; i < mountain.length; i++ ) {
                mountain[i].drawMe(g, gray);
            }

            for ( int i = 0; i < tree.length; i++ ) {
                tree[i].drawMe(g, lightbrown, darkorange);
            }

            for ( int i = 0; i < bird.length; i++ ) {
                bird[i].drawMe(g, black);
            }

            g.setColor(gray);
            g.fillOval(100, 50, 50, 50);
            g.fillOval(125, 50, 50, 50);
            g.fillOval(150, 50, 50, 50);

            g.fillOval(250, 50, 50, 50);
            g.fillOval(275, 50, 50, 50);
            g.fillOval(300, 50, 50, 50);
        }

        if ( currentSeason == "Winter" ) {
            g.setColor(white);
            g.fillRect(0, 400, 800, 200);

            for ( int i = 0; i < mountain.length; i++ ) {
                mountain[i].drawMe(g, graywhite);
            }

            for ( int i = 0; i < rain.length; i++ ) {
                rain[i].drawMe(g, white);
            }

            for ( int i = 0; i < tree.length; i++ ) {
                tree[i].drawTrunk(g, lightbrown);
            }

            g.setColor(gray);
            g.fillOval(100, 50, 50, 50);
            g.fillOval(125, 50, 50, 50);
            g.fillOval(150, 50, 50, 50);

            g.fillOval(250, 50, 50, 50);
            g.fillOval(275, 50, 50, 50);
            g.fillOval(300, 50, 50, 50);

            g.fillOval(400, 50, 50, 50);
            g.fillOval(425, 50, 50, 50);
            g.fillOval(450, 50, 50, 50);
        }

        // creates sun
        g.setColor(yellow);
        g.fillOval(600, 50, 50, 50);
        g.setColor(orange);
        g.fillOval(605, 55, 40, 40);

        // creates loading bar
        g.setColor(red);
        g.fillRect(0, 595, x, 5);

        // reset loading bar, changes currents season and updates lable
        if ( x == 600 ) {
            currentSeason = "Summer";
            season.setText(currentSeason);
        }

        if ( x == 400 ) {
            currentSeason = "Fall";
            season.setText(currentSeason);
        }

        if ( x == 200 ) {
            currentSeason = "Winter";
            season.setText(currentSeason);
        }

        if ( x == 0 ) {
            x = 800;
            currentSeason = "Spring";
            season.setText(currentSeason);
        }
    }
 
    public void animate() {
        while ( true ) {
            
            try {
                Thread.sleep(20);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
            for ( int i = 0; i < rain.length; i++ ) {
                rain[i].move();
            }

            for ( int i = 0; i < bird.length; i++ ) {
                bird[i].move();
            }
            
            // for loading bar
            x--;

            repaint();
        }
    }
}