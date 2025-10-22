class Solution {
    public int minPatches(int[] nums, int n) {
        int nu = 0;
        long x = 0;
        int i = 0;
        while(i < nums.length ){
            if(x >= n){
                break;
            }
            if(nums[i] <= x + 1){
                x += nums[i];
                i++;
            }else{
                x = 2 * x + 1;
                nu++;
            }
        }
        while(x < n){
            x = 2 * x + 1;
            nu++;
        }
        return nu;
    }
}