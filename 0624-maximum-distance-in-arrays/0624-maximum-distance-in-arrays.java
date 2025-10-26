class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int dist = Integer.MIN_VALUE;
        int max = arrays.get(0).getLast();
        int min = arrays.get(0).get(0);

        for(int i =1 ;i < arrays.size();i++){
              dist = Math.max(dist 
                      ,Math.max(Math.abs(max - arrays.get(i).get(0) ) 
                              ,Math.abs(min - arrays.get(i).getLast())));
              max = Math.max(max , arrays.get(i).getLast());
              min = Math.min(min , arrays.get(i).get(0));
        }

        return dist;
    }
}