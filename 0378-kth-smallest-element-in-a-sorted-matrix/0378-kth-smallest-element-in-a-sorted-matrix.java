class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0 ;i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(queue.size() < k){
                    queue.add(matrix[i][j]);
                }else{
                    if(matrix[i][j] < queue.peek()){
                        queue.poll();
                        queue.add(matrix[i][j]);
                    }
                }
            }
        }
        return queue.peek();
    }
}