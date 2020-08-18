# GameOfLife
Java  + Swing Implementation of The Game of Life, the cellular automaton devised by John Conway. 

## What is it?

![Game of Life](https://conwaylife.com/w/images/0/0d/Conwaylife.gif)

The game of life (or just Life) is a zero player game, that simulates an Universe, in which based on predefined rules, cells either are dead or alive. Its a great example of cellular automata and has been used and played since the 70's. The study of the patterns that form over time, and in general more information about the game can be found in [the Game of Life Wiki](https://conwaylife.com/wiki/Conway%27s_Game_of_Life).

The rules of behavior in this "Universe" are quite simple :
- Any live cell with fewer than two live neighbours dies, as if by underpopulation.
- Any live cell with two or three live neighbours lives on to the next generation.
- Any live cell with more than three live neighbours dies, as if by overpopulation.
- Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

## How do I play?

### Running the Game
The game is built as a gradle application, therefore making running it very simple.

It doesn't matter if Gradle is installed in your system or not, the project comes with a gradle wrapper, this means, to run the application just navigate to the folder where you can see the build.gradle file and then type the following command in your terminal:
```
./gradlew run
```
After a short while, the UI window should be visible.

### Controls and Buttons

The Game Window can be seen here :

![GUI](https://user-images.githubusercontent.com/64461123/90519246-13027d00-e168-11ea-89cc-3d6e29f45a01.png)

#### Default Start
By default, the game starts with a universe of size 20 (20x20 cells) with alive and dead cells in the first generation, randomly assigned.

#### Play/Pause Button
Pretty self explanatory, pauses and continues the current simulation or universe.

#### Reset Button
Starts the game from scratch. This means completely new universe and default size again (20x20)

#### New Game Button
As soon as it is pressed, a little dialog appears so the player can input a new size of the universe and start the game from generation #1

![image](https://user-images.githubusercontent.com/64461123/90517608-eb121a00-e165-11ea-9726-5199dfad74af.png)

As soon as you input a number, click on the **GO!** button, and the game will start again.

#### Evolution Speed Slider

The slider modifies the speed of evolution of the cells in the current universe. The minimum speed is One New generation every 100 milliseconds and the maximum is every 1 second

