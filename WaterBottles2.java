//3100
//enjoying this easy shit

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = 0;
        int drunk = 0;
        while(numBottles!=0){
            empty+=numBottles;
            drunk+=numBottles;
            numBottles=0;
            
            if(empty<numExchange){
                return drunk;
            }
            else {
                numBottles = 1;
                empty -= numBottles*numExchange;
                numExchange++;
            }
        }
        return 0;
    }
}
