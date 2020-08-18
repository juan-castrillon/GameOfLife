package GameOfLife;

public class App {
    public static void main(String[] args) {
        final int initSize = 20;
        GameController controller = new GameController(initSize);
        boolean playing;
        int cont = 1;
        while(true) {
            playing = controller.isPlaying();
            while (!playing) {
                playing = controller.isPlaying();
            }
            controller.nextGen();
            controller.updateView(cont, controller.alive(), controller.currentState());
            controller.delay();
            cont++;
            if (controller.isReset() || controller.isNewGame()){
                int size = controller.isNewGame() ? controller.newSize() : controller.size();
                controller.reset(size);
                cont = 1;
            }
            controller.updateShowNewGame();
        }
    }
}
