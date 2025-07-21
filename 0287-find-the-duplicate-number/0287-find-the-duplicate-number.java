class Solution {
    public int findDuplicate(int[] nums) {
        int  l = 0;
        int r = nums.length - 1;
        while( l < r){
            int mid  = (l + r) / 2;
            int c = 0;
            for(int num : nums){
                if(num <= mid) c++;
            }
            
            if(c > mid){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}