import java.awt.*;
import java.util.Scanner;

public class ArenaCreation {
    public static int arenaSizePrompt() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What size of arena would you like?");
        System.out.println("Size under __ recommended.");
        int arenaSize = scan.nextInt();
        return arenaSize;
    }
    public static void arenaGrayDraw(Graphics g, int width, int height, int cellSize, int borderWidth) {
        g.setColor(Color.GRAY);
        for(int i = 0; i <= width; i = i+cellSize) {
            //horizontal
            g.fillRect(0, 0 + (i+cellSize), width, borderWidth);
            g.fillRect(0, -2 + (i+cellSize), width, borderWidth);
            //vertical
            g.fillRect(0 + (i+cellSize), 0, borderWidth, height);
            g.fillRect(-2 + (i+cellSize), 0, borderWidth, height);
        }
        //ugly
        g.fillRect(0,0,width, borderWidth);
        g.fillRect(0,0,borderWidth, height);
    }
    public static void generationDrawing(Graphics g, int[][] generationDrawReady, int arenaSize, int cellSize, int borderWidth) {
        for(int i = 0; i < arenaSize; i++) {
            for(int j = 0; j < arenaSize; j++) {
                if(generationDrawReady[i][j] == 1) {
                    g.setColor(Color.BLACK);
                    g.fillRect((cellSize * i) + borderWidth, (cellSize * j) + borderWidth, cellSize - (2 * borderWidth), cellSize - (2 * borderWidth));
                }
                if(generationDrawReady[i][j] == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect((cellSize * i) + borderWidth, (cellSize * j) + borderWidth, cellSize - (2 * borderWidth), cellSize - (2 * borderWidth));
                }
            }
        }
    }
}
