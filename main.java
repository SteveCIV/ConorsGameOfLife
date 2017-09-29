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

        int[][] generationDrawReady = ArenaPopulation.arenaPopulationGeneration(arenaSize);
        ArenaCreation.generationDrawing(g, generationDrawReady, arenaSize, cellSize, borderWidth);

        for(int i = 0; i <= 100; i++) {
            int[][] generationOutput = ArenaPopulation.arenaRules(generationDrawReady);
            int[][] generationNew = ArenaPopulation.arenaRulesApplied(generationDrawReady, generationOutput);
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ArenaCreation.generationDrawing(g, generationNew, arenaSize, cellSize, borderWidth);
        }
    }
}