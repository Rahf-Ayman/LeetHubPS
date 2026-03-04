class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<String,Integer> memo = new HashMap<>();
        Map<Integer,List<int []>> map = new HashMap<>();
        for(int [] flight: flights){
            map.putIfAbsent(flight[0],new ArrayList<>());
            map.get(flight[0]).add(new int []{flight[1],flight[2]});
        }
        int res = DFS(map,src,dst,0,k,memo);
        return res == Integer.MAX_VALUE? -1 : res ;
    }
    public static int DFS(Map<Integer,List<int []>> map,int src ,int dist ,int level ,int k ,Map<String,Integer> memo ){
        
        if(src == dist) return 0;
        if(level > k) return Integer.MAX_VALUE;
        
        String str = src + "," + level;
        if(memo.containsKey(str)) return memo.get(str);
        int cost = Integer.MAX_VALUE;

        for(int[] nei : map.getOrDefault(src,new ArrayList<>())){

            int currCost = DFS(map,nei[0],dist,level + 1,k,memo);
            if(currCost != Integer.MAX_VALUE){
                cost = Math.min(cost ,currCost + nei[1]);
            }
        }
        memo.put(str,cost);
        return cost;
    }
}