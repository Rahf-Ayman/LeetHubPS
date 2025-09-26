class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

//        for(int i = 0; i < intervals.length; i++){
//            for(int j= i + 1; j < intervals.length;j++){
//                if(intervals[i][1] > intervals[j][1]){
//                    int [] temp = intervals[i];
//                    intervals[i] = intervals[j];
//                    intervals[j] = temp;
//                }
//            }
//        }
        int c = 1;
        int[] minEndPoint = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if((minEndPoint[1] != intervals[i][1])
                    && (minEndPoint[1] <= intervals[i][0]) ){
                minEndPoint = intervals[i];
                c++;
            }
//            if((intervals[i][1] != intervals[i + 1][1])
//                    && (intervals[i][1] <= intervals[i + 1][0]) ){
//                c++;
//            }
        }
        return intervals.length - c;
    }
}