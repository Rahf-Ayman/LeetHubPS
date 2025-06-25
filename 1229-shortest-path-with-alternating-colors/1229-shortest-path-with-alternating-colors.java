class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : redEdges) {
            graph.get(edge[0]).add(new Node(edge[1], "red"));
        }
        for (int[] edge : blueEdges) {
            graph.get(edge[0]).add(new Node(edge[1], "blue"));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        // BFS queue with node, previous color, and distance
        Queue<NodeWithDist> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new NodeWithDist(0, "none", 0));
        visited.add("0-none");

        while (!queue.isEmpty()) {
            NodeWithDist current = queue.poll();
            int u = current.u;
            String prevColor = current.color;
            int d = current.dist;

            if (dist[u] == -1) dist[u] = d;

            for (Node neighbor : graph.get(u)) {
                if (!neighbor.color.equals(prevColor)) {
                    String key = neighbor.u + "-" + neighbor.color;
                    if (!visited.contains(key)) {
                        visited.add(key);
                        queue.offer(new NodeWithDist(neighbor.u, neighbor.color, d + 1));
                    }
                }
            }
        }

        return dist;
    }

    class Node {
        int u;
        String color;
        Node(int u, String color) {
            this.u = u;
            this.color = color;
        }
    }

    class NodeWithDist {
        int u;
        String color;
        int dist;
        NodeWithDist(int u, String color, int dist) {
            this.u = u;
            this.color = color;
            this.dist = dist;
        }
    }
}
