package GameOfLife;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class NewGamePanel extends JPanel {
    private JTextField newSize;
    private boolean newGame;

    public NewGamePanel() {
        newGame = false;
        setBorder(new LineBorder(Color.BLACK));
        setBackground(Color.LIGHT_GRAY);
        setVisible(false);
        JLabel title = new JLabel("NEW GAME");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(new EmptyBorder(5,0,0,0));
        JLabel instr = new JLabel("New size of the universe:");
        instr.setAlignmentY(Component.TOP_ALIGNMENT);
        panel.add(instr);
        newSize = new JTextField(4);
        newSize.setAlignmentY(Component.TOP_ALIGNMENT);
        panel.add(newSize);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,5,1));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setMaximumSize(new Dimension(300,30));
        add(panel);

        JButton go = new JButton("GO!");
        go.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(go);

        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        go.addActionListener(e -> newGame = true);
    }
    public int getNewSize() {
        return Integer.parseInt(newSize.getText());
    }

    public boolean isNewGame() {
        return newGame;
    }
    public void setNewGame(boolean newGame) {
        this.newGame = newGame;
    }
    public void visible(boolean visible) {
        setVisible(visible);
    }
}
