package src;

import java.util.Scanner;

import src.algorithm.BreadthFirstSearch;
import src.algorithm.DepthFirstSearch;
import src.algorithm.IterativeDeepeningSearch;
import src.algorithm.UniformCostSearch;
import src.algorithm.GreedyBestFirstSearch;
import src.algorithm.AStarSearch;
import src.algorithm.SearchAlgorithm;

public class App {
    public static void main(String[] args) {
        System.out.print("Enter an input file for maze: ");
        Scanner scanner = new Scanner(System.in);
        String mazeFileName = "maze.txt";//scanner.nextLine();
        Maze maze = new Maze(mazeFileName);

        System.out.println();

        boolean run = true;
        while (run) {
            System.out.print("\n1. Depth First Search\n2. Breadth First Search\n3. Iterative Deepening Search\n" +
                    "4. Uniform Cost Search\n5. Greedy Best First Search\n6. A* Heuristic Search\n7. Exit\n\nYour Selection: ");
            Integer selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    applyDFS(maze);
                    break;
                case 2:
                    applyBFS(maze);
                    break;
                case 3:
                    applyIterativeDeepening(maze);
                    break;
                case 4:
                    applyUniformCostSearch(maze);
                    break;
                case 5:
                    applyGreedy(maze);
                    break;
                case 6:
                    applyAStar(maze);
                    break;
                case 7:
                    run = false;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }

    private static void applyDFS(Maze maze) {
        SearchAlgorithm search = new DepthFirstSearch(maze);
        search.search();
        search.printSolutions();
    }

    private static void applyBFS(Maze maze) {
        SearchAlgorithm search = new BreadthFirstSearch(maze);
        search.search();
        search.printSolutions();
    }

    private static void applyIterativeDeepening(Maze maze) {
        SearchAlgorithm search = new IterativeDeepeningSearch(maze);
        search.search();
        search.printSolutions();
    }

    private static void applyUniformCostSearch(Maze maze) {
        SearchAlgorithm search = new UniformCostSearch(maze);
        search.search();
        search.printSolutions();
    }

    private static void applyGreedy(Maze maze) {
        SearchAlgorithm search = new GreedyBestFirstSearch(maze);
        search.search();
        search.printSolutions();
    }

    private static void applyAStar(Maze maze) {
        SearchAlgorithm search = new AStarSearch(maze);
        search.search();
        search.printSolutions();
    }

}
