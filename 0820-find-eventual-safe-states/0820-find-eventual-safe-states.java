class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        int [] visit = new int [graph.length];
        for(int i = 0;i < graph.length;i++){
            if(DFS(graph,i, visit)){
                res.add(i);
            }
        }
        return res;
    }
    public boolean DFS(int[][] graph,int node, int [] visit){
        if(visit[node] == 1) return false;
        if(visit[node] == 2) return true;

        visit[node] = 1;
        for(int i : graph[node]){
            if(!DFS(graph,i,visit)){
                return false;
            }
            
        }
        visit[node] = 2;
        return true;
    }
}