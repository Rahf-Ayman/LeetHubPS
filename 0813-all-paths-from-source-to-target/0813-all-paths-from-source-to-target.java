class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       List<List<Integer>> pathes = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        DFS(0 , graph.length - 1 ,graph,  pathes , curr );


        return pathes; 
    }
    public static void DFS(int n , int dst ,int[][] graph , List<List<Integer>> pathes , List<Integer> curr ){
            curr.add(n);
            if(n == dst){
                pathes.add(new ArrayList<>(curr));
            }else{
                for(int i = 0 ; i < graph[n].length ; i++){
                    DFS(graph[n][i] , graph.length - 1 , graph ,pathes  , curr );
                }
            }

            curr.remove(curr.size() - 1);



    }
}