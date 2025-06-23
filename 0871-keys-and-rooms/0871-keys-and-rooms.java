class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        DFS(0 , rooms ,visited);

        return visited.size() == rooms.size();
    }
    public static void DFS(int n , List<List<Integer>> graph , Set<Integer> visited){
        if(!visited.contains(n)){
            visited.add(n);
            List<Integer> neighbors = graph.get(n);
            for(int neighbor : neighbors){
                DFS(neighbor , graph , visited);
            }
        }

    }
}