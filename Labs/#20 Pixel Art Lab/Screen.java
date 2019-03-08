import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 
public class Screen extends JPanel implements MouseListener, ActionListener {
    private Square[][] grid;
    private ColorPalette[][] selector;
    private JButton clearButton;
    private JButton saveButton;
    private int red;
    private int green;
    private int blue;
    private BufferedImage image;

    public Screen() {
        setLayout(null);
        grid = new Square[8][8];
        selector = new ColorPalette[6][1];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = new Square(255, 255, 255);
            }
        }

        selector[0][0] = new ColorPalette(255, 0, 0);
        selector[1][0] = new ColorPalette(0, 255, 0);
        selector[2][0] = new ColorPalette(0, 0, 255);
        selector[3][0] = new ColorPalette(255, 255, 0);
        selector[4][0] = new ColorPalette(128, 0, 128);
        selector[5][0] = new ColorPalette(255, 165, 0);

        clearButton = new JButton("Clear");
        clearButton.setBounds(700, 10, 90, 30);
        clearButton.addActionListener(this);
        this.add(clearButton);

        saveButton = new JButton("Save");
        saveButton.setBounds(600, 10, 90, 30);
        saveButton.addActionListener(this);
        this.add(saveButton);

        red = 0;
        green = 255;
        blue = 0;

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

        x = 200;
        y = 10;
        for (int r = 0; r < selector.length; r++) {
            selector[r][0].drawMe(g, x, y);
            y += 20;
        }
    }

    public void saveImage() {
            //create an image that is 200 by 200
        if (image == null) {
            image = (BufferedImage)(createImage(160, 160));
        }

            //Create a graphics object that draws on the image
        Graphics gImage = image.createGraphics();

        int x = 0;
        int y = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c].drawMe(gImage, x, y);
                x += 20;
            }
            x = 0;
            y += 20;
        }

            // writing to file
        if (image != null) {
            try {
                File outputfile = new File("image.png");
                ImageIO.write(image, "png", outputfile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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
            grid[row][column].changeColor(red, green, blue);
            repaint();
        }

        if (e.getX() > 200 && e.getX() < 220 && e.getY() > 10 && e.getY() < 30) {
            red = 255;
            green = 0;
            blue = 0;
        } else if (e.getX() > 200 && e.getX() < 220 && e.getY() > 30 && e.getY() < 50) {
            red = 0;
            green = 255;
            blue = 0;
        } else if (e.getX() > 200 && e.getX() < 220 && e.getY() > 50 && e.getY() < 70) {
            red = 0;
            green = 0;
            blue = 255;
        } else if (e.getX() > 200 && e.getX() < 220 && e.getY() > 70 && e.getY() < 90) {
            red = 255;
            green = 255;
            blue = 0;
        } else if (e.getX() > 200 && e.getX() < 220 && e.getY() > 90 && e.getY() < 110) {
            red = 128;
            green = 0;
            blue = 128;
        } else if (e.getX() > 200 && e.getX() < 220 && e.getY() > 110 && e.getY() < 130) {
            red = 255;
            green = 165;
            blue = 0;
        }

    }

    private void clearScreen() {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c].changeColor(255, 255, 255);
            }
        }

        repaint();
    }

    public void mouseReleased(MouseEvent e) {}
 
    public void mouseEntered(MouseEvent e) {}
 
    public void mouseExited(MouseEvent e) {}
 
    public void mouseClicked(MouseEvent e) {}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            clearScreen();
        } else if (e.getSource() == saveButton) {
            saveImage();
        }
    }
}