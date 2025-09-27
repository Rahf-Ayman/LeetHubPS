class Solution {
    public  boolean carPooling(int[][] trips, int capacity) {
        int [] stops = new int [1001];
        for(int i = 0;i < trips.length;i++){
            stops[trips[i][1]] += trips[i][0];
            stops[trips[i][2]] -= trips[i][0];
        }
        
        for(int i = 0;i < stops.length;i++){
            capacity -= stops[i];
            if(capacity < 0) return false;
        }
        return true;
    }
}