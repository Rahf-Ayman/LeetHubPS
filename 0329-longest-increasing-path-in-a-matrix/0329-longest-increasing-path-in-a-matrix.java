class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int [][] memo = new int [matrix.length][matrix[0].length];
        for(int i = 0;i < matrix.length;i++){
            Arrays.fill(memo[i] ,-1);
        }
        int maxLen = 0;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                maxLen = Math.max(dfsLP(matrix,i,j,Integer.MIN_VALUE,memo) ,maxLen);
            }
        }
        return maxLen;
    }

    public int dfsLP(int [][] matrix ,int i ,int j,int prevInt, int [][] memo){
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        int utiliy = 1;
        if( i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prevInt) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        for(int k = 0;k < dx.length;k++){
            int x = i + dx[k];
            int y = j + dy[k];

            utiliy = Math.max(utiliy,dfsLP(matrix,x,y,matrix[i][j],memo) + 1);
        }
        memo[i][j] = utiliy;
        return utiliy;
    }


}