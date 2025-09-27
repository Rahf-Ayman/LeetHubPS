class Solution {
    public int minTaps(int n, int[] ranges) {
        int [][] intervals = new int [ranges.length][2];
        for(int i = 0 ;i < intervals.length ;i++){
            intervals[i][0] = Math.max(0 ,i - ranges[i]);
            intervals[i][1] = Math.min(i + ranges[i] , n);
        }
        Arrays.sort(intervals , Comparator.comparingInt(a -> a[0]));

        int taps = 0;
        int currentEnd = 0;
        int farthest = 0;
        int i = 0;
        while (currentEnd < n){
            while ( i < intervals.length && intervals[i][0] <= currentEnd){
                farthest = Math.max(farthest , intervals[i][1]);
                i++;
            }
            if(farthest == currentEnd) return -1;
            taps++;
            currentEnd = farthest; 
        }
        
        return taps;
    }
}