class Solution {
    public int makeConnected(int n, int[][] connections) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> hasParent = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();
        if(connections.length < (n - 1)){
            return -1;
        }
        for(int i = 0; i < n ; i ++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < connections.length ; i++){
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
        }
        int unvisited = Integer.MAX_VALUE ;

        for(int i = 0 ; i < n ; i++){
            if(!visited.contains(i))
               DFS(i , -1, graph , visited , hasParent );
            unvisited = Math.min(n - visited.size() , unvisited );
        }

        return (n - hasParent.size() - 1 - unvisited);
    }
    public  void DFS(int n,int parent , List<List<Integer>> graph , Set<Integer> visited , Set<Integer> hasParent  ){
        if(!visited.contains(n)){
            visited.add(n);
            if(parent != -1){
                hasParent.add(n);
            }
            List<Integer> neighbors = graph.get(n);
            for(int neighbor : neighbors){
                DFS(neighbor ,n , graph , visited , hasParent );
            }
        }

    }
}