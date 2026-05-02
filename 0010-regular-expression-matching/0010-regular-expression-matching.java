class Solution {
    public boolean isMatch(String s, String p) {
        Boolean [][] dp = new Boolean[s.length() + 1][p.length() + 1];
        
        return dfsMatch(s,p,0,0,dp);
    }
    public boolean dfsMatch(String s, String p ,int i,int j,Boolean [][] dp){
        if(p.length() == j) return s.length() == i;
        boolean res = false;
        if(dp[i][j] != null) return dp[i][j];
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if(j < p.length() - 1 && p.charAt(j + 1) == '*'){
            if(match){ //more
                res = dfsMatch(s,p,i + 1,j,dp);
            }// zero
             res = res || dfsMatch(s,p,i,j + 2,dp);
             return dp[i][j] = res;
        }
        if(match){
             res = dfsMatch(s,p,i + 1,j + 1,dp);
             return dp[i][j] = res;
        }

         res = false;
         dp[i][j] = res;
        return dp[i][j];
    }
}