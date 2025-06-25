class Solution {
    public  int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int [] answer = new int [n];
        List<List<Node>> graph = new ArrayList<>();
        
        for(int i =0 ;i < n ; i++){
            graph.add(new ArrayList<>());

        }
        for(int [] redEdge : redEdges){

            graph.get(redEdge[0]).add(new Node(redEdge[1] , "red" , 1));
        }
        for(int [] blueEdge : blueEdges){

            graph.get(blueEdge[0]).add(new Node(blueEdge[1] , "blue" , 1));
        }
        BFS(graph , 0 , answer );
        return answer;
    }

    public  void BFS(List<List<Node>> graph , int start , int dist [] ){
        Arrays.fill(dist, -1);
        dist[start] = 0;
        Set<String> visited = new HashSet<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(new Node(start ,"" , 0)); // dummy

        while(!queue.isEmpty()){
            Node current = queue.poll();
            for (Node neighbor : graph.get(current.u)) {
                if (current.color.equals(neighbor.color)) continue;
                int calculatedDist = current.w + neighbor.w;
                String key = neighbor.u +""+ neighbor.color;
                if(!visited.contains(key)) {
                    visited.add(key);
                    queue.add(new Node(neighbor.u, neighbor.color, calculatedDist));
                }
                if (dist[neighbor.u] == -1 ) {
                    dist[neighbor.u] = calculatedDist;
//                    queue.add(new Node(neighbor.u , neighbor.color,calculatedDist ));
                }
            }
        }
    }
    class Node{
        int u;
        String color;
        int w;
        public Node(int u , String color , int w){
            this.u = u;
            this.color = color;
            this.w = w;
        }
    }
}
