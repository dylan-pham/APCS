import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Screen extends JPanel implements KeyListener {
    private Background level1BG;
    private Background level2BG;
    private Player player;
    private Projectile projectile;
    private Star[] stars;
    private Target[] targets;
    private Target[] targets2;
    private int level;
    private JLabel score;
    private Life[] lives;
    private int livesLost = 0;
    private BufferedImage winner;
    private int visibleTargets;
    private boolean endGame = false;

    public Screen() {
        addKeyListener(this);
        setFocusable(true);
        
        level1BG = new Background(500);
        level2BG = new Background(500);
        player = new Player(50, 300);
        projectile = new Projectile(50, 300);

        stars = new Star[200];
        for ( int i = 0; i < stars.length; i++ ) {
            double x = (Math.random() * 2000);
            double y = (Math.random() * 650);
            stars[i] = new Star(x, y);
        }

        targets = new Target[3];
        Random random = new Random();
        for ( int i = 0; i < targets.length; i++ ) {
            int x = (int)(Math.random() * 300 + 500);
            int y = (int)(Math.random() * 625 + 1);
            boolean z = random.nextBoolean();
            targets[i] = new Target(x, y, z);
        }

        targets2 = new Target[5];
        for ( int i = 0; i < targets2.length; i++ ) {
            int x = (int)(Math.random() * 100 + 700);
            int y = (int)(Math.random() * 625 + 1);
            boolean z = random.nextBoolean();
            targets2[i] = new Target(x, y, z);
        }

        level = 1;

        score = new JLabel("0 points     |     Level " + level);
        score.setForeground(Color.white);
        this.add(score);

        int firstHeartX = 395;
        int x;
        int y;
        lives = new Life[3];
        for ( int i = 0; i < lives.length; i++ ) {
            x = firstHeartX + 20 * i;   // separting each heart by 20px
            y = 25;
            lives[i] = new Life(x, y);
        }

        try {
            winner = ImageIO.read(new File("winner.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public Dimension getPreferredSize() {
        return new Dimension(850, 650);
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if ( level == 1 ) {
            level1BG.drawMe(g);
            
            player.drawMe(g);
             
            projectile.drawMe(g);
            
            for ( int i = 0; i < targets.length; i++ ) {
                targets[i].drawMe(g);
            }
    
            for ( int i = 0; i < stars.length; i++ ) {
                stars[i].drawMe(g);
            }

            for ( int i = 0; i < lives.length; i++ ) {
                if ( lives[i].getVisible() == true ) {
                    lives[i].drawMe(g);
                }
            }
        } else if ( level == 2 ) {
            level2BG.drawMe2(g);

            player.drawMe(g);

            projectile.drawMe(g);

            for ( int i = 0; i < targets2.length; i++ ) {
                targets2[i].drawMe(g);
            }

            for ( int i = 0; i < stars.length; i++ ) {
                stars[i].drawMe(g);
            }

            for ( int i = 0; i < lives.length; i++ ) {
                if ( lives[i].getVisible() == true ) {
                    lives[i].drawMe(g);
                }
            }

            if ( endGame ) {
                g.drawImage(winner, 0, 0, null);
            }
        }
    } 
 
    public void animate() {
        while ( true && !endGame ) {
            try {
                Thread.sleep(35);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
            projectile.moveRight();

            if ( level == 1 ) {
                level1BG.move();
                visibleTargets = 0;
                for ( int i = 0; i < targets.length; i++ ) {
                    targets[i].checkCollision(projectile);
                    targets[i].move();

                    if ( targets[i].checkVisible() == true ) {  // checking if target is still alive
                        visibleTargets += 1;

                        if ( targets[i].reachOtherSide() == true ) {
                            if ( livesLost < lives.length ) {   // making sure index doesn't go out of bound
                                lives[livesLost].setVisible(false); // setting one life to be not visible
                                livesLost += 1;
                                playSound2();
                            }
                        }

                        if ( player.checkCollision(targets[i]) == true ) {  // checking for collision between target and player
                            targets[i].resetPosition(); // resetting position of target if collision is detected

                            if ( livesLost < lives.length ) {   // making sure index doesn't go out of bound
                                lives[livesLost].setVisible(false); // setting one life to be not visible
                                livesLost += 1;
                                playSound2();
                            }
                        }
                    }
                }

                for ( int i = 0; i < stars.length; i++ ) {
                    stars[i].move();
                }

                if ( visibleTargets <= 3 ) {
                    String currentScore = "" + (3 - visibleTargets);
                    score.setText(currentScore + " points   |   Level " + level);

                }

                if ( visibleTargets == 0 ) {
                    level = 2;
                }

                if ( livesLost == 3 ) {
                    livesLost = 0;
                    visibleTargets = 0;
                    level1BG.resetPosition();
                    level2BG.resetPosition();

                    for ( int i = 0; i < targets.length; i++ ) {
                        targets[i].setVisible(true);
                    }

                    for ( int i = 0; i < lives.length; i++ ) {
                        lives[i].setVisible(true);
                    }
                }

            } else if ( level == 2 ) {
                level2BG.move();
                visibleTargets = 0;
                for ( int i = 0; i < targets2.length; i++ ) {
                    targets2[i].checkCollision(projectile);
                    targets2[i].move2();

                    if ( targets2[i].checkVisible() == true ) {
                        visibleTargets += 1;

                         if ( targets2[i].reachOtherSide() == true ) {
                            if ( livesLost < lives.length ) {   // making sure index doesn't go out of bound
                                lives[livesLost].setVisible(false); // setting one life to be not visible
                                livesLost += 1;
                                playSound2();
                            }
                        }

                        if ( player.checkCollision(targets2[i]) == true ) {
                            targets2[i].resetPosition();
                            
                            if ( livesLost < lives.length ) {
                                lives[livesLost].setVisible(false);
                                livesLost += 1;
                                playSound2();
                            }
                        }
                    }
                }

                for ( int i = 0; i < stars.length; i++ ) {
                    stars[i].move();
                }

                if ( visibleTargets == 0 ) {
                    endGame = true;
                }

                if ( visibleTargets <= 5 ) {
                    String currentScore = "" + (5 - visibleTargets);
                    score.setText(currentScore + " points   |   Level " + level);
                }

                if ( livesLost == 3 ) {
                    level = 1;
                    livesLost = 0;
                    visibleTargets = 0;
                    level1BG.resetPosition();
                    level2BG.resetPosition();

                    for ( int i = 0; i < targets.length; i++ ) {
                        targets[i].setVisible(true);
                    }

                    for ( int i = 0; i < lives.length; i++ ) {
                        lives[i].setVisible(true);
                    }
                }
            }
            repaint();
        }
    }           

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
        } else if ( e.getKeyCode() == 80 ) { // changes level when p is pressed
            if ( level == 1 ) {
                level = 2;
            } else if ( level == 2 ) {
                endGame = true;
            }
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

    public void playSound2() {
        try {
            URL url = this.getClass().getClassLoader().getResource("loselife.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}