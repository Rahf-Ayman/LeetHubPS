class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int [days.length + 1];
        int passes[] = {1, 7, 30};
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0 ; i < days.length ;i++){
            for(int j = 0 ;j < costs.length ; j++){
                int cost = costs[j] + dp[prev_day(days ,i, passes[j])];
                dp[i + 1] = Math.min(dp[i + 1] , cost);
            }
        }
        return dp[dp.length - 1];
    }
    public int prev_day(int[] days , int i , int j){
        int idx = i - 1;
        while ( idx >= 0 && days[i] - days[idx] < j){
            idx--;
        }
        return idx + 1 ;
    }
}