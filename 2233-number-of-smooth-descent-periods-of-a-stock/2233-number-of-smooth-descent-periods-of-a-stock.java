class Solution {
    public long getDescentPeriods(int[] prices) {
        long c = 0;
        long len = 1;
        for(int i = 1;i < prices.length;i++){
            if(prices[i - 1] - prices[i]  == 1){
                len++;
            }else{
                c = (len * (len + 1) / 2) + c;
                len = 1;
            }
        }
        c = (len * (len + 1) / 2) + c;
        return c;
    }
}