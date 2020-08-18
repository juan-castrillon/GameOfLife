package GameOfLife;

import GameOfLife.UI.GUI;

public class GameController {
    private Universe model;
    private final GUI view;


    public GameController(int sizeOfUniverse) {
        this.model = new Universe(sizeOfUniverse);
        this.view = new GUI();
    }
    public void reset(int size) {
        this.model = new Universe(size);
        this.view.setSizeOfUniverse(size);
        this.view.reset();
    }
    public void delay() {
        try {
            Thread.sleep(this.speed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean[][] currentState() {
        return this.model.getState();
    }

    public void nextGen() {
        this.model.evolve();
    }
    public int alive() {return this.model.getAlive();}

    public boolean isPlaying(){
        return this.view.isPlaying();
    }
    public boolean isReset() {
        return  this.view.isReset();
    }
    public boolean isNewGame() {return this.view.isNewGame();}

    public int speed() {
        return this.view.getSpeed();
    }
    public int size(){return this.view.getSizeOfUniverse();}
    public int newSize() {return this.view.getNewSize();}

    public void updateShowNewGame(){
        this.view.showNewGame(this.view.isShowNewGame());
    }

    public void updateView(int gen, int alive, boolean[][] state) {
        this.view.update(gen, alive, state);
    }

}
