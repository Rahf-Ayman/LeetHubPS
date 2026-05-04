class Solution {
    public static boolean canJump(int[] nums) {
        int i = 0;
        int maxPos = 0;
        while(i < nums.length){
            if(i > maxPos) return false; // not reachable
            if(maxPos >= nums.length - 1){
                return true;
            }
            maxPos = Math.max(maxPos , i + nums[i]);
            i++;
        }
        return false;
    }
}