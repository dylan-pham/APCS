import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class Screen extends JPanel {
    private ArrayList<Automobile> carList;
    private int time;
    Color trafficLightColor;
 
    public Screen() {
        setLayout(null);
        carList = new ArrayList<Automobile>();
        carList.add(new SportsCar(Color.RED, (int)(Math.random() * 1200), 130));
        carList.add(new SportsCar(Color.RED, (int)(Math.random() * 1200), 130));
        carList.add(new SportsCar(Color.RED, (int)(Math.random() * 1200), 440));
        carList.add(new SportsCar(Color.RED, (int)(Math.random() * 1200), 440));
        carList.add(new SportsCar(Color.RED, (int)(Math.random() * 1200), 130));

        carList.add(new Sedan(Color.ORANGE, (int)(Math.random() * 1200), 130));
        carList.add(new Sedan(Color.ORANGE, (int)(Math.random() * 1200), 130));
        carList.add(new Sedan(Color.ORANGE, (int)(Math.random() * 1200), 440));
        carList.add(new Sedan(Color.ORANGE, (int)(Math.random() * 1200), 440));
        carList.add(new Sedan(Color.ORANGE, (int)(Math.random() * 1200), 130));

        carList.add(new SUV(Color.GREEN, (int)(Math.random() * 1200), 130));
        carList.add(new SUV(Color.GREEN, (int)(Math.random() * 1200), 130));
        carList.add(new SUV(Color.GREEN, (int)(Math.random() * 1200), 440));
        carList.add(new SUV(Color.GREEN, (int)(Math.random() * 1200), 440));
        carList.add(new SUV(Color.GREEN, (int)(Math.random() * 1200), 440));

        carList.add(new Truck(Color.PINK, (int)(Math.random() * 1200), 130));
        carList.add(new Truck(Color.PINK, (int)(Math.random() * 1200), 130));
        carList.add(new Truck(Color.PINK, (int)(Math.random() * 1200), 440));
        carList.add(new Truck(Color.PINK, (int)(Math.random() * 1200), 440));
        carList.add(new Truck(Color.PINK, (int)(Math.random() * 1200), 440));

        time = 200;
        trafficLightColor = Color.GREEN;
    }
     
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         
        // background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);

        // roads
        g.setColor(Color.GRAY);
        g.fillRect(0, 120, 800, 50);     
        g.fillRect(0, 430, 800, 50);

        // traffic light
        g.setColor(trafficLightColor);
        g.fillOval(400, 50, 20, 20);
        g.setColor(Color.BLACK);
        g.fillRect(405, 70, 10, 50);

        g.setColor(trafficLightColor);
        g.fillOval(400, 360, 20, 20);
        g.setColor(Color.BLACK);
        g.fillRect(405, 380, 10, 50);

        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).drawMe(g);
            repaint();
        }

        controlTrafficLight(g);
    }

    public void animate() {
        while (true) {
            for (int i = 0; i < carList.size(); i++) {
                if ((carList.get(i).getX() <= 400 && carList.get(i).getX() >= 390) && trafficLightColor == Color.RED) {
                    ;
                } else {
                    carList.get(i).move();
                }
            }

            time--;

            try {
                Thread.sleep(30);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            repaint();
        }
    }

    public void controlTrafficLight(Graphics g) {
        if (time == 0) {
            time = 200;
            if (trafficLightColor == Color.GREEN) {
                trafficLightColor = Color.RED;
            } else {
                trafficLightColor = Color.GREEN;
            }
        }
    }
}