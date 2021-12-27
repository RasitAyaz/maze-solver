package src.algorithm;

import src.Tile;

public class UniformCostSearch extends Search{


    @Override 
    public void search(){
        
       
    }
    private Tile removeMinCostFrontier() {
        
        int indexOfMinElement = 0;
        double minCost = Double.MAX_VALUE;

        for(int i=0;i < frontier.size();i++) {
            if (frontier.get(i).getCost() < minCost) {
                indexOfMinElement = i;
                minCost = frontier.get(i).getCost();
            }
        }
        return frontier.remove(indexOfMinElement);
    }

    
}