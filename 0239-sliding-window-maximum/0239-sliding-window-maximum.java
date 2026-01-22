public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int [] arr = new int [nums.length - k + 1];
        int l = 0;
        int max = 0;
        int lastMax = 0;
        int i = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> (b[0] - a[0]));
        for(int r = 0;r < nums.length;r++){
            queue.add(new int [] {nums[r], r});
            if(r + 1 >= k){
                while(queue.peek()[1] <= r - k ){
                    queue.poll();
                }
                arr[i++] = queue.peek()[0];
            }
        }
        return arr;
    }
}