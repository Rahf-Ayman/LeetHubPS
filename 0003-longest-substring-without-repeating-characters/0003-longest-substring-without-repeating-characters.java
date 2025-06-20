class Solution {
    public int lengthOfLongestSubstring(String s) {
       Map<Character , Integer> lastOccerance = new HashMap<>();

        int maxLength = 0;
        int l = 0;
        for(int r = 0 ;r < s.length() ; r++){
            if(lastOccerance.containsKey(s.charAt(r))){
                l = Math.max(l ,lastOccerance.get(s.charAt(r)) + 1); // no move backward
            }
            lastOccerance.put(s.charAt(r) , r);
            
                maxLength = Math.max(maxLength , r - l + 1);
        }

        return maxLength;
    }
}