class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0 ;i < n ;i++){
            graph.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            if(edge[2] <= distanceThreshold) {
                graph.get(edge[0]).add(new Node(edge[1], edge[2]));
                graph.get(edge[1]).add(new Node(edge[0], edge[2]));
            }
        }
        int minCity = 0;
        int minVisited = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            Set<Integer> visited = new HashSet<>();
            int [] dst = new int [n];
            Dijkstra(i , graph ,visited ,distanceThreshold ,dst );
            if(visited.size() < minVisited){
                minVisited = visited.size();
                minCity = i;
            }else if (visited.size() == minVisited){
                minCity = Math.max(minCity , i);
            }
        }
        return minCity;
    }

        public  void Dijkstra(int start , List<List<Node>> graph , Set<Integer> visited ,int distanceThreshold , int [] dist){
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.w ));
        queue.add(new Node(start , 0)); // dummy

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.w > distanceThreshold) continue;
            visited.add(current.u);
            if (dist[current.u] < current.w) continue; // Already processed shorter path

            for (Node neighbor : graph.get(current.u)) {

                int calculatedDist = current.w + neighbor.w;

                if (dist[neighbor.u] > calculatedDist ) {
                    dist[neighbor.u] = calculatedDist;
                    queue.add(new Node(neighbor.u ,calculatedDist ));
                }
            }
        }
    }

    class Node{
        int u;

        int w;
        public Node(int u  , int w){
            this.u = u;

            this.w = w;
        }
    }
}