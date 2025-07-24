class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int [][] dp = new int [nums1.length][nums2.length];
        for(int i = 0;i <dp.length ; i++){
            Arrays.fill(dp[i] , -1);
        }

        int maxLen = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                maxLen = Math.max(maxLen, go(i, j, nums1, nums2, dp));
            }
        }
        return maxLen;
    }
    public static int go(int i , int j , int[] nums1 , int[] nums2 , int [][] dp){
        if(i == nums1.length || j == nums2.length ) return 0; //base case
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(nums1[i] == nums2[j]){
            return dp[i][j] = go(i + 1, j + 1 ,nums1 , nums2 ,dp) + 1;
        }else{
            dp[i][j] = 0;
            return dp[i][j];
        }
         
    }
}