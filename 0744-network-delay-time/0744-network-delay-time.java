class Solution {
    public  int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> graph = new ArrayList<>();
        int[] dist = new int[n + 1]; // 1-based
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            graph.get(time[0]).add(new Node(time[1], time[2]));
        }

        Dijkstra(graph, k, dist);

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }

    public  void Dijkstra(List<List<Node>> graph , int start , int dist [] ){
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.w));
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (dist[current.u] < current.w) continue; // Already processed shorter path

            for (Node neighbor : graph.get(current.u)) {
                int calculatedDist = dist[current.u] + neighbor.w;
                if (dist[neighbor.u] > calculatedDist) {
                    dist[neighbor.u] = calculatedDist;
                    queue.add(new Node(neighbor.u, calculatedDist));
                }
            }
        }
    }
    

     class Node{
        int u;
        int w;
        public Node(int u , int w){
            this.u = u;
            this.w = w;
        }
    }
}