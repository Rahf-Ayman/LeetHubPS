class Solution {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> set = new HashSet<>();
        int c ;
        int maxLength = 0;
        for(int i = 0 ;i<s.length() ; i++){
            c = 0;
            set.add(s.charAt(i));
            c++;
            for(int j = i + 1; j< s.length() ; j++){
                if( !set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    c++;
                }else{
                    set.clear();
                    
                    break;
                }
            }
            maxLength = Math.max(c , maxLength);
        }

        return maxLength;
    }
}