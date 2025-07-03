class Solution {
    public static int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int [days.length + 1];
        int arr[] = {1, 7, 30};
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0 ; i < days.length ;i++){
            int cost1 = costs[0] + dp[next_day(days ,i, arr[0])];
            int cost2 = costs[1] + dp[next_day(days ,i, arr[1])];
            int cost3 = costs[2] + dp[next_day(days ,i, arr[2])];
            dp[i + 1] = Math.min(cost1 , Math.min(cost2 , cost3));

        }
        return dp[dp.length - 1];
    }
    public static int next_day(int[] days , int i , int j){
        int idx = i - 1;
        while ( idx >= 0 && days[i] - days[idx] < j){
            idx--;
        }
        return idx + 1 ;
    }
}