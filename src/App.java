package src;

import src.maze.Maze;

public class App {
    public static void main(String[] args){
        Maze maze = new Maze("maze.txt");
        for (int i = 0; i < maze.getMazeMatrix().length; i++) {
            for (int j = 0; j < maze.getMazeMatrix()[i].length; j++) {
                System.out.print(maze.getMazeMatrix()[i][j]);
            }
            System.out.println();
        }
    }
    
}
