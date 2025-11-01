class Solution {
    public static String removeDuplicateLetters(String s) {
        String res = "";
        Map<Character,Integer> freq = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i) , 0) + 1);
        }
        Stack<Character> mono = new Stack<>(); // incresing order
        Set<Character> set = new HashSet<>();
        for(int  i = 0;i < s.length();i++){
            freq.put(s.charAt(i) , freq.get(s.charAt(i)) - 1);
            if(set.contains(s.charAt(i))) continue;
            while(!mono.isEmpty() && s.charAt(i) <= mono.peek() && freq.get(mono.peek()) > 0){
                set.remove(mono.peek());
                mono.pop();
            }
            mono.push(s.charAt(i));
            set.add(s.charAt(i));
        }
        Stack<Character> rev = new Stack<>();
        while (!mono.isEmpty())
            rev.push(mono.pop());
        while (!rev.isEmpty()){
            res += rev.pop();
        }
        return res;
    }
}