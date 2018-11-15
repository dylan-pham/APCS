import java.awt.Color;
import java.awt.Graphics;

public class Buildings {
    int x;
    int y;
    int row;
    int col;
    Color gray;
    Color white;

    public Buildings(int x, int y, int row, int col) {
        this.x = x;
        this.y = y;
        this.row = row;
        this.col = col;
        gray = new Color(112, 116, 122);
        white = new Color(239, 232, 232);
    }

    public void drawMe(Graphics g) {
        // 1st set
        for ( int r = 0; r < row; r++ ) {
            for ( int c = 0; c < col; c++) {
                g.setColor(gray);
                g.fillRect(x + c * 45, y + r * 65, 40, 60);

                g.setColor(white);
                g.fillRect(x + 5 + c * 45, y + 10 + r * 65, 10, 10);

                g.setColor(white);
                g.fillRect(x + 5 + c * 45, y + 25 + r * 65, 10, 10);

                g.setColor(white);
                g.fillRect(x + 5 + c * 45, y + 40 + r * 65, 10, 10);

                g.setColor(white);
                g.fillRect(x + 25 + c * 45, y + 10 + r * 65, 10, 10);

                g.setColor(white);
                g.fillRect(x + 25 + c * 45, y + 25 + r * 65, 10, 10);

                g.setColor(white);
                g.fillRect(x + 25 + c * 45, y + 40 + r * 65, 10, 10);
            }
        }

        //2nd set
        for ( int r = 0; r < row; r++ ) {
            for ( int c = 0; c < col; c++) {
                g.setColor(gray);
                g.fillRect(x + c * 45 + 275, y + r * 65 + 150, 40, 60);

                g.setColor(white);
                g.fillRect(x + 5 + c * 45 + 275, y + 10 + r * 65 + 150, 10, 10);

                g.setColor(white);
                g.fillRect(x + 5 + c * 45 + 275, y + 25 + r * 65 + 150, 10, 10);

                g.setColor(white);
                g.fillRect(x + 5 + c * 45 + 275, y + 40 + r * 65 + 150, 10, 10);

                g.setColor(white);
                g.fillRect(x + 25 + c * 45 + 275, y + 10 + r * 65 + 150, 10, 10);

                g.setColor(white);
                g.fillRect(x + 25 + c * 45 + 275, y + 25 + r * 65 + 150, 10, 10);

                g.setColor(white);
                g.fillRect(x + 25 + c * 45 + 275, y + 40 + r * 65 + 150, 10, 10);
            }
        }
    }
}