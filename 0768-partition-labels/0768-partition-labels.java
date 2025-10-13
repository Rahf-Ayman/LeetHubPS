class Solution {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();
        HashMap<Character ,Integer> freq = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            if(freq.containsKey(s.charAt(i))){
                freq.put(s.charAt(i), freq.get(s.charAt(i)) + 1);
            }else{
                freq.put(s.charAt(i),  1);
            }
        }
        int l = 0;
        for(int i = 0;i < s.length();i++){
            if(!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            if(freq.get(s.charAt(i)) > 0)
                freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
            if(freq.get(s.charAt(i)) == 0)
                set.remove(s.charAt(i));
            if(set.isEmpty()){
                res.add(i - l + 1);
                l = i + 1;
            }
        }
        return res;
    }
}