import java.awt.*;

public class main {
    public static void main(String args[]) {
        int arenaSize = ArenaCreation.arenaSizePrompt();

        int cellSize = 16;
        int borderWidth = 2;
        int height = arenaSize * cellSize;
        int width = arenaSize * cellSize;
        DrawingPanel arena = new DrawingPanel(width, height);
        arena.setBackground(Color.WHITE);
        Graphics g = arena.getGraphics();
        ArenaCreation.arenaGrayDraw(g, width, height, cellSize, borderWidth);

        int[][] generationZero = ArenaPopulation.arenaPopulationGeneration(arenaSize);
        int[][] generationCurrent = generationZero;

        while(true) {
            ArenaCreation.generationDrawing(g, generationCurrent, arenaSize, cellSize, borderWidth);
            try {
                Thread.sleep(1);
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