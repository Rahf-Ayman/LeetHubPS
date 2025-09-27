class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int [] res = new int [queries.length];
        Arrays.fill(res, -1);
        int [][]RangeIntervals = new int[intervals.length][3];
        for(int i = 0; i < intervals.length; i++){
            RangeIntervals[i][0] = intervals[i][1] - intervals[i][0] + 1;
            RangeIntervals[i][1] = intervals[i][0];
            RangeIntervals[i][2] = intervals[i][1];
        }
        Arrays.sort(RangeIntervals , Comparator.comparingInt(a -> a[1]));
        int [][] querieswIndex = new int [queries.length][2];
        for(int i = 0; i < queries.length; i++){
            querieswIndex[i][0] = i;
            querieswIndex[i][1] = queries[i];
        }
        Arrays.sort(querieswIndex , Comparator.comparingInt(a -> a[1]));
        
        PriorityQueue<int []> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int j = 0;
        for(int i = 0; i < queries.length; i++){
            while(j < RangeIntervals.length && querieswIndex[i][1] >= RangeIntervals[j][1]){
                queue.offer(RangeIntervals[j]);
                j++;
            }
            while(!queue.isEmpty() && queue.peek()[2] < querieswIndex[i][1]){
                queue.poll();
            }
            if(!queue.isEmpty())
                res[querieswIndex[i][0]] = queue.peek()[0];

        }
        return res;
    }
}