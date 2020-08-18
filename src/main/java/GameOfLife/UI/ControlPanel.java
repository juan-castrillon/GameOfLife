package GameOfLife.UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ControlPanel extends JPanel {
    private final InfoPanel labels;
    private final ButtonPanel buttons;
    private final SpeedPanel speed;
    private final NewGamePanel ng;

    public ControlPanel() {
        setBorder( new EmptyBorder(5,5,0,10));
        buttons = new ButtonPanel();
        buttons.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttons.setAlignmentY(Component.TOP_ALIGNMENT);
        add(buttons);
        labels = new InfoPanel();
        labels.setAlignmentX(Component.LEFT_ALIGNMENT);
        labels.setAlignmentY(Component.TOP_ALIGNMENT);
        add(labels);
        speed = new SpeedPanel();
        speed.setAlignmentX(Component.LEFT_ALIGNMENT);
        speed.setAlignmentY(Component.TOP_ALIGNMENT);
        add(speed);
        ng = new NewGamePanel();
        ng.setAlignmentX(Component.LEFT_ALIGNMENT);
        ng.setAlignmentY(Component.TOP_ALIGNMENT);
        add(ng);

        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        setMaximumSize(new Dimension(50,300));

    }

    public void setPlaying(boolean playing) {
        labels.setPlayingLabel(playing);
    }
    public void setLabels(int gen, int alive) {
        labels.setGen(gen);
        labels.setAlive(alive);
    }
    public boolean isPlaying() {
        return buttons.isPlaying();
    }
    public boolean isReset() {
        return  buttons.isReset();
    }
    public void reset() {
        buttons.setReset(false);
        ng.setNewGame(false);
    }
    public int getSpeed() {
        return speed.getSpeed();
    }
    public int getNewSize() {
        return ng.getNewSize();
    }
    public boolean isNewGame() {
        return ng.isNewGame();
    }
    public void showNewGame(boolean show) {
        ng.setVisible(show);
    }
    public boolean isShowNewGame() {
        return buttons.isShowNewGame();
    }

}
