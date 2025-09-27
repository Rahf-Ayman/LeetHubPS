class Solution {
    public  boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt((int []a) -> a[1])
                .thenComparingInt(a -> a[2]));
        int currentCapacity = trips[0][0];
        int []minPoint = trips[0];
        if(currentCapacity > capacity){
            return false;
        }
        PriorityQueue<int []> queue = new PriorityQueue<>(Comparator.comparingInt((int []a) -> a[2])
                .thenComparingInt(a -> a[1]));
        queue.offer(minPoint);
        for(int i = 1 ;i < trips.length; i++){
            while(!queue.isEmpty()
                    && (queue.peek()[2] <= trips[i][1])){
                int [] rempvedPoint = queue.poll();
                currentCapacity -= rempvedPoint[0];
            }
            currentCapacity += trips[i][0];
            if(currentCapacity > capacity){
                return false;
            }
            queue.offer(trips[i]);

        }
        return true;
    }
}