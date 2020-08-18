package GameOfLife;

public class GameController {
    private final Universe model;
    //private UniverseView view;


    public GameController(int sizeOfUniverse) {
        this.model = new Universe(sizeOfUniverse);
        //this.view = new UniverseView();
    }

    public boolean[][] currentState() {
        return this.model.getState();
    }

    public void nextGen() {
        this.model.evolve();
    }
    public int alive() {return this.model.getAlive();}
    /*
    public void updateView() {
        this.view.show(this.model.getState());
    }*/

}
