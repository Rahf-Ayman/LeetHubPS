class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> reverseAdj = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int out [] = new int [graph.length];
        for(int i = 0;i < graph.length;i++){
            reverseAdj.add(new ArrayList<>());
        }
        for(int i = 0;i < graph.length;i++){
            out[i] = graph[i].length;
            if(out[i] == 0) {
                queue.add(i);
            }
            for(int j = 0;j < graph[i].length;j++){
                reverseAdj.get(graph[i][j]).add(i);
            }
        }
        while (!queue.isEmpty()){
            int curr = queue.poll();
            res.add(curr);
            for(int i : reverseAdj.get(curr)){
                out[i]--;
                if(out[i] == 0){
                    queue.add(i);
                }
            }
        }
        res.sort(Integer::compareTo);
        return res;
    }
}