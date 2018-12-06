import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Screen extends JPanel implements KeyListener {
    private Projectile projectile;
    private Player player;
    private Target[] targets;
    private BufferedImage background;
    private JLabel score;
     
    public Screen() {
        //sets keylistener
        addKeyListener(this);
        setFocusable(true);
        
        player = new Player(50, 300);
        projectile = new Projectile(50, 300);
        targets = new Target[10];
        Random random = new Random();
        score = new JLabel("0 points");

        // adding score label to screen
        this.add(score);
        
        // setting background
        try {
            background = ImageIO.read(new File("background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // creating targets at random positions
        for ( int i = 0; i < targets.length ; i++ ) {
            int x = (int)(Math.random() * 525 + 300);
            int y = (int)(Math.random() * 625 + 1);
            boolean z = random.nextBoolean();
            targets[i] = new Target(x, y, z);
        }
    }
 
    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(850, 650);
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        // draw background
        g.drawImage(background, 0, 0, null);
     
        // draw cannon
        player.drawMe(g);
         
        // draw projectile
        projectile.drawMe(g);
        
        // draw targets
        for ( int i = 0; i < targets.length; i++ ) {
            targets[i].drawMe(g);
        }
    } 
 
    public void animate() {
        while(true) {
            try {
                Thread.sleep(2);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            projectile.moveRight();

            // checking for collision, moving targets and counting up targets
            int count = 0;
            for ( int i = 0; i < targets.length; i++ ) {
                targets[i].checkCollision(projectile);
                targets[i].move();

                if ( targets[i].checkVisible() == true ) {
                    count += 1;
                }
            }

            // setting score
            if ( count < 10 ) {
                String currentScore = "" + (10 - count);
                score.setText(currentScore + " points");
            }

            //repaint the graphics drawn
            repaint();
        }
    }
     
    //implement methods of the KeyListener
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 38) { // up arrow
            player.moveUp();        
        } else if (e.getKeyCode() == 40) { //down arrow
            player.moveDown();   
        } else if ( e.getKeyCode() == 32 ) { // spacebar
            int x = player.getX();
            int y = player.getY();
            projectile.setPosition(x, y);
            projectile.setVisible(true);
            playSound1(); // plays sound when spacebar is pressed
        }
         
        repaint();
    }
 
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public void playSound1() {
        try {
            URL url = this.getClass().getClassLoader().getResource("cannon.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}