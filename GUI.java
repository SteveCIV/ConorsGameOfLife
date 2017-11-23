import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static JButton closeButton() {
        JButton button = new JButton("Exit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        return button;
    }
    public static JButton resetArenaButton() {
        JButton button = new JButton("Reset Arena");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                boolean breakMeDaddy = true;
                breakLoop();
                ArenaPopulation.arenaPopulationGeneration(main.ARENASIZE);
            }
        });
        return button;
    }
    public static boolean breakLoop() {
        resetArenaButton();
        boolean breaker = false;
        return breaker;
    }
}