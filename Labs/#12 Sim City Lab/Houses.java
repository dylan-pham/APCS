import java.awt.Color;
import java.awt.Graphics;

public class Houses {
    int x;
    int y;
    int row;
    int col;
    Color brown;
    Color white;

    public Houses(int x, int y, int row, int col) {
        this.x = x;
        this.y = y;
        this.row = row;
        this.col = col;
        brown = new Color(222, 184, 135);
        white = new Color(255, 255, 255);
    }

    public void drawMe(Graphics g) {
        //1st set
        for ( int r = 0; r < row; r++ ) {
            for ( int c = 0; c < col; c++ ) {
                g.setColor(brown);
                g.fillRect(x + c * 35, y + r * 25, 30, 20);

                g.setColor(white);
                g.fillRect(x + c * 35 + 2, y + r *25 + 4, 10, 10);
            }
        }

        //2nd set
        for ( int r = 0; r < row; r++ ) {
            for ( int c = 0; c < col; c++ ) {
                g.setColor(brown);
                g.fillRect(x + c * 35 - 275, y + r * 25 - 200, 30, 20);

                g.setColor(white);
                g.fillRect(x + c * 35 + 2 - 275, y + r *25 + 4 - 200, 10, 10);
            }
        }
    }
}