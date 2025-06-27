class Solution {
    public int findCenter(int[][] edges) {
        int pair11 = edges[0][0];
        int pair12 = edges[0][1];
        int pair21 = edges[1][0];
        int pair22 = edges[1][1];

        if(pair11 == pair21){
            return pair11;
        }else if(pair11 == pair22){
            return pair11;
        }else{
            return pair12;
        }

        
    }
}