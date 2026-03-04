class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int []>> map = new HashMap<>();
        PriorityQueue<int []> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int [][] res = new int [n][k + 2]; // states for cities and their stops
        for(int i =0 ;i < n;i++){
            Arrays.fill(res[i],Integer.MAX_VALUE);
        }
        for(int [] flight: flights){
            map.putIfAbsent(flight[0],new ArrayList<>());
            map.get(flight[0]).add(new int []{flight[1],flight[2]});
        }

        queue.add(new int []{src ,0,0});
        while(!queue.isEmpty()){
           int [] curr = queue.poll();
           int node = curr[0]; int cost = curr[1]; int stops = curr[2];
           if(curr[0] == dst) return  cost;
           if(stops > k || res[node][stops] < cost) continue;
           for(int [] nei : map.getOrDefault(curr[0],new ArrayList<>())){
               int wei = nei[1] + cost;
               int nextStop = stops + 1;
               if(wei < res[nei[0]][nextStop]){
                   res[nei[0]][nextStop] = wei;
                   queue.add(new int []{nei[0], nei[1] + cost, nextStop});
               }

           }
        }
        return -1;
    }
}