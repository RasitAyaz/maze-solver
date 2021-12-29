package src.algorithm;

import java.util.List;

import src.Maze;
import src.Tile;

public class IterativeDeepeningSearch extends SearchAlgorithm {
    public IterativeDeepeningSearch(Maze maze) {
        super(maze);
    }

    @Override
    public boolean search() {
        Tile firstTile = frontier.remove(frontier.size() - 1);
        int maxDepth = maze.getSize() * maze.getSize();

        for (int depth = 0; depth < maxDepth; depth++) {
            int currentDepth = 0;
            frontier.clear();
            frontier.add(maze.getStartTile());
            
        }

        return false;
    }

    Tile applyDepthLimitedSearch(Tile tile, int limit) {
        expandedCoordinates.add(tile.getRealCoordinates());

        if (maze.get(tile) == 'G') {
            return tile;
        } else if (limit == 0) {
            return null;
        } else {
            List<Tile> expandableTiles = getExpandableTiles(tile);
            for (Tile childTile : expandableTiles) {
                if (childTile.equals(tile.getParent())) {
                    continue;
                }
                Tile resultTile = applyDepthLimitedSearch(childTile, limit - 1);
                if (resultTile != null) {
                    return resultTile;
                }
            }
            return null;
        }
    }
}
