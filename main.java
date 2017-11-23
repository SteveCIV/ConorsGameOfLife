import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Graphics;
public class main extends JFrame /* implement ActionListener later*/ {
    public static final int ARENASIZE = ArenaCreation.arenaSizePrompt();
    public static final int CELLSIZE = 16;
    public static final int BORDERWITH = 2;
    int width = ARENASIZE * CELLSIZE;
    int height = ARENASIZE * CELLSIZE;
    // Frame, Panel, Button
    private JFrame f;
    private JPanel p;
    private JPanel p2;
    private JButton button1;

    public main() {
        gui();
        Graphics g = p.getGraphics();
        Graphics g2 = p2.getGraphics();
        ArenaCreation arena = new ArenaCreation(g2);
        //ArenaPopulation gen = new ArenaPopulation();
        int[][] generationZero = ArenaPopulation.arenaPopulationGeneration(ARENASIZE);
        int[][] generationCurrent = generationZero;

        while(true) {
            ArenaCreation.arenaGrayDraw(g2, width, height, CELLSIZE, BORDERWITH);
            arena.generationDrawing(g2, generationCurrent, ARENASIZE, CELLSIZE, BORDERWITH);
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
            p2.add(arena);
        }
    }
    public static void generationLoop() {

    }
    public void gui() {
        // sets up Frame
        f = new JFrame("Conor's Game of Life");
        f.setVisible(true);
        f.setSize(1000, 1000);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // sets up Panel
        p = new JPanel();
        p.setBackground(Color.GREEN);
        p2 = new JPanel();
        p2.setBackground(Color.BLACK);

        // adds button to panel
        p.add(GUI.resetArenaButton());
        p.add(GUI.closeButton());

        // adds Panels to Frame
        f.add(p, BorderLayout.EAST);
        f.add(p2);
        f.setVisible(true);
    }
    public static void main(String args[]) {
        new main().setVisible(true);
    }
}