import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
 
public class Table extends JPanel implements ActionListener {
    private Card[] deck;
    private int playerIndex;
    private int total;
    private int points;
    boolean isEndGame;
    private JButton hitButton;
    private JButton standButton;
    private JButton newGameButton;
    private JLabel totalLabel;
    private JLabel pointsLabel;
    private JLabel messageJLabel;
    private ImageIcon loseAnimation;
    private ImageIcon winAnimation;
    private JLabel loseAnimationLabel;
    private JLabel winAnimationLabel;

    public Table() {
        setLayout(null);

        deck = new Card[52];
        deck[0] = new Card(2, "2", "diamonds");
        deck[1] = new Card(3, "3", "diamonds");
        deck[2] = new Card(4, "4", "diamonds");
        deck[3] = new Card(5, "5", "diamonds");
        deck[4] = new Card(6, "6", "diamonds");
        deck[5] = new Card(7, "7", "diamonds");
        deck[6] = new Card(8, "8", "diamonds");
        deck[7] = new Card(9, "9", "diamonds");
        deck[8] = new Card(10, "10", "diamonds");
        deck[9] = new Card(10, "J", "diamonds");
        deck[10] = new Card(10, "Q", "diamonds");
        deck[11] = new Card(10, "K", "diamonds");
        deck[12] = new Card(11, "A", "diamonds");
        deck[13] = new Card(2, "2", "hearts");
        deck[14] = new Card(3, "3", "hearts");
        deck[15] = new Card(4, "4", "hearts");
        deck[16] = new Card(5, "5", "hearts");
        deck[17] = new Card(6, "6", "hearts");
        deck[18] = new Card(7, "7", "hearts");
        deck[19] = new Card(8, "8", "hearts");
        deck[20] = new Card(9, "9", "hearts");
        deck[21] = new Card(10, "10", "hearts");
        deck[22] = new Card(10, "J", "hearts");
        deck[23] = new Card(10, "Q", "hearts");
        deck[24] = new Card(10, "K", "hearts");
        deck[25] = new Card(11, "A", "hearts");
        deck[26] = new Card(2, "2", "spades");
        deck[27] = new Card(3, "3", "spades");
        deck[28] = new Card(4, "4", "spades");
        deck[29] = new Card(5, "5", "spades");
        deck[30] = new Card(6, "6", "spades");
        deck[31] = new Card(7, "7", "spades");
        deck[32] = new Card(8, "8", "spades");
        deck[33] = new Card(9, "9", "spades");
        deck[34] = new Card(10, "10", "spades");
        deck[35] = new Card(10, "J", "spades");
        deck[36] = new Card(10, "Q", "spades");
        deck[37] = new Card(10, "K", "spades");
        deck[38] = new Card(11, "A", "spades");
        deck[39] = new Card(2, "2", "clubs");
        deck[40] = new Card(3, "3", "clubs");
        deck[41] = new Card(4, "4", "clubs");
        deck[42] = new Card(5, "5", "clubs");
        deck[43] = new Card(6, "6", "clubs");
        deck[44] = new Card(7, "7", "clubs");
        deck[45] = new Card(8, "8", "clubs");
        deck[46] = new Card(9, "9", "clubs");
        deck[47] = new Card(10, "10", "clubs");
        deck[48] = new Card(10, "J", "clubs");
        deck[49] = new Card(10, "Q", "clubs");
        deck[50] = new Card(10, "K", "clubs");
        deck[51] = new Card(11, "A", "clubs");

        playerIndex = 0;
        total = 0;
        points = 20;
        isEndGame = false;

        hitButton = new JButton("HIT");
        hitButton.setBounds(200, 20, 100, 50);
        hitButton.addActionListener(this);
        this.add(hitButton);
        hitButton.setVisible(false);

        standButton = new JButton("STAND");
        standButton.setBounds(100, 20, 100, 50);
        standButton.addActionListener(this);
        this.add(standButton);
        standButton.setVisible(false);

        newGameButton = new JButton("New Game");
        newGameButton.setBounds(850, 20, 100, 50);
        newGameButton.addActionListener(this);
        this.add(newGameButton);

        totalLabel = new JLabel("Total: " + total);
        totalLabel.setBounds(400, 20, 100, 50);
        this.add(totalLabel);

        pointsLabel = new JLabel("Points: " + points);
        pointsLabel.setBounds(500, 20, 100, 50);
        this.add(pointsLabel);

        messageJLabel = new JLabel("Press \"New Game\" to begin.");
        messageJLabel.setBounds(150, 300, 200, 200);
        this.add(messageJLabel);

        loseAnimation = new ImageIcon("images/loser.gif");
        winAnimation = new ImageIcon("images/winner.gif");
        
        loseAnimationLabel = new JLabel(loseAnimation);
        loseAnimationLabel.setBounds(500, 150, 500, 500);
        this.add(loseAnimationLabel);
        loseAnimationLabel.setVisible(false);

        winAnimationLabel = new JLabel(winAnimation);
        winAnimationLabel.setBounds(500, 150, 400, 500);
        this.add(winAnimationLabel);
        winAnimationLabel.setVisible(false);
    }
     
