class Solution {
    public static int lengthOfLIS(int[] nums) {
        int dp [][] = new int [nums.length][nums.length + 1];
        for(int i = 0 ; i < nums.length ; i++)
            Arrays.fill(dp[i] , -1);
        return go(0 , -1 , nums , dp);
    }
    public static int go(int i , int j , int[] nums , int [][] dp){
        if (i == nums.length ) return 0; //base case
        if(dp[i][j + 1] != -1) return dp[i][j + 1];
        int ch1 = go(i + 1 , j , nums , dp);
        int ch2 =0;
        if(j == -1 || nums[i] > nums[j])
            ch2 = go(i + 1 , i , nums ,dp) + 1;
        return dp[i][j + 1] = Math.max(ch1 , ch2);
    }
    
}