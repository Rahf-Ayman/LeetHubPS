class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Boolean [] dp = new Boolean[(1 << nums.length)];
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % k != 0){
            return false;
        }
        Arrays.sort(nums);
        revearse(nums);
        return backtrack(nums,0,sum / k,0,k,(1 << nums.length) - 1,dp);
    }

    public boolean backtrack(int [] nums, int i ,int reqSum ,int currSum ,int k, int mask ,Boolean []dp){
        if(dp[mask] != null){
            return dp[mask];
        }
        if(k == 0){
           return dp[mask] = true;
        }
        if(reqSum == currSum){
            dp[mask] = backtrack(nums,0,reqSum,0,k - 1,mask,dp);
            return dp[mask];
        }

        for(int j = i; j < nums.length;j++){
            if(((mask & (1 << j)) == 0) || currSum + nums[j] > reqSum){
                continue;
            }
            if(backtrack(nums,j + 1,reqSum,currSum + nums[j],k,mask ^ (1 << j) ,dp)){
               return dp[mask] = true;
            }
            if(currSum == 0){
               return dp[mask] = false;
            }
        }
        return dp[mask] = false;
    }

    public void revearse(int [] nums){
        int l = 0; int r = nums.length - 1;
        while (l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

    }
}