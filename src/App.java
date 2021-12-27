package src;

import java.util.Scanner;

import src.algorithm.AStarSearch;
import src.algorithm.BreadthFirstSearch;
import src.algorithm.SearchAlgorithm;

public class App {
    public static void main(String[] args){
        System.out.print("Enter an input file for maze: ");
        Scanner scanner = new Scanner(System.in);
        String mazeFileName = "maze.txt";// scanner.nextLine();
        scanner.close();
        Maze maze = new Maze(mazeFileName);

        System.out.println();
        
        for (int i = 0; i < maze.getSize(); i++) {
            for (int j = 0; j < maze.getSize(); j++) {
                System.out.print(maze.get(i, j) + " ");
            }
            System.out.println();
        }

        SearchAlgorithm search = new BreadthFirstSearch(maze);
        search.search();
        search.printSolutions();
    }
    
}
