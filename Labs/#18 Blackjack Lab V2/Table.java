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
import java.util.ArrayList;
 
public class Table extends JPanel implements ActionListener {
    private JLabel playerLabel;
    private ArrayList<Card> playerHand;
    private int playerTotal;
    private JLabel playerTotalLabel;
    private int playerWins;
    private JLabel playerWinsJLabel;
    
    private JLabel dealerLabel;
    private ArrayList<Card> dealerHand;
    private int dealerTotal;
    private JLabel dealerTotalLabel;
    private int dealerWins;
    private JLabel dealerWinsJLabel;

    private JButton newGameButton;
    private JButton hitButton;
    private JButton standButton;
    private boolean isEndPlayerTurn;
    private boolean isDealerTurn;
    
    private ImageIcon loseAnimation;
    private ImageIcon winAnimation;
    private JLabel loseAnimationLabel;
    private JLabel winAnimationLabel;
    
    private ArrayList<Card> deck;
    private JLabel messageJLabel;

    public Table() {
        setLayout(null);

        playerLabel = new JLabel("Player");
        playerLabel.setBounds(30, 150, 50, 20);
        this.add(playerLabel);
        playerHand = new ArrayList<Card>();
        playerTotal = 0;
        playerTotalLabel = new JLabel("Player total: " + playerTotal);
        playerTotalLabel.setBounds(400, 10, 100, 50);
        this.add(playerTotalLabel);
        playerWins = 0;
        playerWinsJLabel = new JLabel("Player wins: " + playerWins);
        playerWinsJLabel.setBounds(500, 10, 100, 50);
        this.add(playerWinsJLabel);

        dealerLabel = new JLabel("Dealer");
        dealerLabel.setBounds(30, 350, 50, 20);
        this.add(dealerLabel);
        dealerHand = new ArrayList<Card>();
        dealerTotal = 0;
        dealerTotalLabel = new JLabel("Dealer total: " + dealerTotal);
        dealerTotalLabel.setBounds(400, 60, 100, 50);
        this.add(dealerTotalLabel);
        dealerWins = 0;
        dealerWinsJLabel = new JLabel("Dealer wins: " + dealerWins);
        dealerWinsJLabel.setBounds(500, 60, 100, 50);
        this.add(dealerWinsJLabel);
        
        newGameButton = new JButton("New Game");
        newGameButton.setBounds(850, 20, 100, 50);
        newGameButton.addActionListener(this);
        this.add(newGameButton);

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
        
        isEndPlayerTurn = false;
        isDealerTurn = false;
        
        loseAnimation = new ImageIcon("images/loser.gif");
        loseAnimationLabel = new JLabel(loseAnimation);
        loseAnimationLabel.setBounds(500, 150, 500, 500);
        this.add(loseAnimationLabel);
        loseAnimationLabel.setVisible(false);
        
        winAnimation = new ImageIcon("images/winner.gif");
        winAnimationLabel = new JLabel(winAnimation);
        winAnimationLabel.setBounds(500, 150, 400, 500);
        this.add(winAnimationLabel);
        winAnimationLabel.setVisible(false);

        deck = new ArrayList<Card>();
        deck.add(new Card(2, "2", "diamonds"));
        deck.add(new Card(3, "3", "diamonds"));
        deck.add(new Card(4, "4", "diamonds"));
        deck.add(new Card(5, "5", "diamonds"));
        deck.add(new Card(6, "6", "diamonds"));
        deck.add(new Card(7, "7", "diamonds"));
        deck.add(new Card(8, "8", "diamonds"));
        deck.add(new Card(9, "9", "diamonds"));
        deck.add(new Card(10, "10", "diamonds"));
        deck.add(new Card(10, "J", "diamonds"));
        deck.add(new Card(10, "Q", "diamonds"));
        deck.add(new Card(10, "K", "diamonds"));
        deck.add(new Card(11, "A", "diamonds"));
        deck.add(new Card(2, "2", "hearts"));
        deck.add(new Card(3, "3", "hearts"));
        deck.add(new Card(4, "4", "hearts"));
        deck.add(new Card(5, "5", "hearts"));
        deck.add(new Card(6, "6", "hearts"));
        deck.add(new Card(7, "7", "hearts"));
        deck.add(new Card(8, "8", "hearts"));
        deck.add(new Card(9, "9", "hearts"));
        deck.add(new Card(10, "10", "hearts"));
        deck.add(new Card(10, "J", "hearts"));
        deck.add(new Card(10, "Q", "hearts"));
        deck.add(new Card(10, "K", "hearts"));
        deck.add(new Card(11, "A", "hearts"));
        deck.add(new Card(2, "2", "spades"));
        deck.add(new Card(3, "3", "spades"));
        deck.add(new Card(4, "4", "spades"));
        deck.add(new Card(5, "5", "spades"));
        deck.add(new Card(6, "6", "spades"));
        deck.add(new Card(7, "7", "spades"));
        deck.add(new Card(8, "8", "spades"));
        deck.add(new Card(9, "9", "spades"));
        deck.add(new Card(10, "10", "spades"));
        deck.add(new Card(10, "J", "spades"));
        deck.add(new Card(10, "Q", "spades"));
        deck.add(new Card(10, "K", "spades"));
        deck.add(new Card(11, "A", "spades"));
        deck.add(new Card(2, "2", "clubs"));
        deck.add(new Card(3, "3", "clubs"));
        deck.add(new Card(4, "4", "clubs"));
        deck.add(new Card(5, "5", "clubs"));
        deck.add(new Card(6, "6", "clubs"));
        deck.add(new Card(7, "7", "clubs"));
        deck.add(new Card(8, "8", "clubs"));
        deck.add(new Card(9, "9", "clubs"));
        deck.add(new Card(10, "10", "clubs"));
        deck.add(new Card(10, "J", "clubs"));
        deck.add(new Card(10, "Q", "clubs"));
        deck.add(new Card(10, "K", "clubs"));
        deck.add(new Card(11, "A", "clubs"));

        messageJLabel = new JLabel("Press \"New Game\" to begin.");
        messageJLabel.setBounds(150, 400, 200, 200);
        this.add(messageJLabel);
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
        for ( int i = 0; i < playerHand.size(); i++ ) {
            playerHand.get(i).drawMe(g, x, y);
            x += 80;
            setTotal();
        }

        x = 100;
        y = 300;
        for ( int i = 0; i < dealerHand.size(); i++ ) {
            if (!isEndPlayerTurn) {
                g.setColor(Color.WHITE);
                g.fillRect(100, 300, 120, 150);
            }
            dealerHand.get(i).drawMe(g, x, y);
            x += 80;
            setTotal();
        }

        if (playerTotal >= 21 && isEndPlayerTurn == false) {
            endPlayerTurn();
            checkPlayerEndGameConditions();
        }

        if (isDealerTurn) {
            if (dealerTotal < 17) {
                dealerHit();
            } else {
                isDealerTurn = false;
                checkDealerEndGameConditions();
            }
        }
    }
    
 
    private void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int randomIndex = (int)(Math.random() * deck.size());
            Card card1 = deck.get(i);
            Card card2 = deck.get(randomIndex);

