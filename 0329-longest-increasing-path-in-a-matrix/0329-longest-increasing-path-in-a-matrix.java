class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int [][] indgree = new int[matrix.length][matrix[0].length];

        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};

        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                for(int k = 0;k < dx.length;k++){
                    int r = i + dx[k];
                    int c = j + dy[k];
                    if(r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length){
                        if(matrix[i][j] > matrix[r][c]){
                            indgree[i][j]++; // make directed graph repr num of in direction
                        }
                    }
                }
            }
        }

        Queue<int []> queue = new ArrayDeque<>();
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(indgree[i][j] == 0){
                    queue.add(new int []{i,j});
                }
            }
        }
        int maxLen = 0;
        while (!queue.isEmpty()){
            int s = queue.size();
            for(int i = 0;i < s;i++){
                int [] node = queue.poll();
                int r = node[0]; int c = node[1];
                for(int k = 0;k < dx.length;k++){
                    int x = r + dx[k];
                    int y = c + dy[k];

                    if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[r][c]){
                        if(--indgree[x][y] == 0){
                            queue.offer(new int []{x , y});
                        }
                    }

                }
            }
            maxLen++; // increase by every level
        }
        return maxLen;
    }


}