import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class Screen extends JPanel implements ActionListener {
    private SlotMachine sm;
    private JButton spinButton;
    private JButton bet1Button;
    private JButton bet5Button;
    private JButton bet10Button;
    private int moneyY = 0;
    boolean animate = false;

    public Screen() {
        this.setLayout(null);

        spinButton = new JButton("Spin");
        spinButton.setBounds(150, 425, 100, 50);
        spinButton.addActionListener(this);
        this.add(spinButton);

        bet1Button = new JButton("1");
        bet1Button.setBounds(150, 375, 100, 15);
        bet1Button.addActionListener(this);
        this.add(bet1Button);

        bet5Button = new JButton("5");
        bet5Button.setBounds(150, 390, 100, 15);
        bet5Button.addActionListener(this);
        this.add(bet5Button);

        bet10Button = new JButton("10");
        bet10Button.setBounds(150, 405, 100, 15);
        bet10Button.addActionListener(this);
        this.add(bet10Button);

        sm = new SlotMachine(100);
        this.setFocusable(true);
    }

    public Dimension getPreferredSize() {
         return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        sm.drawMe(g);
    }

    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == spinButton ) {
            sm.play();
        } else if ( e.getSource() == bet1Button ) {
            sm.bet(1);
        } else if ( e.getSource() == bet5Button ) {
            sm.bet(5);
        } else if ( e.getSource() == bet10Button ) {
            sm.bet(10);
        }
        repaint();
    }
}