            deck.set(randomIndex, card1);
            deck.set(i, card2);
        }
    }

    private void setTotal() {
        playerTotal = 0;
        int aceCounter = 0;
        for (int i = 0; i < playerHand.size(); i++) {
            playerTotal += playerHand.get(i).getValue();
            if (playerHand.get(i).getValue() == 11) {
                aceCounter++;
            }
        }

        // setting ace value to ideal value for player
        while (playerTotal > 21 && aceCounter > 0) {
            playerTotal -= 10;
            aceCounter--;
        }

        dealerTotal = 0;
        aceCounter = 0;
        for (int i = 1; i < dealerHand.size(); i++) {
            dealerTotal += dealerHand.get(i).getValue();
            if (dealerHand.get(i).getValue() == 11) {
                aceCounter++;
            }
        }
        if (isEndPlayerTurn) {
            dealerTotal += dealerHand.get(0).getValue(); // revealing hidden card value
        }

        // setting ace value to ideal value for dealer
        while (dealerTotal > 21 && aceCounter > 0) {
            dealerTotal -= 10;
            aceCounter--;
        }

        playerTotalLabel.setText("Total: " + playerTotal);
        dealerTotalLabel.setText("Total: " + dealerTotal);
        repaint();
    }

    private void playerHit() {
        playerHand.add(deck.get(0));
        deck.remove(0);
    }

    private void dealerHit() {
        dealerHand.add(deck.get(0));
        deck.remove(0);
    }

    private void initializeGame() {
        // resetting hands and deck
        for (Card each : playerHand) {
            deck.add(each);
        }
        playerHand.clear();

        for (Card each : dealerHand) {
            deck.add(each);
        }
        dealerHand.clear();

        loseAnimationLabel.setVisible(false);
        winAnimationLabel.setVisible(false);
        messageJLabel.setText("");
        isEndPlayerTurn = false;
        isDealerTurn = false;
        newGameButton.setVisible(false);
        hitButton.setVisible(true);
        standButton.setVisible(true);
        playerWinsJLabel.setText("Player Wins: " + playerWins);
        shuffle();

        playerHand.add(deck.get(0));
        deck.remove(0);
        playerHand.add(deck.get(0));
        deck.remove(0);

        dealerHand.add(deck.get(0));
        deck.remove(0);
        dealerHand.add(deck.get(0));
        deck.remove(0);

        repaint();
    }

    private void checkPlayerEndGameConditions() {
        if (isEndPlayerTurn) {
            if (playerTotal <= 21) {
                isDealerTurn = true;
            } else if (playerTotal > 21) {
                messageJLabel.setText("You lose");
                dealerWins += 1;
                loseAnimationLabel.setVisible(true);
            }
        }
    }

    private void checkDealerEndGameConditions() {
        if (!isDealerTurn) {
            if (dealerTotal > 21) {
                playerWins++;
                winAnimationLabel.setVisible(true);
                messageJLabel.setText("You win!");
                playerWinsJLabel.setText("Player Wins: " + playerWins);
            } else {
                if (dealerTotal > playerTotal) {
                    dealerWins++;
                    loseAnimationLabel.setVisible(true);
                    messageJLabel.setText("You lose");
                    dealerWinsJLabel.setText("Dealer Wins: " + dealerWins);
                } else if (dealerTotal < playerTotal) {
                    playerWins++;
                    winAnimationLabel.setVisible(true);
                    messageJLabel.setText("You win!");
                    playerWinsJLabel.setText("Player Wins: " + playerWins);
                } else {
                    messageJLabel.setText("Tie");                    
                }
            }
        }
    }

    private void endPlayerTurn() {
        newGameButton.setVisible(true);
        hitButton.setVisible(false);
        standButton.setVisible(false);
        isEndPlayerTurn = true;
    }
     
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hitButton) {
            if (playerTotal < 21) {
                playerHit();
            }
        } else if (e.getSource() == standButton ) {
            endPlayerTurn();
            checkPlayerEndGameConditions();
        } else if (e.getSource() == newGameButton) {
            initializeGame();
            repaint();
        }
    }
}