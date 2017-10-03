import java.awt.*;

public class main {
    public static void main(String args[]) {
        int arenaSize = ArenaCreation.arenaSizePrompt();

        int cellSize = 16;
        int borderWidth = 2;
        int height = arenaSize * cellSize;
        int width = arenaSize * cellSize;
        DrawingPanel arena = new DrawingPanel(height, width);
        arena.setBackground(Color.WHITE);
        Graphics g = arena.getGraphics();
        ArenaCreation.arenaGrayDraw(g, width, height, cellSize, borderWidth);

        int[][] generationZero = ArenaPopulation.arenaPopulationGeneration(arenaSize);
        // creates random generation 0

        int[][] generationCurrent = generationZero;

        for(int i = 0; i <= 100; i++) {
            ArenaCreation.generationDrawing(g, generationCurrent, arenaSize, cellSize, borderWidth);
            // draws generation current

            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            // wait

            int[][] generationAdj = ArenaPopulation.arenaRules(generationCurrent);
            // adjacent rules for generation current

            int[][] generationNew = ArenaPopulation.arenaRulesApplied(generationAdj, generationCurrent);
            // use generation current and its adjacent to create generation new

            generationCurrent = generationNew;
        }
    }
}