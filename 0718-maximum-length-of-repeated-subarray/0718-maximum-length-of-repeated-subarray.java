class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int [] dp = new int [nums2.length + 1];
        int max = 0;
        for(int i = 1; i <= nums1.length ;i++){
            for(int j = nums2.length ;j >= 1  ; j--){ // to avoid the direction of reset (flow  left)
                if(nums1[i - 1] == nums2[j - 1]){  
                  dp[j] = dp[j - 1] + 1; 
                  max = Math.max(max , dp[j]); 
                }else{
                  dp[j] = 0; 
                }
                
            }
        }
        return max;
    }
}