class Solution {
    public int fib(int n) {
        int dp[] = new int[31];
        Arrays.fill(dp,-1);
        return go(n , dp);
    }
    public int go(int n , int dp[]){
        if(dp[n] != -1){
            return dp[n];
        }
        if(n == 0)
            return dp[0] = 0;
        if(n == 1)
            return dp[1] = 1;
        else
            dp[n] = go(n - 1 ,dp ) + go(n - 2 ,dp);
            return dp[n];
    }
}