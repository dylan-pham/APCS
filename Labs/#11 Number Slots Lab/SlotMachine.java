import java.awt.Graphics;
import java.awt.Color;

import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SlotMachine {
    private int num1;
    private int num2;
    private int num3;
    private int bet;
    private int winnings;
    private int balance;
    private String message = "";
    private boolean access;

    public SlotMachine(int balance) {
        num1 = 0;
        num2 = 0;
        num3 = 0;
        this.balance = balance;
        access = true;
    }

    public void drawMe(Graphics g) {
        Color black = new Color(0, 0, 0);
        Color white = new Color(255, 255, 255);
        Color red = new Color(247, 2, 35);
        Color green = new Color(18, 140, 7);

        //creates slot machine
        g.setColor(black);
        g.fillRect(100, 100, 200, 400);
        g.fillRect(300, 300, 30, 10);
        g.fillRect(330, 210, 10, 100);
        g.setColor(red);
        g.fillOval(315, 200, 40, 40);

        //creates slots
        g.setColor(white);
        g.drawString(num1 + " | ", 150, 150);
        g.drawString(num2 + " | ", 200, 150);
        g.drawString(num3 + " | ", 250, 150);

        //creates winnings
        g.drawString("Winnings = " + winnings, 150, 200);

        //creates balance
        g.drawString("Balance = " + balance, 150, 250);

        //creates bet ammount
        g.drawString("Bet Amount (spin when set)", 125, 365);

        //create message area
        g.setColor(red);
        g.fillRect(125, 300, 150, 25);
        g.setColor(white);
        g.drawString(message, 130, 315);
    }

    public void bet(int bet) {
        if ( bet <= balance && access == true ) {
            this.bet = bet;
            balance -= bet;
            message = "Bet Amount = " + bet;
            access = false;
        } else {
            message = "Bet Already Set/Invalid Bet";
        }
    }

    public void play() {
        if ( bet > 0 ) {
            num1 = (int)(Math.random()*9+1);
            num2 = (int)(Math.random()*9+1);
            num3 = (int)(Math.random()*9+1);

            playSound3();
            if ( num1 == 7 && num2 == 7 && num3 == 7 ) {
                winnings += 100 * bet;
                balance += 100 * bet;
                message = "JACKPOT! 100X";
                playSound1();
            } else if ( num1 == num2 && num2 == num3 ) {
                winnings += 5 * bet;
                balance += 5 * bet;
                message = "YOU WIN! 5X";
                playSound1();
            } else if ( num1 == num2 || num1 == num3 || num2 == num3 ) {
                winnings += 2 * bet;
                balance += 2 * bet;
                message = "YOU WIN! 2X";
                playSound1();
            } else {
                message = "You Win Nothing";
                playSound2();
            }
            //resetting variables
            access = true;
            bet = 0;
        } else {
            message = "Select a Bet Amount";
        }
    }

    public void playSound1() {
        try {
            URL url = this.getClass().getClassLoader().getResource("punch.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public void playSound2() {
        try {
            URL url = this.getClass().getClassLoader().getResource("lose.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public void playSound3() {
        try {
            URL url = this.getClass().getClassLoader().getResource("spin.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}