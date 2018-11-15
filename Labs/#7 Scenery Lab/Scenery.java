import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Scenery extends JPanel {
    private int background;
    private int cloud;

    public Scenery(int background, int cloud) {
        this.background = background;
        this.cloud = cloud;
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if ( background == 1 ) {
            Color lightBlue = new Color(108, 206, 209); //sky
            g.setColor(lightBlue);
            g.fillRect(0, 0, 800, 600);

            Color tan = new Color(181, 138, 45); //land
            g.setColor(tan);
            g.fillRect(0, 250, 800, 350);
        }

        if ( background == 2 ) {
            Color darkBlue = new Color(24, 42, 132); //sky
            g.setColor(darkBlue);
            g.fillRect(0, 0, 800, 600);

            Color brown = new Color(198, 87, 67); //land
            g.setColor(brown);
            g.fillRect(0, 250, 800, 350);
        }

        if ( cloud == 2 ) {
            Color white = new Color(255, 255, 255); //clouds
            g.setColor(white);

            g.fillOval(200, 10, 100, 100);
            g.fillOval(250, 10, 100, 100);
            g.fillOval(300, 10, 100, 100);

            g.fillOval(500, 10, 100, 100);
            g.fillOval(550, 10, 100, 100);
            g.fillOval(600, 10, 100, 100);
        }
    
        int xTrunk = 125;
        int xCrown = 50;

        while ( xCrown != 740) { //tree object 1; challenge III
            Color brown = new Color(96, 42, 2); //tree trunk
            g.setColor(brown);
            g.fillRect(xTrunk, 400, 70, 200);

            Color green = new Color(51, 196, 60); //tree crown
            g.setColor(green);
            g.fillOval(xCrown, 300, 230, 150);

            xTrunk += 230;
            xCrown += 230;
        }

        Color white = new Color(255, 255, 255); //snowman object 2
        g.setColor(white);
        g.fillOval(50, 200, 50, 50); //snowman legs
        g.fillOval(57, 160, 40, 40); //snowman body
        g.fillOval(63, 130, 30, 30); //snowman head

        Color black = new Color(0, 0, 0); //car object 3
        g.setColor(black);
        g.fillOval(200, 200, 50, 50); //wheels
        g.fillOval(300, 200, 50, 50); //wheels

        Color red = new Color(244, 66, 66); //car body
        g.setColor(red);
        g.fillRect(175, 130, 200, 70);

        Color green = new Color(96, 229, 7); //sunflow object 4
        g.setColor(green);
        g.fillRect(500, 200, 10, 50); //stem

        Color brown = new Color(68, 31, 12); //center
        g.setColor(brown);
        g.fillOval(480, 150, 50, 50);

        Color yellow = new Color(255, 204, 0);
        g.setColor(yellow);
        g.fillOval(530, 150, 50, 50); //right
        g.fillOval(430, 150, 50, 50); //left
        g.fillOval(480, 100, 50, 50); //top

        Color orange = new Color(234, 91, 9); //ferris wheel object 5
        g.setColor(orange);
        g.drawOval(620, 125, 100, 100); //wheel
        g.fillOval(663, 170, 15, 15);   //center

        g.fillRect(640, 225, 15, 25); //legs
        g.fillRect(680, 225, 15, 25);

        g.drawRect(670, 125, 0, 100); //vert spoke
        g.drawRect(620, 175, 100, 0); //horiz spoke
    }
}