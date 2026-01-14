class Solution {
    public static int[] findArray(int[] pref) {
        int [] nums = new int [pref.length];
        nums[0] = pref[0];
        for(int i = 1;i < pref.length;i++){
            nums[i] = pref[i - 1] ^ pref[i];
        }
        return nums;
    }
}