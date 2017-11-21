import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Graphics;
public class main extends JFrame /* implements ActionListener */ {

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
        ArenaPopulation gen = new ArenaPopulation();
        p2.add(arena);
        //int arenaSize = ArenaCreation.arenaSizePrompt();
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

        // creates button
        button1 = new JButton("Action Listener in future");

        // adds button to panel
        p.add(button1);

        // adds Panels to Frame
        f.add(p, BorderLayout.EAST);
        f.add(p2);
        f.setVisible(true);
    }
    public static void main(String args[]) {
        new main().setVisible(true);
    }
}

/**
int arenaSize = ArenaCreation.arenaSizePrompt();
// these might be changed to allow better resizing
int cellSize = 16;
int borderWidth = 2;
int height = arenaSize * cellSize;
int width = arenaSize * cellSize;
int dalay = 800;

// opens drawing panel
DrawingPanel arena = new DrawingPanel(width + 30, height);
arena.setBackground(Color.WHITE);
Graphics g = arena.getGraphics();
ArenaCreation.arenaGrayDraw(g, width, height, cellSize, borderWidth);
// sets up side bar
GUI.sideBar(g, width, height);
// first generation being created and put into loop of generations
int[][] generationZero = ArenaPopulation.arenaPopulationGeneration(arenaSize);
int[][] generationCurrent = generationZero;

// loop from generation to generation
while (true) {
    ArenaCreation.generationDrawing(g, generationCurrent, arenaSize, cellSize, borderWidth);
    // waits
    try {
        Thread.sleep(dalay);
    } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
    }
    // applies rules to create the next generation
    int[][] generationAdj = ArenaPopulation.arenaRules(generationCurrent);
    int[][] generationNew = ArenaPopulation.arenaRulesApplied(generationAdj, generationCurrent);
    // sets generation that will be printed as the new generation
    for (int w = 0; w < generationNew.length; w++) {
        for (int h = 0; h < generationNew[w].length; h++) {
            generationCurrent[w][h] = generationNew[w][h];
        }
    }
}
 **/