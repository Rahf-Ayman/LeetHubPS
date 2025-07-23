class Solution {
   public int[] findRightInterval(int[][] intervals) {
        List<Integer> qu = new LinkedList<>();
        for(int i = 0 ; i < intervals.length ; i++){
            int mind = -1;
            int min = 0;
            for(int j = 0 ; j < intervals.length ; j++){
                
                if(intervals[j][0] >= intervals[i][1] && (intervals[j][0] < min || mind == -1)){
                    mind = j;
                    min = intervals[j][0];
                }
            }

            qu.add(mind);
        }
        return qu.stream().mapToInt(i -> i).toArray();
    }
}