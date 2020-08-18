package GameOfLife;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class ButtonPanel extends JPanel {
    private boolean playing;
    private boolean reset;
    private boolean showNewGame;
    public ButtonPanel() {
        playing = true;
        reset = false;
        showNewGame = false;
        setBorder(new EmptyBorder(0,0,20,5));
        JToggleButton playButton = new JToggleButton();
        playButton.setName("PlayToggleButton");
        playButton.setText("PAUSE");
        add(playButton);

        add(Box.createRigidArea(new Dimension(5,0)));

        JButton resetButton = new JButton();
        resetButton.setName("ResetButton");
        resetButton.setText("RESET");
        add(resetButton);

        add(Box.createRigidArea(new Dimension(5,0)));

        JButton newGameButton = new JButton();
        newGameButton.setText("NEW GAME");
        add(newGameButton);

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        playButton.addActionListener(e -> {
            playButton.setText(!playing ? "PAUSE" : "PLAY");
            playing = !playing;
        });

        resetButton.addActionListener(e -> reset = true);
        newGameButton.addActionListener(e -> showNewGame = !showNewGame);
    }

    public boolean isPlaying() {
        return playing;
    }

    public boolean isReset() {
        return reset;
    }
    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public boolean isShowNewGame() {
        return showNewGame;
    }
}
