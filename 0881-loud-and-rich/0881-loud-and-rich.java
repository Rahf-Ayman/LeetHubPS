class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int [] ans = new int [quiet.length];
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> toplogicalOrder = new LinkedList<>();
        boolean [] visit = new boolean[quiet.length];
        for(int i = 0;i < quiet.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int r [] : richer){
            adj.get(r[0]).add(r[1]);
        }

        for(int i = 0;i < quiet.length;i++){
            dfsTop(adj,visit,i,toplogicalOrder);
        }
        for(int i = 0;i < quiet.length;i++){
            ans[i] = i;
        }
        for(int i =0;i < toplogicalOrder.size();i++){
            int y = toplogicalOrder.get(i);
            for(int x : adj.get(y)){
                if(quiet[ans[y]] < quiet[ans[x]]){
                    ans[x] = ans[y];
                }
            }
        }
        return ans;
    }
    public void dfsTop(List<List<Integer>> adj, boolean [] visit, int node , List<Integer> list){
        if(visit[node] == true){
            return;
        }
        visit[node] = true;
        for(int i : adj.get(node)){
            dfsTop(adj,visit,i ,list);
        }
        list.add(0,node);
    }
}