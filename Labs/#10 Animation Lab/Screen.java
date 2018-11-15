import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

public class Screen extends JPanel implements MouseListener {
    private int ghostX;
    private int catX;
    private int spiderY;
    private int webY;
    private int increment;

    public Screen() {
        ghostX = 100;
        catX = 700;
        spiderY = 50;
        webY = 50;
        increment = 1;
        addMouseListener(this);
    }

    public Dimension getPreferredSize(){
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Color green = new Color(0, 255, 0);
        Color yellow = new Color(255, 255, 0);
        Color black = new Color(0, 0, 0);
        Color orange = new Color(255, 110, 38);
        Color darkGreen = new Color(22, 61, 1);
        Color white = new Color(255, 255, 255);
        Color brown = new Color(86, 44, 0);
        Color red = new Color(244, 83, 66);
        Color blue = new Color(160, 181, 214);

        //sets background
        g.setColor(black);
        g.fillRect(0, 0, 800, 600);
        g.setColor(brown);
        g.fillRect(0, 400, 800, 200);

        //creates moutain
        g.setColor(blue);
        int[] x = {0, 800, 400};
        int[] y = {400, 400, 200};
        g.fillPolygon(x, y, 3);

        //creates grass
        int grassX = 0;

        while ( grassX < 800 ) {
            g.setColor(green);
            g.fillRect(grassX, 400, 5, 20);
            grassX += 10;
        }

        //creates row of pumpkins
        int pumpkinsX = 100;
        int pumpkinStemX = 125;

        while( pumpkinsX < 700) {
            g.setColor(orange);
            g.fillOval(pumpkinsX, 350, 50, 50);
            pumpkinsX += 50;

            g.setColor(darkGreen);
            g.fillRect(pumpkinStemX, 335, 5, 15);
            pumpkinStemX += 50;
        }
        
        //creates sun
        g.setColor(white);
        g.fillOval(75, 100, 75, 75);

        //creates ghost
        g.setColor(white);
        g.fillOval(ghostX, 225, 75, 100);
        g.fillRect(ghostX, 275, 75, 50);

        //creates ghost face
        g.setColor(black);
        g.fillRect(ghostX + 10, 250, 20, 10);
        g.fillRect(ghostX + 45, 250, 20, 10);
        g.fillOval(ghostX + 22, 275, 30, 30);

        //creates cat face
        g.setColor(white);
        g.fillOval(catX, 500, 75, 75);

        //creates cat left ear
        int[] x1 = {catX+85, catX, catX+50};
        int[] y1 = {490, 525, 575};
        g.fillPolygon(x1, y1, 3);

        //creates cat right ear
        int[] x2 = {catX-10, catX+75, catX+25};
        int[] y2 = {490, 525, 575};
        g.fillPolygon(x2, y2, 3);

        //creates cat eyes
        g.setColor(black);
        g.fillOval(catX+20, 520, 10, 10);
        g.fillOval(catX+45, 520, 10, 10);

        //creates cat nose
        int[] x3 = {catX+25, catX+50, catX+38};
        int[] y3= {540, 540, 550};
        g.fillPolygon(x3, y3, 3);

        //creates cat mouth
        g.drawRect(catX+25, 550, 25, 1);

        //creates cat neck
        g.setColor(white);
        g.fillRect(catX+25, 570, 25, 50);

        //creates spider
        g.setColor(red);
        //spider body
        g.fillOval(375, spiderY, 50, 50);
        //top right leg
        g.fillRect(420, spiderY+10, 50, 10);
        g.fillRect(460, spiderY-30, 10, 50);
        //top left leg
        g.fillRect(330, spiderY+10, 50, 10);
        g.fillRect(330, spiderY-30, 10, 50);
        //bottom right leg
        g.fillRect(420, spiderY+30, 50, 10);
        g.fillRect(460, spiderY+30, 10, 50);
        //bottom left leg
        g.fillRect(330, spiderY+30, 50, 10);
        g.fillRect(330, spiderY+30, 10, 50);

        //creates web
        g.setColor(white);
        g.fillRect(400, 0, 1, webY);
    }
   
    public void animate() {
        while ( true ) {
            ghostX += increment;
            catX--;
            spiderY++;
            webY++;
            
            try {
                Thread.sleep(10);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            repaint();
        }
    }

    // click on ghost to change direction
    public void mousePressed(MouseEvent e) {
        if (e.getX() >= ghostX && e.getX() <= ghostX + 75 && e.getY() <= 325 && e.getY() >= 225) {
            increment = -increment;
        }
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
}