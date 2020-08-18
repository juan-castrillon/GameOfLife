package GameOfLife.UI;

import GameOfLife.UI.CellGrid;
import GameOfLife.UI.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    private ControlPanel control;
    private CellGrid grid;
    private int sizeOfUniverse;

    public GUI() {
        super("Game of Life v1");
        this.sizeOfUniverse = 20;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(30 * sizeOfUniverse, 30 * sizeOfUniverse);
        setLocationRelativeTo(null);
        fill();
        setLayout(new BoxLayout(getContentPane(),BoxLayout.LINE_AXIS));
        setVisible(true);
        showNewGame(false);
    }

    private void fill() {
        control = new ControlPanel();
        add(control);
        control.setAlignmentX(Component.LEFT_ALIGNMENT);
        control.setAlignmentY(Component.TOP_ALIGNMENT);
        grid = new CellGrid(sizeOfUniverse);
        grid.setAlignmentX(Component.LEFT_ALIGNMENT);
        grid.setAlignmentY(Component.TOP_ALIGNMENT);
        add(grid);
    }

    public boolean isPlaying() {
        boolean playing = control.isPlaying();
        this.control.setPlaying(playing);
        return playing;
    }
    public boolean isReset() {
        return this.control.isReset();
    }
    public void reset() {
        this.control.reset();
        remove(grid);
        remove(control);
        fill();
    }
    public int getSpeed() {
        return this.control.getSpeed();
    }
    public int getNewSize() {
        return this.control.getNewSize();
    }
    public boolean isNewGame() {
        return this.control.isNewGame();
    }
    public boolean isShowNewGame() {
        return this.control.isShowNewGame();
    }
    public void showNewGame(boolean show) {
        this.control.showNewGame(show);
    }
    public void setSizeOfUniverse(int size) {
        this.sizeOfUniverse = size;
    }
    public int getSizeOfUniverse() {
        return sizeOfUniverse;
    }

    public void update(int gen, int alive, boolean[][] state) {
        this.control.setLabels(gen,alive);
        this.grid.setState(state);
        this.repaint();
    }
}
