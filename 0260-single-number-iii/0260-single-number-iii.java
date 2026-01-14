class Solution {
    public static int[] singleNumber(int[] nums) {
        int [] arr =  new int [2];
        int numR = nums[0];
        for(int i = 1;i < nums.length;i++){
            numR ^= nums[i];
        }
        int i;
        for(i = 0; i < 32; i++){
            if((numR & (1 << i)) != 0){
                break;
            }
        }

        for(int j = 0;j < nums.length;j++){
            if((nums[j] & 1 << i) != 0){
                arr[0] ^= nums[j];
            }else{
                arr[1] ^= nums[j];
            }
        }
        return arr;
    }
}