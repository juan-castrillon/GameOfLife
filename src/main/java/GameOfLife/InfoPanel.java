package GameOfLife;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InfoPanel extends JPanel {
    private final JLabel genLabel;
    private final JLabel aliveLabel;
    private final JLabel playingLabel;
    private final String genHeader = "Generation #";
    private final String aliveHeader = "Alive: ";
    public InfoPanel() {

        setBorder(new EmptyBorder(0,10,0,0));

        playingLabel = new JLabel();
        playingLabel.setText("Playing!");
        playingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        playingLabel.setFont(playingLabel.getFont().deriveFont(16f));
        add(playingLabel);

        genLabel = new JLabel();
        genLabel.setName("GenerationLabel");
        genLabel.setText(genHeader + 0);
        genLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        genLabel.setFont(genLabel.getFont().deriveFont(16f));
        add(genLabel);

        aliveLabel = new JLabel();
        aliveLabel.setName("AliveLabel");
        aliveLabel.setText(aliveHeader + 0);
        aliveLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        aliveLabel.setFont(genLabel.getFont().deriveFont(16f));
        add(aliveLabel);

        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    }
    public void setPlayingLabel(boolean playing) {
        playingLabel.setText(playing ? "Playing!" : "Paused");
    }
    public void setGen(int gen) {
        genLabel.setText(genHeader + gen);
    }
    public void setAlive(int alive) {
        aliveLabel.setText(aliveHeader + alive);
    }
}
