import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FormulasGraphics extends JPanel implements ActionListener {
//formula 1
    private JButton pythagoreanButton;
    private JTextField aSideInput;
    private JTextField bSideInput;
    private double cSide = 0.0;
//formula 2
    private JButton quadraticButton;
    private JTextField firstTermInput;
    private JTextField secondTermInput;
    private JTextField thirdTermInput;
    private double firstZero = 0.0;
    private double secondZero = 0.0;
//formula 3
    private JButton circumferenceButton;
    private JTextField radiusInput;
    private double circumference = 0.0;
//formula 4
    private JButton distanceButton;
    private JTextField x1Input;
    private JTextField y1Input;
    private JTextField x2Input;
    private JTextField y2Input;
    private double distance = 0.0;
//background
    private BufferedImage background;

    public FormulasGraphics() {
        setLayout(null);
//background
        try {
            background = ImageIO.read(new File("space.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//formula 1
        pythagoreanButton = new JButton("Pythagorean Theorem");
        pythagoreanButton.setBounds(25, 150, 200, 25);
        add(pythagoreanButton);
        pythagoreanButton.addActionListener(this);

        aSideInput = new JTextField();
        aSideInput.setBounds(25, 75, 200, 25);
        add(aSideInput);

        bSideInput = new JTextField();
        bSideInput.setBounds(225, 75, 200, 25);
        add(bSideInput);
//formula 2
        quadraticButton = new JButton("Quadratic Equation");
        quadraticButton.setBounds(25, 325, 200, 25);
        add(quadraticButton);
        quadraticButton.addActionListener(this);

        firstTermInput = new JTextField();
        firstTermInput.setBounds(25, 250, 200, 25);
        add(firstTermInput);

        secondTermInput = new JTextField();
        secondTermInput.setBounds(225, 250, 200, 25);
        add(secondTermInput);

        thirdTermInput = new JTextField();
        thirdTermInput.setBounds(425, 250, 200, 25);
        add(thirdTermInput);
//formula 3
        circumferenceButton = new JButton("Circumference of Circle");
        circumferenceButton.setBounds(25, 500, 200, 25);
        add(circumferenceButton);
        circumferenceButton.addActionListener(this);

        radiusInput = new JTextField();
        radiusInput.setBounds(25, 425, 200, 25);
        add(radiusInput);

        setFocusable(true);
//formula 4
        distanceButton = new JButton("Distance Formula");
        distanceButton.setBounds(25, 675, 200, 25);
        add(distanceButton);
        distanceButton.addActionListener(this);

        x1Input = new JTextField();
        x1Input.setBounds(25, 600, 200, 25);
        add(x1Input);

        y1Input = new JTextField();
        y1Input.setBounds(225, 600, 200, 25);
        add(y1Input);

        x2Input = new JTextField();
        x2Input.setBounds(425, 600, 200, 25);
        add(x2Input);

        y2Input = new JTextField();
        y2Input.setBounds(625, 600, 200, 25);
        add(y2Input);
    }

    public Dimension getPreferredSize() {
        return new Dimension(875, 725);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//set text color
        Color green = new Color(80, 209, 37);
        g.setColor(green);
//background
        g.drawImage(background, 0, 0, null);
//formula 1
        g.drawString("Pythagorean Theorem", 25, 25);
        g.drawString("Enter the length of side a", 25, 50);
        g.drawString("Enter the length of side b", 225, 50);
        g.drawString("The length of the hypotenuse is " + cSide, 25, 125);
//formula 2
        g.drawString("Quadratic Equation", 25, 200);
        g.drawString("Enter a", 25, 225);
        g.drawString("Enter b", 225, 225);
        g.drawString("Enter c", 425, 225);
        g.drawString("The zeroes of this equation are " + firstZero + " and " + secondZero, 25, 300);
//formula 3
        g.drawString("Circumference of a Circle", 25, 375);
        g.drawString("Enter the radius", 25, 400);
        g.drawString("The circumference is " + circumference, 25, 475);
//formula 4
        g.drawString("Distance Formula", 25, 550);
        g.drawString("Enter x1", 25, 575);
        g.drawString("Enter y1", 225, 575);
        g.drawString("Enter x2", 425, 575);
        g.drawString("Enter y2", 625, 575);
        g.drawString("The distance between the points is " + distance, 25, 650);
    }

    public void actionPerformed(ActionEvent e) {
//formula 1
        if ( e.getSource() == pythagoreanButton ) {
            String aSideText = aSideInput.getText();
            double aSide = Double.parseDouble(aSideText);
            String bSideText = bSideInput.getText();
            double bSide = Double.parseDouble(bSideText);
            cSide = Math.sqrt(Math.pow(aSide, 2) + Math.pow(bSide, 2));
        }
//formula 2
        if ( e.getSource() == quadraticButton ) {
            String firstTermText = firstTermInput.getText();
            double firstTerm = Double.parseDouble(firstTermText);
            String secondTermText = secondTermInput.getText();
            double secondTerm = Double.parseDouble(secondTermText);
            String thirdTermText = thirdTermInput.getText();
            double thirdTerm = Double.parseDouble(thirdTermText);
            firstZero = (-secondTerm + Math.sqrt(Math.pow(secondTerm, 2) - 4 * firstTerm * thirdTerm))/(2 * firstTerm);
            secondZero = (-secondTerm - Math.sqrt(Math.pow(secondTerm, 2) - 4 * firstTerm * thirdTerm))/(2 * firstTerm);
        }
//formula 3
        if ( e.getSource() == circumferenceButton ) {
            String radiusText = radiusInput.getText();
            double radius = Double.parseDouble(radiusText);
            circumference = 2 * Math.PI * radius;
        }
//formula 4
        if ( e.getSource() == distanceButton ) {
            String x1Text = x1Input.getText();
            double x1 = Double.parseDouble(x1Text);
            String y1Text = y1Input.getText();
            double y1 = Double.parseDouble(y1Text);
            String x2Text = x2Input.getText();
            double x2 = Double.parseDouble(x2Text);
            String y2Text = y2Input.getText();
            double y2 = Double.parseDouble(y2Text);
            distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        }
        repaint();
    }
}