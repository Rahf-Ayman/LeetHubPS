class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> visited = new HashSet<>();
        for(int i =0 ;i < graph.length ; i++){
            if(!visited.contains(i)){
                boolean flag = BFS(graph , i , visited);
                if(!flag){
                    return false;
                }
                
            }
        }
        
        return true;
    }
    public  boolean BFS(int[][] graph , int start , Set<Integer> visited ){
        int []label = new int[graph.length ];
        Arrays.fill(label,-1);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(start);
        label[start] = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            visited.add(current);
            for (int neighbor : graph[current] ) {
                if(!visited.contains(neighbor)){
                    if(label[neighbor] != -1 && label[neighbor] == label[current] )
                        return false;
                    queue.push(neighbor);
                    if (label[neighbor] == -1)
                    label[neighbor] = label[current] == 1 ? 0 : 1;
                    
                }

            }
        }
        return true;
    }
}