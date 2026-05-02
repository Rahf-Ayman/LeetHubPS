class Solution {
    public boolean isMatch(String s, String p) {
        boolean [][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for(int i = s.length(); i >= 0;i--){
            for(int j = p.length() - 1; j >= 0;j--){
                boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if(j < p.length() - 1 && p.charAt(j + 1) == '*'){
                    if(match){ //more
                        dp[i][j] = dp[i + 1][j];
                    }// zero
                    dp[i][j] = dp[i][j] || dp[i][j + 2];
                }else if(match){
                    dp[i][j] = dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}