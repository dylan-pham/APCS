import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
 
 
public class Screen extends JPanel {
    private ArrayList<Automobile> carList;
 
    public Screen() {
        carList = new ArrayList<Automobile>();
        carList.add(new Automobile(Color.BLUE, 50, 50));
        carList.add(new SmallCar(Color.GREEN, 150, 50));
        carList.add(new SmallSportsCar(Color.RED, 250, 50));
    }
     
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         
        //draw background
        g.setColor(Color.WHITE);
        g.fillRect(0,0,800,600);
         
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).drawMe(g);
        }
    }
}