    public Dimension getPreferredSize() {
        return new Dimension(1000, 600);
    }
 
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 1000, 600);

        int x = 100;
        int y = 100;
        for ( int i = 0; i < playerIndex; i++ ) {
            deck[i].drawMe(g, x, y);
            x += 80;
            setTotal();
        }

        if (total >= 21 && isEndGame == false) {
            endGame();
            checkEndGameConditions();
        }
    }
    
 
    private void shuffle() {
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = (int)(Math.random() * deck.length);
            Card firstNum = deck[i];
            Card secondNum = deck[randomIndex];

            deck[randomIndex] = firstNum;
            deck[i] = secondNum;
        }
    }

    private void setTotal() {
        total = 0;
        int aceCounter = 0;
        for (int i = 0; i < playerIndex; i++) {
            total += deck[i].getValue();
            if (deck[i].getValue() == 11) {
                aceCounter++;
            }
        }

        // setting ace value to ideal value for player
        while (total > 21 && aceCounter > 0) {
            total -= 10;
        }

        totalLabel.setText("Total: " + total);
        repaint();
    }

    private void initializeGame() {
        loseAnimationLabel.setVisible(false);
        winAnimationLabel.setVisible(false);
        messageJLabel.setText("");
        isEndGame = false;
        newGameButton.setVisible(false);
        hitButton.setVisible(true);
        standButton.setVisible(true);
        points--;
        pointsLabel.setText("Points: " + points);
        shuffle();
        playerIndex = 2;
        repaint();
    }

    private void checkEndGameConditions() {
        if (isEndGame) {
            if (total <= 15 || total > 21) {
                messageJLabel.setText("You get 0 points.");
                loseAnimationLabel.setVisible(true);
            } else if (total >= 16 && total <= 18) {
                points += 1;
                messageJLabel.setText("You get 1 point!");
                pointsLabel.setText("Points: " + points);
                winAnimationLabel.setVisible(true);
            } else if (total == 19) {
                points += 2;
                messageJLabel.setText("You get 2 points!");
                pointsLabel.setText("Points: " + points);
                winAnimationLabel.setVisible(true);
            } else if (total == 20) {
                points += 3;
                messageJLabel.setText("You get 3 points!");
                pointsLabel.setText("Points: " + points);
                winAnimationLabel.setVisible(true);
            } else if (total == 21) {
                points += 5;
                messageJLabel.setText("You get 5 points!");
                pointsLabel.setText("Points: " + points);
                winAnimationLabel.setVisible(true);
            }
        }
    }

    private void endGame() {
        newGameButton.setVisible(true);
        hitButton.setVisible(false);
        standButton.setVisible(false);
        isEndGame = true;
    }
     
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hitButton) {
            if (total < 21) {
                playerIndex++;
            }
        } else if (e.getSource() == standButton ) {
            endGame();
            checkEndGameConditions();
        } else if (e.getSource() == newGameButton) {
            initializeGame();
            repaint();
        }
    }
}