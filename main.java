import java.awt.*;
import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        int arenaSize = ArenaCreation.arenaSizePrompt();
        Scanner scan = new Scanner(System.in);
        System.out.print("How much red do you want in the arena? (pick a number between 0 and 255) ");
        int red1 = scan.nextInt();
        System.out.print("How much green do you want in the arena? (pick a number between 0 and 255) ");
        int green1 = scan.nextInt();
        System.out.print("How much blue do you want in the arena? (pick a number between 0 and 255) ");
        int blue1 = scan.nextInt();
        System.out.print("How much red do you want in the full squares? (pick a number between 0 and 255) ");
        int red2 = scan.nextInt();
        System.out.print("How much green do you want in the full squares? (pick a number between 0 and 255) ");
        int green2 = scan.nextInt();
        System.out.print("How much blue do you want in the full squares? (pick a number between 0 and 255) ");
        int blue2 = scan.nextInt();
        System.out.print("How much red do you want in the empty squares? (pick a number between 0 and 255) ");
        int red3 = scan.nextInt();
        System.out.print("How much green do you want in the empty squares? (pick a number between 0 and 255) ");
        int green3 = scan.nextInt();
        System.out.print("How much blue do you want in the empty squares? (pick a number between 0 and 255) ");
        int blue3 = scan.nextInt();
        int cellSize = 16;
        int borderWidth = 2;
        int height = arenaSize * cellSize;
        int width = arenaSize * cellSize;
        DrawingPanel arena = new DrawingPanel(width, height);
        arena.setBackground(Color.WHITE);
        Graphics g = arena.getGraphics();
        ArenaCreation.arenaGrayDraw(g, width, height, cellSize, borderWidth, red1, green1, blue1);

        int[][] generationZero = ArenaPopulation.arenaPopulationGeneration(arenaSize);
        int[][] generationCurrent = generationZero;

        while(true) {
            ArenaCreation.generationDrawing(g, generationCurrent, arenaSize, cellSize, borderWidth, red2, green2, blue2, red3, green3, blue3);
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            int[][] generationAdj = ArenaPopulation.arenaRules(generationCurrent);
            int[][] generationNew = ArenaPopulation.arenaRulesApplied(generationAdj, generationCurrent);
            for(int w = 0; w < generationNew.length; w++) {
                for (int h = 0; h < generationNew[w].length; h++) {
                    generationCurrent[w][h] = generationNew[w][h];
                }
            }
        }
    }
}