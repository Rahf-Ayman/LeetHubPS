class Solution {
    public String smallestSubsequence(String s) {
      Map<Character , Integer> map = new HashMap<>();
        Set<Character> inStack = new HashSet<>();
        Stack<Character> stack = new Stack();
        for(int i = 0; i< s.length() ;i++){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0) + 1 );
        }
        for(int i = 0; i< s.length() ;i++){
            map.put(s.charAt(i) , map.get(s.charAt(i)) - 1 );
            if(inStack.contains(s.charAt(i)))
                continue;
            while(!stack.isEmpty() && (int) stack.peek() > (int)s.charAt(i) && map.get(stack.peek()) > 0  ){
               inStack.remove(stack.pop()) ;
            }

            stack.push(s.charAt(i));
            inStack.add(s.charAt(i));

        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}