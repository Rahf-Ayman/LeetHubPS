class Solution {
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1;
        boolean prevflag = false;
        boolean zero;
        boolean start = false;
        
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            zero = diff == 0;
            if (zero) continue;
            boolean calcuFlag = diff > 0;
            if (!start || calcuFlag != prevflag) {
                start = true;
                res++;
                prevflag = calcuFlag;
            }
        }
        return res;
    }
}

