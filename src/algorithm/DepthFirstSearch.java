package src.algorithm;

import java.util.Collections;
import java.util.List;

import src.Tile;

public class DepthFirstSearch extends Search {

    @Override
    public void search() {
        while (!frontier.isEmpty()) {
            Tile currentTile = frontier.remove(frontier.size() - 1);

            exploredTiles.add(currentTile);
            expandedCoordinates.add(currentTile.getRealCoordinates());

            if (maze.get(currentTile) == 'G') {
                lastTile = currentTile;
                findSolution();
                break;
            }
            List<Tile> expandableTiles = getExpandableTiles(currentTile);
            Collections.reverse(expandableTiles);
            for (Tile tile : expandableTiles) {
                if (!frontier.contains(tile) && !exploredTiles.contains(tile)) {
                    frontier.add(tile);
                }
            }

        }
    }
}
