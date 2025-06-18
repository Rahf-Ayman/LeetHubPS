class Solution {
    public int mySqrt(int x) {
long l = 0; long r = 1L << 31;
        while (l < r){
            long mid = (l + (r - l) / 2) + 1 ;
            long c = mid *  mid;
            if(c <= x){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return (int)l;
    }
}