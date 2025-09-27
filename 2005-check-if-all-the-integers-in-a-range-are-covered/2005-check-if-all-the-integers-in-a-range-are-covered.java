class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        for(int []q : ranges){
            if(q[0] <= left && q[1] >= left ){
                left = q[1] + 1;
            }
            if(left > right) return true;
        }
        return false;
    }
}