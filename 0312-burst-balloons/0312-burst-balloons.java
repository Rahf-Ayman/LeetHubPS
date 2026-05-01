class Solution {
    public int maxCoins(int[] nums) {
        int dp [][] = new int [nums.length + 1][nums.length + 1];
        for(int i = 0;i < nums.length;i++){
            Arrays.fill(dp[i], -1);
        }
        
        return dfsCoin(nums,0,nums.length - 1,dp);
    }

    public int dfsCoin(int [] nums,int l ,int r,int [][]dp){
        if(l > r) return 0;
        if(dp[l][r] != -1) return dp[l][r];
        int res = 0;
        for(int i = l;i <= r;i++){ // i is last burst ballon in l r array
            int pre = l == 0 ? 1 : nums[l - 1];
            int suf = r == nums.length - 1 ? 1 : nums[r + 1];
            int gain = dfsCoin(nums,l,i - 1,dp) + dfsCoin(nums,i + 1,r,dp) + nums[i] * pre * suf;
            res = Math.max(res, gain);
        }

        dp[l][r] = res;
        return dp[l][r];
    }
}