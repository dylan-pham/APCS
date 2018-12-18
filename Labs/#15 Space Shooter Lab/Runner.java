import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Shooter");
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        Screen screen = new Screen();
         
        frame.add(screen);
        frame.pack();
        frame.setVisible(true);
        
        screen.animate();
    }
}