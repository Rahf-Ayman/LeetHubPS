class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int [1001][1001];
        for(int i = 0;i< dp.length ;i++){

            Arrays.fill(dp[i],-1);
        }
        return go(0 , s.length() - 1, s,dp);
    }
    public int go(int i , int j , String s,int dp[][]){
        if(i > j) return 0; // base case
        if(i == j) return 1;
        if(dp[i][j] != -1 ){
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = go(i + 1 ,j - 1 ,s ,dp) + 2;
        }
        int ch1 = go(i + 1, j ,s ,dp);
        int ch2 = go(i ,j - 1 ,s ,dp);
        return dp[i][j] = Math.max(ch1 ,ch2);
    }
}