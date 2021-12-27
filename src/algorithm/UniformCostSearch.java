package src.algorithm;

import java.util.List;

import src.Tile;

public class UniformCostSearch extends SearchAlgorithm {

    private Tile currentTile;

    @Override
    public boolean search() {

        currentTile = removeMinCostFrontier();

        exploredTiles.add(currentTile);
        expandedCoordinates.add(currentTile.getRealCoordinates());

        if (maze.get(currentTile) == 'G') {

            lastTile = currentTile;
            findSolution();
            return true;
        }
        List<Tile> exploreResult = getExpandableTiles(currentTile);

        for (Tile tiles : exploreResult) {
            if (frontier.contains(tiles) && exploredTiles.contains(tiles)) {
                frontier.add(tiles);
            }
        }

        return false;
    }

    private Tile removeMinCostFrontier() {

        int indexOfMinElement = 0;
        double minCost = Double.MAX_VALUE;

        for (int i = 0; i < frontier.size(); i++) {
            if (frontier.get(i).getCost() < minCost) {
                indexOfMinElement = i;
                minCost = frontier.get(i).getCost();
            }
        }
        return frontier.remove(indexOfMinElement);
    }
}