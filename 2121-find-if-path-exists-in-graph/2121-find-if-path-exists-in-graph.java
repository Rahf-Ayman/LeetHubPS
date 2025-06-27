class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i =0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return DFS(source , destination, graph ,visited);
    }

    public boolean  DFS(int n ,int dst, List<List<Integer>> graph , Set<Integer> visited ){
        if(n == dst){
            return true;
        }
        if(!visited.contains(n)){
            visited.add(n);

            List<Integer> neighbors = graph.get(n);
            for(int neighbor : neighbors){
                if(DFS(neighbor ,dst, graph ,visited )){
                    return true;
                }
            }
        }
        return false;
    }
}