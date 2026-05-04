class Solution {
    public static int jump(int[] nums) {
        int maxPos = 0;
        int l = 0;
        int r = 0;
        int jumps = 0;
        while (r < nums.length - 1){
            for(int j = l;j <= r;j++){ // all reaching point from the current jumps
                maxPos = Math.max(maxPos, j + nums[j]);
            }
            l = r + 1; // min index with curr jumps
            r = maxPos; // max index with curr jumps
            jumps++;
        }
        return jumps;
    }
}