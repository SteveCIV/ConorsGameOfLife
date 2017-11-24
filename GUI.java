import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    public GUI(JButton exit, JButton reset, boolean breaker) {
        closeButton(exit);
        resetArenaButton(reset, breaker);
        //resetArena();
    }

    public void closeButton(JButton b) {
        //JButton button = new JButton("Exit");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        //return b;
    }
    public void resetArenaButton(JButton b, boolean breaker) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                resetArena(breaker);
                ArenaPopulation.arenaPopulationGeneration(main.ARENASIZE);
            }
        });
    }
    public static boolean resetArena(boolean breaker) {
        breaker = false;
        return breaker;
    }
}