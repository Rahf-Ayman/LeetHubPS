class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points , Comparator.comparingInt(a -> a[1]));
        int[] minEndPoint = points[0];
        int c = 1;
        for(int i = 0;i < points.length; i++){
            if(minEndPoint[1] < points[i][0]){
                c++;
                minEndPoint = points[i];
            }
        }
        return c;
    }
}