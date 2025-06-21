class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
           int answer [] = new int [n];
    Map<Integer , List<Integer>> adj = new HashMap<>();
   
        for(int i =1;i <= n ;i++){
        adj.put(i , new ArrayList<>());
        
    }
        for(int i= 0 ;i < paths.length ;i++){
        adj.get(paths[i][0]).add(paths[i][1]);
        adj.get(paths[i][1]).add(paths[i][0]);

    }
        for(int i =1 ; i <= n ; i++){

        List<Integer> neibours = adj.get(i);
        boolean [] used = new boolean[5];
            for(int neibour : neibours){
                if(answer[neibour -1] != 0){
                    used[answer[neibour -1]] = true;
                }
            }
        for(int k = 1 ;k <= 4; k++){
            if(!used[k]) {
                answer[i - 1] = k;
                break;
            }
        }

    }

        return answer;
    }
}