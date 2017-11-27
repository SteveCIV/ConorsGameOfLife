import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Arrays;

public class main extends JFrame {
    public static final int ARENASIZE = ArenaCreation.arenaSizePrompt();
    public static final int CELLSIZE = 16;
    public static final int BORDERWITH = 2;
    // width and height should not be here
    int width = ARENASIZE * CELLSIZE;
    int height = ARENASIZE * CELLSIZE;
    boolean loopBreaker = true;
    Color BLUE_GRAY = new Color(40, 80, 160);
    // Frame, Panel, Graphics, Button
    private JFrame f;
    private JPanel p;
    private JPanel p2;
    public JButton exitB = new JButton("Exit");
    public JButton resetB = new JButton("Reset Arena");

    public main() {
        gui();
        Graphics g = p.getGraphics();
        Graphics g2 = p2.getGraphics();

        //ArenaCreation arena = new ArenaCreation(g2);
        ArenaCreation arena = createArena();
        startLoop(arena, g2);
        //generationLoop(g2, p2, width, height, generationCurrent, arena);
    }
    public ArenaCreation createArena() {
        ArenaCreation newArena = new ArenaCreation();
        return newArena;
    }
    public void startLoop(ArenaCreation arena, Graphics g2) {
        int[][] generationZero = ArenaPopulation.arenaPopulationGeneration(ARENASIZE);
        int[][] generationCurrent = generationZero;
        loopBreaker = true;
        generationLoop(g2, p2, width, height, generationCurrent, arena);
    }
    public void generationLoop(Graphics g2, JPanel p2, int width, int height, int[][] generationCurrent, ArenaCreation arena) {
        while(loopBreaker) {
            ArenaCreation.arenaGrayDraw(g2, width, height, CELLSIZE, BORDERWITH);
            arena.generationDrawing(g2, generationCurrent, ARENASIZE, CELLSIZE, BORDERWITH);
            try {
                Thread.sleep(300);
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
    public class buttons extends JButton {
        public buttons(JButton resetB, JButton exitB) {
            resetArenaButton(resetB);
            closeButton(exitB);
        }
        public void resetArenaButton(JButton b) {
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    loopBreaker = false;
                    ArenaCreation arena = createArena();
                    Graphics g2 = p2.getGraphics();
                    startLoop(arena, g2);
                }
            });
        }
        public void closeButton(JButton b) {
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    System.exit(0);
                }
            });
        }
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
        p.setBackground(BLUE_GRAY);
        p2 = new JPanel();
        p2.setBackground(Color.BLACK);

        // adds button to panel
        buttons b = new buttons(resetB, exitB);
        p.add(exitB);
        p.add(resetB);

        // adds Panels to Frame
        f.add(p, BorderLayout.EAST);
        f.add(p2);
        f.setVisible(true);
    }
    public static void main(String args[]) {
        new main().setVisible(true);
    }
}