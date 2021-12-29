package src.algorithm;

import java.util.Collections;
import java.util.List;

import src.Maze;
import src.Tile;

public class DepthFirstSearch extends SearchAlgorithm {

    public DepthFirstSearch(Maze maze) {
        super(maze);
    }

    @Override
    public boolean search() {
        while (!frontier.isEmpty()) {
            Tile currentTile = frontier.remove(frontier.size() - 1);

            exploredTiles.add(currentTile);
            expandedCoordinates.add(currentTile.getRealCoordinates());

            if (maze.get(currentTile) == 'G') {
                lastTile = currentTile;
                findSolution();
                return true;
            }
            List<Tile> expandableTiles = getExpandableTiles(currentTile);
            Collections.reverse(expandableTiles);
            for (Tile tile : expandableTiles) {
                if (!frontier.contains(tile) && !exploredTiles.contains(tile)) {
                    frontier.add(tile);
                    if(frontier.size()>maxSizeFrontier){
                        maxSizeFrontier=frontier.size();
                    }
                }
            }
        }
        return false;
    }
}
