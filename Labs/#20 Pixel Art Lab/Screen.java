import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
 
public class Screen extends JPanel implements MouseListener {
    private Square[][] grid;

    public Screen() {
        grid = new Square[8][8];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = new Square(255, 255, 255);
            }
        }

        addMouseListener(this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 10;
        int y = 10;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c].drawMe(g, x, y);
                x += 20;
            }
            x = 10;
            y += 20;
        }
    }

    public void mousePressed(MouseEvent e) {
        int row = -1;
        int column = -1;

        // checking position of click and corresponding square
        if (e.getX() > 10 && e.getX() < 30) {
            column = 0;
        }
        else if (e.getX() > 30 && e.getX() < 50) {
            column = 1;
        }
        else if (e.getX() > 50 && e.getX() < 70) {
            column = 2;
        }
        else if (e.getX() > 70 && e.getX() < 90) {
            column = 3;
        }
        else if (e.getX() > 90 && e.getX() < 110) {
            column = 4;
        }
        else if (e.getX() > 110 && e.getX() < 130) {
            column = 5;
        }
        else if (e.getX() > 130 && e.getX() < 150) {
            column = 6;
        }
        else if (e.getX() > 150 && e.getX() < 170) {
            column = 7;
        }

        // for the y's
        if (e.getY() > 10 && e.getY() < 30) {
            row = 0;
        }
        else if (e.getY() > 30 && e.getY() < 50) {
            row = 1;
        }
        else if (e.getY() > 50 && e.getY() < 70) {
            row = 2;
        }
        else if (e.getY() > 70 && e.getY() < 90) {
            row = 3;
        }
        else if (e.getY() > 90 && e.getY() < 110) {
            row = 4;
        }
        else if (e.getY() > 110 && e.getY() < 130) {
            row = 5;
        }
        else if (e.getY() > 130 && e.getY() < 150) {
            row = 6;
        }
        else if (e.getY() > 150 && e.getY() < 170) {
            row = 7;
        }

        if (row != -1 && column != -1) {
            grid[row][column].changeColor(0, 255, 0);
            repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {}
 
    public void mouseEntered(MouseEvent e) {}
 
    public void mouseExited(MouseEvent e) {}
 
    public void mouseClicked(MouseEvent e) {}
}