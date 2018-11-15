import java.awt.Color;
import java.awt.Graphics;

public class Trees {
    int x;
    int y;
    int row;
    int col;
    Color brown;
    Color green;

    public Trees(int x, int y, int row, int col) {
        this.x = x;
        this.y = y;
        this.row = row;
        this.col = col;
        brown = new Color(222, 184, 135);
        green = new Color(72, 244, 66);
    }

    public void drawMe(Graphics g) {
        // 1st set
        for ( int r = 0; r < row; r++ ) {
            for ( int c = 0; c < col; c++) {
                g.setColor(brown);
                g.fillRect(x + c * 30, y + r * 50, 10, 40);

                g.setColor(green);
                g.fillOval(x - 5 + c * 30, y - 5 + r * 50, 20, 20);
            }
        }

        // 2nd set
        for ( int r = 0; r < row; r++ ) {
            for ( int c = 0; c < col; c++) {
                g.setColor(brown);
                g.fillRect(x + c * 30 + 550, y + r * 50 - 200, 10, 40);

                g.setColor(green);
                g.fillOval(x - 5 + c * 30 + 550, y - 5 + r * 50 - 200, 20, 20);
            }
        }
    }
}