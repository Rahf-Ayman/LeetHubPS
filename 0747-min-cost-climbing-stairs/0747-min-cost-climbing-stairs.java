class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(go(0 , cost) ,go(1 , cost));
    }

    public  int go(int i , int[] cost){
        if(i >= cost.length) return 0;
        int ch1 = go(i + 1 , cost) + cost[i];
        int ch2 = go(i + 2 , cost) + cost[i];
        return Math.min(ch1 ,ch2);
    }
}