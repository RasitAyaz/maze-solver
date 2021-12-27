package src;

public class App {
    public static void main(String[] args){
        Maze maze = new Maze("maze.txt");
        for (int i = 0; i < maze.getSize(); i++) {
            for (int j = 0; j < maze.getSize(); j++) {
                System.out.print(maze.get(i, j));
            }
            System.out.println();
        }
    }
    
}
