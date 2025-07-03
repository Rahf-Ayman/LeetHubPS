class Solution {
    public int maxProfit(int[] prices, int fee) {
        int [][]dp = new int[prices.length][2];
        for(int i = 0 ;i < dp.length ;i++){
            Arrays.fill(dp[i], -1);
        }
        return go(0 , 1 , prices , fee ,dp);
    }
    public int go(int i , int canbuy , int[] prices ,int fee ,int [][]dp){
        if(i >= prices.length  ) return 0; //base case
        if(dp[i][canbuy] != -1) return dp[i][canbuy];
        if(canbuy == 1){
            int ch1 = -prices[i] + go(i + 1, 0 , prices ,fee ,dp); //buy
            int ch2 = go(i + 1, 1 , prices ,fee ,dp); //skip
            return dp[i][canbuy] = Math.max(ch1 ,ch2);
        }else{
            int ch1 = prices[i] + go(i + 1, 1 , prices ,fee ,dp) - fee; //sell
            int ch2 = go(i + 1, 0 , prices ,fee ,dp);//skip
            return dp[i][canbuy] = Math.max(ch1 ,ch2);
        }
    }
}