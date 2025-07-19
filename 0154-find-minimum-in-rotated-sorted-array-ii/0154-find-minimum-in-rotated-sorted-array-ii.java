class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        if(nums.length == 1){
            return nums[0];
        }
        while(i < nums.length - 1 && nums[i] == nums[r] )
            i++;
        if(nums[r] > nums[i] ){
            return nums[i];
        }
        
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] >= nums[i]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return nums[r];
    }
}