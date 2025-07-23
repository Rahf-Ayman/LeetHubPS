class Solution {
   public int[] findRightInterval(int[][] intervals) {
        List<Integer> qu = new LinkedList<>();
        int res [] = new int [intervals.length];
        int sorted [] [] = new int [intervals.length][2];
        for(int i = 0 ; i < intervals.length ; i++){
            sorted[i][0] = intervals[i][0];
            sorted[i][1] = i;
        }
        
        Arrays.sort(sorted , Comparator.comparingInt(a -> a[0]));

        for(int i = 0 ; i < intervals.length ; i++){
            int l = 0;
            int r = intervals.length - 1;
            int ans = -1;
            while(l <= r){
                int mid  = l + (r - l) / 2;
                if(intervals[i][1] <= sorted[mid][0]){
                    ans = sorted[mid][1];
                    r = mid - 1;
                    
                }else{
                    l = mid + 1;
                }
            }
            res[i] = ans;
        }
        return res;
    }
}