//1518
//ik it was way too easy but still happy beat 100% for time🥳
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drunk =0;
        int empty =0;
        while(numBottles!=0){

            empty+=numBottles;
            drunk+=numBottles;
            numBottles=0;

            if(empty<numExchange){
                return drunk;
            }
            else {
               numBottles = empty/numExchange;
               empty = empty%numExchange;
            }
        }
        return 0;
    }
}
