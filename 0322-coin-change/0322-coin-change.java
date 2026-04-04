class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp [] = new int [amount + 1];
        Arrays.fill(dp , -1);
        int sol = dfsCoin(coins,amount,dp);
        return sol == Integer.MAX_VALUE ? -1 : sol;
    }

    public int dfsCoin(int [] coins,int amount , int []dp){
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE; // unvalid solution
        if(dp[amount] != -1) return dp[amount];
        int min = Integer.MAX_VALUE;
        for(int i : coins){
            int res = dfsCoin(coins,amount - i,dp);
            if(res != Integer.MAX_VALUE)
                min = Math.min(min , 1 + res);
        }
        return dp[amount] = min;
    }
}