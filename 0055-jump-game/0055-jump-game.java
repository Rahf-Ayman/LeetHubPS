class Solution {
    public static boolean canJump(int[] nums) {
        Boolean []arr = new Boolean[nums.length];
        return go(nums, 0 , arr);
    }
    public static boolean go(int[] nums, int pos ,Boolean []arr ) {
        if (pos >= nums.length - 1) {
            return true;
        }
        if (nums[pos] == 0) {
            return false;
        }
        if(arr[pos] != null){
            return arr[pos];
        }
        for (int i = nums[pos]; i > 0; i--) {
            if (go(nums, pos + i ,arr)) {
                arr[pos] = true;
                return true;
            }
        }
        arr[pos] = false;
        return false;
    }
}