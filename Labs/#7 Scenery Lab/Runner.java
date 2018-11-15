import javax.swing.JFrame;
import java.util.Scanner;
import javax.swing.JFrame;

public class Runner {
    public  static void main(String[] args) {
        JFrame fr = new JFrame("Scenery");
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter 1 for day or 2 for night: ");
        int background = kb.nextInt();
        System.out.print("Enter 1 for no clouds or 2 for clouds: ");
        int cloud = kb.nextInt();
        Scenery sc = new Scenery(background, cloud);

        fr.add(sc);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
}