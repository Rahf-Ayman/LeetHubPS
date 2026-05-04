class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> list = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int [][] memo = new int[numCourses][numCourses];
        for(int i = 0;i < numCourses;i++){
            Arrays.fill(memo[i] , -1);
        }
        for(int i = 0;i < numCourses;i++){
             adj.add(new ArrayList<>());
        }
        for(int [] intry : prerequisites){
            adj.get(intry[0]).add(intry[1]);
        }
        for(int [] q : queries){
            if(dfsQu(adj, q[0] ,q[1],memo)){
                list.add(true);
            }else{
                list.add(false);
            }

        }
        return list;
    }
    public boolean dfsQu(List<List<Integer>> adj , int i ,int t ,int [][] memo){
        if(i == t) return true;
        if(memo[i][t] != -1) return memo[i][t] == 1 ? true : false;
        for(int nei : adj.get(i)){
            if(dfsQu(adj,nei,t,memo)){
                memo[nei][t] = 1;
                return true;
            }
        }
        memo[i][t] = 0;
        return false;
    }
}