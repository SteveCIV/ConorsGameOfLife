import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class ArenaCreation extends JPanel {
    //int arenaSize;
    //int cellSize = 16;
    //int borderWidth = 2;
    int height;
    int width;

    public ArenaCreation() {
        height = main.ARENASIZE * main.CELLSIZE;
        width = main.ARENASIZE * main.CELLSIZE;
        //arenaGrayDraw(g2, width, height, main.CELLSIZE, main.BORDERWITH);
    }

    public static int arenaSizePrompt() {
        // this will be removed and put in the side bar
        Scanner scan = new Scanner(System.in);
        System.out.println("What size of arena would you like?");
        System.out.println("Size under 51 recommended. Since I have no idea how to code");
        int arenaSize = scan.nextInt();
        return arenaSize;
    }
    public static void arenaGrayDraw(Graphics g, int width, int height, int cellSize, int borderWidth) {
        //super.paintComponent(g);
        g.setColor(Color.GRAY);
        for(int i = 0; i < width; i = i+cellSize) {
            //horizontal grey lines
            g.fillRect(0, 0 + (i+cellSize), width, borderWidth);
            g.fillRect(0, -2 + (i+cellSize), width, borderWidth);
            //vertical grey lines
            g.fillRect(0 + (i+cellSize), 0, borderWidth, height);
            g.fillRect(-2 + (i+cellSize), 0, borderWidth, height);
        }
        //ugly
        g.fillRect(0,0,width, borderWidth);
        g.fillRect(0,0,borderWidth, height);
    }
    public void generationDrawing(Graphics g, int[][] generationDrawReady, int arenaSize, int cellSize, int borderWidth) {
        for(int i = 0; i < arenaSize; i++) {
            for(int j = 0; j < arenaSize; j++) {
                // allows the painting of black
                if(generationDrawReady[i][j] == 1) {
                    g.setColor(Color.BLACK);
                    g.fillRect((cellSize * i) + borderWidth, (cellSize * j) + borderWidth, cellSize - (2 * borderWidth), cellSize - (2 * borderWidth));
                }
                // allows the painting of white
                if(generationDrawReady[i][j] == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect((cellSize * i) + borderWidth, (cellSize * j) + borderWidth, cellSize - (2 * borderWidth), cellSize - (2 * borderWidth));
                }
            }
        }
    }
}
