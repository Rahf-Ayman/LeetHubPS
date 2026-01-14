class Solution {
    public static int singleNumber(int[] nums) {
        int bits [] = new int[32];
        for(int i = 0 ;i < nums.length;i++){
            for(int j = 0;j < 32;j++){
                if((nums[i] & (1 << j)) != 0){
                    bits[j]++;
                }
            }
        }
        int numR = 0;
        for(int j = 0;j < 32;j++){
            numR |= ((bits[j] % 3) << j);
        }
        return numR;
    }
}