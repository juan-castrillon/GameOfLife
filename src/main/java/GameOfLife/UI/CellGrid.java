package GameOfLife.UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CellGrid extends JPanel {

    private final JPanel[][] cells;
    private boolean[][] state;

    public CellGrid(int size) {
        setBorder(new EmptyBorder(1,1,1,1));
        setLayout(new GridLayout(size,size, 1,1));
        state = new boolean[size][size];
        cells = new JPanel[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new JPanel();
                cells[i][j].setOpaque(true);
                add(cells[i][j]);
            }
        }
    }

    public void setState(boolean[][] state) {
        this.state = state;
    }

    private void paintState() {
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state.length; j++) {
                this.cells[i][j].setBackground(state[i][j] ? Color.BLACK : Color.LIGHT_GRAY);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintState();
    }
}
