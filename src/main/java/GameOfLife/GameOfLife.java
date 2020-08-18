package GameOfLife;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {
    private ControlPanel control;
    private CellGrid grid;
    private int sizeOfUniverse;

    public GameOfLife() {
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

    public void updateGUI(int gen, int alive, boolean[][] state) {
        this.control.setLabels(gen,alive);
        this.grid.setState(state);
        this.repaint();
    }

    public static void main(String[] args) {
        final int initSize = 20;
        GameOfLife game = new GameOfLife();
        GameController controller = new GameController(initSize);
        boolean playing;
        boolean showingNewGame = false;
        int cont = 1;
        while(true) {
            playing = game.isPlaying();
            while (!playing) {
                playing = game.isPlaying();
            }
            controller.nextGen();
            game.updateGUI(cont, controller.alive(), controller.currentState());
            try {
                Thread.sleep(game.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cont++;
            if (game.isReset() || game.isNewGame()){
                int size = game.isNewGame() ? game.getNewSize() : initSize;
                controller = new GameController(size);
                game.setSizeOfUniverse(size);
                cont = 1;
                game.reset();
            }
            game.showNewGame(game.isShowNewGame());
        }
    }
}
