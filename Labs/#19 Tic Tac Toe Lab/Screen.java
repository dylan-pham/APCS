import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Screen extends JPanel implements MouseListener, ActionListener {
    Game game;
    private int playerXWins;
    private int playerOWins;
    private JButton newGameButton;
    private JLabel playerXWinsLabel;
    private JLabel playerOWinsLabel;
    private boolean endGame;

    public Screen() {
        setLayout(null);

        game = new Game();

        playerXWins = 0;
        playerOWins = 0;

        newGameButton = new JButton("New Game");
        newGameButton.setBounds(800, 100, 100, 30);
        newGameButton.addActionListener(this);
        this.add(newGameButton);

        playerXWinsLabel = new JLabel("Player X Wins: " + playerXWins);
        playerXWinsLabel.setBounds(800, 150, 110, 30);
        this.add(playerXWinsLabel);

        playerOWinsLabel = new JLabel("Player O Wins: " + playerOWins);
        playerOWinsLabel.setBounds(800, 200, 110, 30);
        this.add(playerOWinsLabel);

        endGame = true;

        addMouseListener(this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(1000, 800);
    }

    private void initializeGame() {
        endGame = false;
        newGameButton.setVisible(false);
        game.reset();
        repaint();
    }
    
    private void endGame() {
        endGame = true;
        newGameButton.setVisible(true);        
    }

    private void checkEndGameConditions(int winner) {
        if (winner == 1) {
            playerXWins++;
            playerXWinsLabel.setText("Player X Wins: " + playerXWins);
            playWinSound();
        } else if (winner == 2) {
            playerOWins++;
            playerOWinsLabel.setText("Player O Wins: " + playerOWins);
            playWinSound();
        } else {
            playTieSound();
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (game.getTurn() == 1 && !endGame) {
            playerOWinsLabel.setForeground(Color.BLACK);
            playerXWinsLabel.setForeground(Color.RED);
        } else if (game.getTurn() == 2 && !endGame) {
            playerXWinsLabel.setForeground(Color.BLACK);
            playerOWinsLabel.setForeground(Color.RED);
        }
        
        game.drawMe(g);
        
        if ((game.checkTicTacToe() != 0 || game.checkFull() == true) && !endGame) {
            checkEndGameConditions(game.checkTicTacToe());
            endGame();
        }
    }

    public void mousePressed(MouseEvent e) {
        // x's and o's can only be placed during game
        if (!endGame) {
            if (e.getX() >= 100 && e.getX() <= 300 && e.getY() >= 100 && e.getY() <= 300) {
                game.insertXO(0, 0);
                playPlacingMarkerSound();
            }

            if (e.getX() >= 301 && e.getX() <= 500 && e.getY() >= 100 && e.getY() <= 300) {
                game.insertXO(0, 1);
                playPlacingMarkerSound();
            }

            if (e.getX() >= 501 && e.getX() <= 700 && e.getY() >= 100 && e.getY() <= 300) {
                game.insertXO(0, 2);
                playPlacingMarkerSound();
            }

            if (e.getX() >= 100 && e.getX() <= 300 && e.getY() >= 301 && e.getY() <= 500) {
                game.insertXO(1, 0);
                playPlacingMarkerSound();
            }

            if (e.getX() >= 301 && e.getX() <= 500 && e.getY() >= 301 && e.getY() <= 500) {
                game.insertXO(1, 1);
                playPlacingMarkerSound();
            }

            if (e.getX() >= 501 && e.getX() <= 700 && e.getY() >= 301 && e.getY() <= 500) {
                game.insertXO(1, 2);
                playPlacingMarkerSound();
            }

            if (e.getX() >= 100 && e.getX() <= 300 && e.getY() >= 501 && e.getY() <= 700) {
                game.insertXO(2, 0);
                playPlacingMarkerSound();
            }

            if (e.getX() >= 301 && e.getX() <= 500 && e.getY() >= 501 && e.getY() <= 700) {
                game.insertXO(2, 1);
                playPlacingMarkerSound();
            }

            if (e.getX() >= 501 && e.getX() <= 700 && e.getY() >= 501 && e.getY() <= 700) {
                game.insertXO(2, 2);
                playPlacingMarkerSound();
            }
        }
 
        repaint();
    }
 
    public void mouseReleased(MouseEvent e) {}
 
    public void mouseEntered(MouseEvent e) {}
 
    public void mouseExited(MouseEvent e) {}
 
    public void mouseClicked(MouseEvent e) {}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton) {
            initializeGame();
        }
    }

    public void playTieSound() {
        try {
            URL url = this.getClass().getClassLoader().getResource("audio/tie.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public void playWinSound() {
        try {
            URL url = this.getClass().getClassLoader().getResource("audio/win.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public void playPlacingMarkerSound() {
        try {
            URL url = this.getClass().getClassLoader().getResource("audio/marker.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}