class Solution {
    public  int minTimeToReach(int[][] moveTime) {
        return shortestPath(moveTime);
    }
    
    public  int shortestPath(int[][] moveTime){
        int [] x = {-1 , 1 , 0 , 0}; // up down left right
        int [] y = {0 , 0 , -1 , 1};
        int [] index = {1 , 2};
        int c = -1;
        int dist [] [] = new int [moveTime.length] [moveTime[0].length];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.w ));
        queue.add(new Pair(0 ,0 , 0 , 0)); // dummy

        while (!queue.isEmpty()) {

            Pair current = queue.poll();
            if (dist[current.x][current.y] < current.w) continue; // Already processed shorter path
            for(int i = 0 ; i < 4 ; i++){
                int newx = current.x + x[i];
                int newy = current.y + y[i];
                if(newx < 0 || newx >= moveTime.length || newy < 0 || newy >= moveTime[0].length )
                    continue;
                Pair neighbor = new Pair(newx ,newy , moveTime[newx][newy] , current.level + 1 );
                int calculatedDist;

                if(current.w  < neighbor.w){
                    calculatedDist = neighbor.w + index[current.level % 2];
                }else{
                    calculatedDist = current.w + index[current.level % 2] ;
                }
                if(calculatedDist < dist[neighbor.x][neighbor.y]){
                    dist[neighbor.x][neighbor.y] = calculatedDist;
                    queue.add(new Pair(neighbor.x , neighbor.y , calculatedDist, current.level + 1));
                }
            }

        }
        return dist[moveTime.length - 1][moveTime[0].length - 1] ;
    }
    class Pair{
        int x;
        int y;
        int w;
        int level;

        public Pair(int x  , int y , int w  ,int level){
            this.x = x;
            this.w = w;
            this.y = y;
            this.level = level;
        }
    }
}