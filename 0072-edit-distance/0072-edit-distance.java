class Solution {
    public int minDistance(String word1, String word2) {
        int dp [][] = new int [word1.length() + 1][word2.length() + 1];
        for(int i = 0;i < word1.length();i++){
            Arrays.fill(dp[i], -1);
        }
        
        return dfsDis(word1,word2,0,0,dp);
    }
    
   public int dfsDis(String word1, String word2, int i,int j,int [][]dp){
        if(i == word1.length()) return word2.length() - j; // must ins
        if(j == word2.length()) return word1.length() - i; // must del
        if(dp[i][j] != -1) return dp[i][j];
        int res = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            res = dfsDis(word1,word2,i + 1,j + 1,dp);
        }else{
            res = dfsDis(word1,word2,i + 1,j,dp) + 1; // del
            res = Math.min(res , dfsDis(word1,word2,i,j + 1,dp) + 1); // ins
            res = Math.min(res, dfsDis(word1,word2,i + 1,j + 1,dp) + 1); //replace
        }

        dp[i][j] = res;
        return res;
    }
}