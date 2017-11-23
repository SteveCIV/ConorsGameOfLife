import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void sideBar(Graphics g, int arenaWidth, int arenaHeight) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(arenaWidth, 0, 30 , arenaHeight);
    }
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

            }
        });
        return button;
    }
}