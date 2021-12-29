package src.algorithm;

import java.util.List;

import src.Maze;
import src.Tile;

public class AStarSearch extends SearchAlgorithm {

    public AStarSearch(Maze maze) {
        super(maze);
    }

    private Tile currentTile;

    @Override
    public boolean search() {
        while (!frontier.isEmpty()) {
            currentTile = removeMinCostFrontier();

            exploredTiles.add(currentTile);
            expandedCoordinates.add(currentTile.getRealCoordinates());
            if(exploredTiles.size()>maxSizeExploredSet){
                maxSizeExploredSet=frontier.size();
            }

            if (maze.get(currentTile) == 'G') {

                lastTile = currentTile;
                findSolution();
                return true;
            }
            List<Tile> expandableTiles = getExpandableTiles(currentTile);

            for (Tile tiles : expandableTiles) {
                if (!frontier.contains(tiles) && !exploredTiles.contains(tiles)) {
                    frontier.add(tiles);
                    if(frontier.size()>maxSizeFrontier){
                        maxSizeFrontier=frontier.size();
                    }
                }
            }
        }

        return false;
    }

    private Tile removeMinCostFrontier() {

        int indexOfMinElement = 0;
        double minCost = Double.MAX_VALUE;

        for (int i = 0; i < frontier.size(); i++) {
            if (frontier.get(i).getAStarHeuristic() < minCost) {
                indexOfMinElement = i;
                minCost = frontier.get(i).getAStarHeuristic();
            }
        }
        return frontier.remove(indexOfMinElement);
    }
}
