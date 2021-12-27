package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {
    private char[][] mazeMatrix;
    private Tile startTile;
    private List<Tile> goalTiles;

    public Maze(String fileName) {
        try {
            File myObj = new File(fileName);
            Scanner scanner = new Scanner(myObj);
            int i = 0;
            goalTiles = new ArrayList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (mazeMatrix == null) {
                    mazeMatrix = new char[line.length()][line.length()];
                }
                for (int j = 0; j < line.length(); j++) {
                    char ch = line.charAt(j);
                    mazeMatrix[i][j] = ch;

                    if (ch == 'S') {
                        startTile = new Tile(i, j, 0);
                    }

                    if (ch == 'G') {
                        goalTiles.add(new Tile(i, j, 0));
                    }
                }
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Maze file \"" + fileName + "\" could not be found.");
            System.exit(1);
        }
    }

    public char get(Tile tile) {
        return mazeMatrix[tile.getX()][tile.getY()];
    }

    public char get(int x, int y) {
        return mazeMatrix[x][y];
    }

    public int getSize() {
        return mazeMatrix.length;
    }

    public Tile getStartTile() {
        return startTile;
    }

    public List<Tile> getGoalTiles() {
        return goalTiles;
    }
}
