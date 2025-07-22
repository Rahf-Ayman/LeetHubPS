class Solution {
    public int lengthOfLIS(int[] nums) {
        return go(0, -1, nums, new Integer[nums.length][nums.length + 1]);
    }

    public int go(int i, int prevIndex, int[] nums, Integer[][] dp) {
        if (i == nums.length) return 0;

        if (dp[i][prevIndex + 1] != null) return dp[i][prevIndex + 1];

        int notTake = go(i + 1, prevIndex, nums, dp);

    
        int take = 0;
        if (prevIndex == -1 || nums[i] > nums[prevIndex])
            take = 1 + go(i + 1, i, nums, dp);

        return dp[i][prevIndex + 1] = Math.max(take, notTake);
    }
    
}