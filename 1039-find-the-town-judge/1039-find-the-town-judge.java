class Solution {
    public  int findJudge(int n, int[][] trust) {
        Map<Integer , Set<Integer>> votes = new HashMap<>();
        Map<Integer , Set<Integer>> novotes = new HashMap<>();
        for(int i =0 ;i < n ; i++){
            votes.put(i , new HashSet<>());
            novotes.put(i , new HashSet<>());
        }
        for(int [] one : trust){
            votes.get(one[1] - 1).add(one[0] - 1);
            novotes.get(one[0] - 1).add(one[1] - 1);
        }
        for(int i =0 ;i < n ; i++){
            if (votes.get(i).size() == n - 1 && novotes.get(i).size() == 0)
                return i + 1;
            
        }
        return -1;
    }
}