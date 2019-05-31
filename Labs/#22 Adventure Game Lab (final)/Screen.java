import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Screen extends JPanel implements KeyListener, ActionListener {
    private CharacterRalph ralph;
    private CharacterApu apu;
    private CharacterBart bart;
    private CharacterChief wiggum;
    private CharacterKrusty krusty;
    private CharacterAbe abe;

    private ArrayList<Item> items;
    private ArrayList<Item> collectedItems;

    private ArrayList<Location> locations;
    private int row;
    private int col;
    private JTextArea locationNumberTextArea;

    private ArrayList<String> dialogue0;
    private ArrayList<String> dialogue1;
    private ArrayList<String> dialogue2;
    private ArrayList<String> dialogue3;
    private ArrayList<String> dialogue4;
    private ArrayList<ArrayList<String>> dialogues;
    private int dialogueSetNumber;
    private int dialoguePartNumber ;
    private JTextArea dialogueBox;

    private int questNumber;
    private JTextArea questNumberTextArea;
    private boolean quest1Completed;
    private boolean quest2Completed;
    private boolean quest3Completed;    

    private JTextArea instructionsTextArea;
    private boolean instructionsTextAreaVisibility;

    private InventoryScreen inventory;
    private EndGameScreen egs;

    private Image logo;

    private JButton startButton;

    private boolean x;

    public Screen() {
        addKeyListener(this);
        setLayout(null);
        setFocusable(true);

        ralph = new CharacterRalph("ralph.png", 250, 250, 55, 90);
        apu = new CharacterApu("apu.png", 370, 240, 38, 100);
        bart = new CharacterBart("bart.png", 190, 260, 80, 120);
        wiggum = new CharacterChief("chief.png", 190, 260, 88, 132);
        krusty = new CharacterKrusty("krusty.png", 290, 290, 83, 109);
        abe = new CharacterAbe("abe.png", 530, 260, 52, 100);

        items = new ArrayList<Item>();
        items.add(new ItemBroccoli("broccoli.png", 280, 120, 50, 50, "Found the broccoli! Now return to Apu."));
        items.add(new ItemDonut("donuts.png", 360, 360, 60, 48, "Yum."));
        items.add(new ItemCard("card.png", 540, 340, 72, 43, "Card successfully stolen! Now bring it to Bart's house. Location (1, 0)"));
        items.add(new ItemSpeedBoost("speed-boost.png", 300, 60, 68, 68, "Gooo!"));
        items.add(new ItemBurger("burger.png", 430, 360, 60, 54, "Go to the retirement castle now! Abe is hungry. Location (2, 0)"));
        items.add(new ItemMoney("money.png", 630, 300, 60, 54, "Make it rain. Return to the Kwik-E-Mart to complete Quest 3. Location (0, 0)"));
        collectedItems = new ArrayList<Item>(); // currently empty

        locations = new ArrayList<Location>();
        locations.add(new Location(true, "kwik-e-mart.png", 800, 450));
        locations.add(new Location(true, "krusty-burger.png", 800, 450));
        locations.add(new Location(true, "school.png", 800, 450));
        locations.add(new Location(true, "house.png", 800, 450));
        locations.add(new Location(true, "farm.png", 800, 450));
        locations.add(new Location(true, "card-shop.png", 800, 450));
        locations.add(new Location(true, "retirement-home.png", 800, 450));
        locations.add(new Location(true, "music-store.png", 800, 450));
        locations.add(new Location(true, "police-station.png", 800, 450));
        // keeping track of location as a imaginary 3 x 3 grid
        row = -1;
        col = -1;
        // display location #
        locationNumberTextArea = new JTextArea("Location: (" + row + ", " + col + ")");
        locationNumberTextArea.setBounds(620, 0, 120, 20);
        locationNumberTextArea.setEditable(false);
        this.add(locationNumberTextArea);

        // #0
        dialogue0 = new ArrayList<String>();
        dialogue0.add("Apu: Hello Ralph.");
        dialogue0.add("Ralph: How's it going my dude.");
        dialogue0.add("Apu: Can you run an errand for me?");
        dialogue0.add("Ralph: Sure, what do you need?");
        dialogue0.add("Apu: I need you to stop by Cletus' farm to get some broccoli. Location (1,1)");
        dialogue0.add("Ralph: Alright, I'll be right back...");
        // #1
        dialogue1 = new ArrayList<String>();
        dialogue1.add("Apu: Thanks for bringing the broccoli.");
        dialogue1.add("Ralph: De nada.");
        dialogue1.add("Apu: There are some donuts at the Simpson's house. Grab them, you'll need it for later. Location (1,0)");
        dialogue1.add("Ralph: Sure...");
        // #2
        dialogue2 = new ArrayList<String>();
        dialogue2.add("Bart: Yo.");
        dialogue2.add("Ralph: Apu told me to see you.");
        dialogue2.add("Bart: Oh ya, I need you to steal some cards from Android's Dungeon. Location (1, 2)");
        dialogue2.add("Ralph: Alright.");
        dialogue2.add("Bart: There is always some card deliveries laying at the front door. Just take it, nobody will notice.");
        dialogue2.add("Ralph: Ok.");
        dialogue2.add("Bart: Then drop it off at my house...");
        // #3
        dialogue3 = new ArrayList<String>();
        dialogue3.add("Krusty: I need you to make a delivery.");
        dialogue3.add("Ralph: To who?");
        dialogue3.add("Krusty: Abe Simpson. He ordered a burger through DoorDash.");
        dialogue3.add("Ralph: Ok, where is he right now?");
        dialogue3.add("Krusty: The retirement castle. Here's the burger. Make it quick...");
        // #4
        dialogue4 = new ArrayList<String>();
        dialogue4.add("Abe: Where my burger at?");
        dialogue4.add("Ralph: Right here.");
        dialogue4.add("Abe: Preciate it.");
        dialogue4.add("Ralph: Not a problem.");
        dialogue4.add("Abe: Apu also promised to give me some donuts for winning last week's BINGO. Where they at?");
        dialogue4.add("Ralph: Here they are.");
        dialogue4.add("Abe: Thanks. Here's a tip.");
        dialogue4.add("Go collect the money...");
        // list of dialogues
        dialogues = new ArrayList<ArrayList<String>>();
        dialogues.add(dialogue0);
        dialogues.add(dialogue1);
        dialogues.add(dialogue2);
        dialogues.add(dialogue3);
        dialogues.add(dialogue4);
        // keeping track of dialogue set number an specific part in current set
        dialogueSetNumber = 0;
        dialoguePartNumber  = 0;
        // text area to display dialogue
        dialogueBox = new JTextArea();
        dialogueBox.setBounds(0, 420, 800, 30);
        dialogueBox.setEditable(false);
        this.add(dialogueBox);

        // current quest number
        questNumber = 1;
        // text area to display quest number
        questNumberTextArea = new JTextArea("Quest: " + questNumber);
        questNumberTextArea.setBounds(740, 0, 60, 20);
        questNumberTextArea.setEditable(false);
        this.add(questNumberTextArea);
        quest1Completed = false;
        quest2Completed = false;
        quest3Completed = false;

        // text area to display instructions 
        instructionsTextArea = new JTextArea("P --> skip quest\nO --> show inventory\nW --> move up\nA --> move left\nS --> move down\nD --> move right\nC --> interact (continue clicking 'c' to continue conversation); be within one character length\nU --> drop item (do when prompted)\nI --> open instructions screen\n\nLocations:\n(0,0)  (0,1)  (0,2)\n(1,0)  (1,1)  (1,2)\n(2,0)  (2,1)  (2,2)\n");
        instructionsTextArea.setBounds(0, 0, 800, 300);
        instructionsTextArea.setEditable(false);
        this.add(instructionsTextArea);
        // keeping track of visibility; at start of game show instruction
        instructionsTextAreaVisibility = true;

        // screen to show collected items
        inventory = new InventoryScreen();

        // after completing all 3 quest, this the end game screen
        egs = new EndGameScreen();

        // logo for start screen
        try {
            logo = ImageIO.read(new File("images/logo.png"));
            logo = logo.getScaledInstance(256, 110, Image.SCALE_DEFAULT);
        } catch ( IOException e ){
            System.out.println(e);
        }

        startButton = new JButton("Play!");
        startButton.setBounds(600, 300, 200, 120);
        startButton.addActionListener(this);
        this.add(startButton);

        x = true;
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 450);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (row == -1 && col == -1) { // start screen
            g.setColor(Color.WHITE);
            g.fillRect(0, 300, 600, 200);
            g.drawImage(logo, 250, 300, null);
        } else if (row == 0 && col == 0) {
            locations.get(0).drawMe(g);
        } else if (row == 0 && col == 1) {
            locations.get(1).drawMe(g);
        } else if (row == 0 && col == 2) {
            locations.get(2).drawMe(g);
        } else if (row == 1 && col == 0) {
            locations.get(3).drawMe(g);
        } else if (row == 1 && col == 1) {
            locations.get(4).drawMe(g);
        } else if (row == 1 && col == 2) {
            locations.get(5).drawMe(g);
        } else if (row == 2 && col == 0) {
            locations.get(6).drawMe(g);
        } else if (row == 2 && col == 1) {
            locations.get(7).drawMe(g);
        } else if (row == 2 && col == 2) {
            locations.get(8).drawMe(g);
        }

        setLocationFeatures();
        checkBoundaries();
        checkQuestCompletion();
        apu.drawMe(g);
        bart.drawMe(g);
        wiggum.drawMe(g);
        krusty.drawMe(g);
        abe.drawMe(g);

        for (Item each : items) {
            each.drawMe(g);
            detectCollision(each);
        }
        
        ralph.drawMe(g);
        inventory.drawMe(g, collectedItems);
        egs.drawMe(g);
    }

    public void setLocationFeatures() {
        // quest 1
        if (row == 0 && col == 0 && questNumber == 1) {
            apu.setVisible(true);
        } else {
            apu.setVisible(false);
        }

        if (row == 1 && col == 0 && items.get(1).isCollected() == false && questNumber == 1 || questNumber == 3 && row == 2 && col == 0 && abe.requestedDonuts() == true) {
            items.get(1).setVisible(true);
        } else {
            items.get(1).setVisible(false);
        }

        if (questNumber == 3 && row == 2 && col == 0 && dialogueSetNumber == 4 && dialoguePartNumber == 7) {
            abe.setReceivedDonuts(true);
        }

        if (questNumber == 3 && row == 2 && col == 0 && dialogueSetNumber == 4 && dialoguePartNumber >= 6) {
            abe.setRequestedDonuts(true);
        }

        if (row == 1 && col == 1 && items.get(0).isCollected() == false && questNumber == 1) {
            items.get(0).setVisible(true);
        } else {
            items.get(0).setVisible(false);
        }

        //quest 2
        if (row == 0 && col == 2 && questNumber == 2) {
            bart.setVisible(true);
        } else {
            bart.setVisible(false);
        }

        if (row == 1 && col == 2 && items.get(2).isCollected() == false && questNumber == 2 || row == 1 && col == 0 && items.get(2).isCollected() == true && questNumber == 2 && ralph.isRequestingToDrop() == true) {
            items.get(2).setVisible(true);
        } else {
            items.get(2).setVisible(false);            
        }

        if (row == 1 && col == 0 && items.get(2).isCollected() == true && questNumber == 2 && ralph.isRequestingToDrop() == false) {
            dialogueBox.setText("Bart asked to drop the cards at his house. Press U to do so.");
        }

        if (row == 1 && col == 0 && questNumber == 2 && ralph.isTimeToEscape() == true && items.get(3).isCollected() == false) {
            items.get(3).setVisible(true);
        } else {
            items.get(3).setVisible(false);
        }

        if (row == 1 && col == 0 && questNumber == 2 && ralph.isTimeToEscape() == true) {
            wiggum.setVisible(true);
        } else {
            wiggum.setVisible(false);
        }

        if (items.get(3).isCollected() == true && questNumber == 2) {
            ralph.setSpeedBoost(true);
        } else {
            ralph.setSpeedBoost(false);
        }

        if (questNumber == 3 && row == 0 && col == 1) {
            krusty.setVisible(true);
        } else {
            krusty.setVisible(false);
        }

        if (questNumber == 3 && row == 0 && col == 1 && krusty.hasRequested() == true && items.get(4).isCollected() == false || row == 2 && col == 0 && abe.requestedBurger() == true) {
            items.get(4).setVisible(true);
        } else {
            items.get(4).setVisible(false);
        }

        if (questNumber == 3 && row == 2 && col == 0 && dialogueSetNumber == 4 && dialoguePartNumber == 2) {
            abe.setRequestedBurger(true);
        }

        if (questNumber == 3 && row == 2 && col == 0) {
            abe.setVisible(true);
        } else {
            abe.setVisible(false);
        }

        if (quest3Completed) {
            egs.setVisible(true); // showing end game screen
        } else {
            egs.setVisible(false);
        }

        if (row == 2 && col == 0 && abe.receivedDonuts() == true && questNumber == 3 && items.get(5).isCollected() == false) {
            items.get(5).setVisible(true);
        } else {
            items.get(5).setVisible(false);
        }

        if (dialoguePartNumber == 5 && dialogueSetNumber == 3) {
            krusty.setRequestStatus(true);
        }
        
        if (items.get(4).isCollected() == true && row == 2 && col == 0 && x) {
            unlockNextDialogueSet();
            x = false;
        }

        repaint();
    }

    public void checkBoundaries() {
        if (row == 0 && col == 0) {
            if (ralph.getX() > 800) {
                ralph.setX(0);
                col++;
            }

            if (ralph.getX() < 0) {
                ralph.setX(0);
            }

            if (ralph.getY() > 330) {
                ralph.setY(0);
                row++;
            }

            if (ralph.getY() < 0) {
                ralph.setY(0);
            }
        } else if (row == 1 && col == 0) {
            if (ralph.getX() > 800) {
                ralph.setX(0);
                col++;
            }

            if (ralph.getX() < 0) {
                ralph.setX(0);
            }

            if (ralph.getY() > 330) {
                ralph.setY(0);
                row++;
            }

            if (ralph.getY() < 0) {
                ralph.setY(330);
                row--;
            }
        } else if (row == 2 && col == 0) {
            if (ralph.getX() > 800) {
                ralph.setX(0);
                col++;
            }

            if (ralph.getX() < 0) {
                ralph.setX(0);
            }

            if (ralph.getY() > 330) {
                ralph.setY(330);
            }

            if (ralph.getY() < 0) {
                ralph.setY(330);
                row--;
            }
        } else if (row == 0 && col == 1) {
            if (ralph.getX() > 800) {
                ralph.setX(0);
                col++;
            }

            if (ralph.getX() < 0) {
                ralph.setX(800);
                col--;
            }

            if (ralph.getY() > 330) {
                ralph.setY(0);
                row++;
            }

            if (ralph.getY() < 0) {
                ralph.setY(0);
            }
        } else if (row == 1 && col == 1) {
            if (ralph.getX() > 800) {
                ralph.setX(0);
                col++;
            }

            if (ralph.getX() < 0) {
                ralph.setX(800);
                col--;
            }

            if (ralph.getY() > 330) {
                ralph.setY(0);
                row++;
            }

            if (ralph.getY() < 0) {
                ralph.setY(330);
                row--;
            }
        } else if (row == 2 && col == 1) {
            if (ralph.getX() > 800) {
                ralph.setX(0);
                col++;
            }

            if (ralph.getX() < 0) {
                ralph.setX(800);
                col--;
            }

            if (ralph.getY() > 330) {
                ralph.setY(330);
            }

            if (ralph.getY() < 0) {
                ralph.setY(330);
                row--;
            }
        } else if (row == 0 && col == 2) {
            if (ralph.getX() > 745) {
                ralph.setX(745);
            }

            if (ralph.getX() < 0) {
                ralph.setX(800);
                col--;
            }

            if (ralph.getY() > 330) {
                ralph.setY(0);
                row++;
            }

            if (ralph.getY() < 0) {
                ralph.setY(0);
            }
        } else if (row == 1 && col == 2) {
            if (ralph.getX() > 745) {
                ralph.setX(745);
            }

            if (ralph.getX() < 0) {
                ralph.setX(800);
                col--;
            }

            if (ralph.getY() > 330) {
                ralph.setY(0);
                row++;
            }

            if (ralph.getY() < 0) {
                ralph.setY(330);
                row--;
            }
        } else if (row == 2 && col == 2) {
            if (ralph.getX() > 745) {
                ralph.setX(745);
            }

            if (ralph.getX() < 0) {
                ralph.setX(800);
                col--;
            }

            if (ralph.getY() > 330) {
                ralph.setY(330);
            }

            if (ralph.getY() < 0) {
                ralph.setY(330);
                row--;
            }
        }

        locationNumberTextArea.setText("Location: (" + row + ", " + col + ")");

        repaint();
    }

    public void detectCollision(Item item) {
        if (item.isVisible() == true && ralph.checkCollision(item) == true && item.isCollected() == false) {
            collectedItems.add(item);
            item.setVisible(false);
            item.setCollected(true);
            dialogueBox.setText(item.getDialogueBoxMessage());
            playItemCollectedSound();
            unlockNextDialogueSet();
        }
    }

    public void unlockNextDialogueSet() {
        if (row == 2 && col == 0 || row == 1 && col == 1) {
            dialogueSetNumber++;
            dialoguePartNumber = 0;
        }
    }

    public void checkQuestCompletion() {
        if (questNumber == 1) {
            if (items.get(0).isCollected() && items.get(1).isCollected()) {
                quest1Completed = true;
                progressToNextQuest();
            }
        } else if (questNumber == 2) {
            if (row == 1 && col == 1 && items.get(3).isCollected() == true) {
                quest2Completed = true;
                progressToNextQuest();
            }
        } else if (questNumber == 3) {
            if (row == 0 && col == 0 && items.get(5).isCollected() == true && quest3Completed == false) {
                quest3Completed = true;
                progressToNextQuest();
            }
        }
    } 

    public void progressToNextQuest() {
        for (int i = 0; i < collectedItems.size(); i++) {
            collectedItems.remove(collectedItems.get(i));
            i--;
        }

        boolean aQuestCompleted = false;

        if (quest3Completed) {
            dialogueBox.setText("Congratulations. Quest 1, 2 and 3 all completed.");

            collectedItems.add(items.get(0));
            collectedItems.add(items.get(1));
            collectedItems.add(items.get(2));
            collectedItems.add(items.get(3));
            collectedItems.add(items.get(4));       
            collectedItems.add(items.get(5)); 

            aQuestCompleted = true;
        } else if (quest2Completed) {
            dialogueBox.setText("Quest 2 Completed! Go to Krusty Burger and talk to Krusty for your next quest. Location (0, 1)");
            questNumber++;
            questNumberTextArea.setText("Quest: " + questNumber);
            dialogueSetNumber = 3;

            collectedItems.add(items.get(0));
            collectedItems.add(items.get(1));
            collectedItems.add(items.get(2));
            collectedItems.add(items.get(3));

            aQuestCompleted = true;
        } else if (quest1Completed) {
            dialogueBox.setText("Quest 1 Completed! Go to the school and talk to Bart for your next quest. Location: (0, 2)");
            questNumber++;
            questNumberTextArea.setText("Quest: " + questNumber);
            dialogueSetNumber = 2;

            collectedItems.add(items.get(0));
            collectedItems.add(items.get(1));

            aQuestCompleted = true;            
        }

        if (aQuestCompleted) {
            playQuestCompletionSound();
        }

        dialoguePartNumber = 0;
    }

    public void progressConversation() {
        if (dialogueSetNumber < dialogues.size()) {
            if (dialoguePartNumber < dialogues.get(dialogueSetNumber).size()) {
                dialogueBox.setText(dialogues.get(dialogueSetNumber).get(dialoguePartNumber));
                dialoguePartNumber++;
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        if (row != -1 && col != -1) { // disable controls before start of game
            if (e.getKeyCode() == 87) { // W
                ralph.move("up");
            } else if (e.getKeyCode() == 65) { // A
                ralph.move("left");
            } else if (e.getKeyCode() == 83) { // S
                ralph.move("down");
            } else if (e.getKeyCode() == 68) { // D
                ralph.move("right");
            } else if (e.getKeyCode() == 73) { // I
                instructionsTextArea.setVisible(!instructionsTextAreaVisibility);
                instructionsTextAreaVisibility = !instructionsTextAreaVisibility;
            } else if (e.getKeyCode() == 67) { //C
                if (ralph.checkInRangeOtherCharacters(apu) == true && questNumber == 1) {
                    progressConversation();
                } else if (ralph.checkInRangeOtherCharacters(bart) == true && questNumber == 2) {
                    progressConversation();
                } else if (ralph.checkInRangeOtherCharacters(krusty) == true && questNumber == 3) {
                    progressConversation();
                } else if (ralph.checkInRangeOtherCharacters(abe) == true && questNumber == 3) {
                    progressConversation();
                }
            } else if (e.getKeyCode() == 79) { // O
                inventory.setVisible(!inventory.getVisible());
            } else if (e.getKeyCode() == 80) { // P
                if (questNumber == 1) {
                    quest1Completed = true;
                    progressToNextQuest();
                } else if (questNumber == 2) {
                    quest2Completed = true;
                    progressToNextQuest();
                } else if (questNumber == 3) {
                    quest3Completed = true;
                    progressToNextQuest();
                }
            } else if (e.getKeyCode() == 85) { // U
                if (questNumber == 2 && row == 1 && col == 0 && items.get(2).isCollected() == true && items.get(3).isCollected() == false) {
                    ralph.setRequestingToDrop(true);
                    dialogueBox.setText("Oops. The police saw you steal those cards! Grab the speed boost and run to Cletus' Farm! Location (1,1)");
                    ralph.setTimeToEscape(true);
                }
            }
        }

        // System.out.println(e.getKeyCode());

        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            // initializing game
            row++;
            col++;

            instructionsTextArea.setVisible(false);
            instructionsTextAreaVisibility = false;

            startButton.setVisible(false);
            ralph.setVisible(true);

            dialogueBox.setText("Go talk to Apu. Make sure to be 1-character-length away and then press 'C'.");
        }
    }

    public void playQuestCompletionSound() {
        try {
            URL url = this.getClass().getClassLoader().getResource("audio/goat.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public void playItemCollectedSound() {
        try {
            URL url = this.getClass().getClassLoader().getResource("audio/bloop.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
    
    // necessary methods
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}