class Solution {
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if(nums[r] > nums[0] ){
            return nums[0];
        }
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] >= nums[0]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return nums[r];
    }
}