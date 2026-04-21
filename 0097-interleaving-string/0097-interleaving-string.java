class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean [][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        dp[s1.length()][s2.length()] = true;
        // j + i = k
        for(int i = s1.length();i >= 0;i--){
            for(int j = s2.length();j >= 0;j--){
                if(i < s1.length()){
                    if(s1.charAt(i) == s3.charAt(j + i) && dp[i + 1][j]){
                        dp[i][j] = true;
                    }
                }

                if(j < s2.length()){
                    if(s2.charAt(j) == s3.charAt(j + i) && dp[i][j + 1]){
                        dp[i][j] = true;
                    }
                }
            }
        }

        return dp[0][0];
    }
}