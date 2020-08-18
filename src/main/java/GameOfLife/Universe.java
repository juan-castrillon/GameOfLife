package GameOfLife;

import java.util.Random;

public class Universe {
    private boolean[][] state;

    public Universe(int size) {
        Random random = new Random();
        this.state = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.state[i][j] = random.nextBoolean();
            }
        }
    }

    public boolean[][] getState() {
        return this.state;
    }
    public int getAlive() {
        int alive = 0;
        for (boolean[] row : this.state) {
            for (boolean element : row) {
                if (element) {
                    alive++;
                }
            }
        }
        return alive;
    }

    public void evolve() {
        int size = this.state.length;
        boolean[][] newState = new boolean[size][size];
        int topIndex;
        int downIndex;
        int leftIndex;
        int rightIndex;
        int alive = 0;
        boolean[] neighbors = new boolean[8];
        boolean current;
        for (int i = 0; i < size; i++) {
            topIndex = i - 1 < 0 ? size - 1 : i - 1;
            downIndex = i + 1 == size ? 0 : i + 1;
            for (int j = 0; j < size; j++) {
                leftIndex = j - 1 < 0 ? size -1 : j - 1;
                rightIndex = j + 1 == size ? 0 : j + 1;
                current = this.state[i][j];

                neighbors[0] = this.state[topIndex][j];
                neighbors[1] = this.state[downIndex][j];
                neighbors[2] = this.state[i][rightIndex];
                neighbors[3] = this.state[i][leftIndex];
                neighbors[4] = this.state[topIndex][rightIndex];
                neighbors[5] = this.state[topIndex][leftIndex];
                neighbors[6] = this.state[downIndex][rightIndex];
                neighbors[7] = this.state[downIndex][leftIndex];

                for (boolean n : neighbors) {
                    if (n) {
                        alive++;
                    }
                }

                if (current && (alive < 2 || alive > 3)) {
                    current = false;
                } else if (!current && alive == 3) {
                    current = true;
                }
                newState[i][j] = current;
                alive = 0;

            }
        }
        this.state = newState;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (boolean[] row : this.state) {
            for (boolean element : row) {
                result.append(element ? "O" : " ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
