class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int min = prices[0];
        int rem = 0;
        for (int i = 1; i < n; i++) {
            if(prices[i] < prices[i - 1]){
                min = prices[i];
                rem = dp[i - 1];
                dp[i] = dp[i - 1];
            }else{
                min = Math.min(min, prices[i]);
                dp[i] = Math.max(dp[i - 1], prices[i] - min + rem );
            }

        }

        return dp[n - 1];

    }
}