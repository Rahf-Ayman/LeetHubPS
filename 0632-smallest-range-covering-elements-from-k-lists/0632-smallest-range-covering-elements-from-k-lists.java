class Solution {
    public static int[] smallestRange(List<List<Integer>> nums) {
        int minVal = 0;
        int maxVal = Integer.MIN_VALUE;

        int maxRange = Integer.MAX_VALUE; // valid ranges
        int minRange = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int i = 0;i < nums.size();i++){
            queue.add(new int[]{nums.get(i).getFirst(), i,0});
            maxVal = Math.max(maxVal ,nums.get(i).getFirst());
        }

        while(queue.size() == nums.size()){
            int [] min = queue.poll();
            minVal = min[0];
            
            if(maxVal - minVal < maxRange - minRange){
                maxRange = maxVal;
                minRange = minVal;
            }

            if(min[2] + 1 < nums.get(min[1]).size()){ // fit the next min start of the range
                queue.add(new int[]{nums.get(min[1]).get(min[2] + 1), min[1],min[2] + 1});
                maxVal = Math.max(maxVal ,nums.get(min[1]).get(min[2] + 1));
            }

        }
        return new int []{minRange ,maxRange};
    }
}