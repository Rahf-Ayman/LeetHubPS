class Solution {
    public static  int numSteps(String s) {
        StringBuilder str = new StringBuilder(s);
        int k = 0;
        Stack<Character> stack = new Stack<>();
        while(str.length() > 1){
            if(str.charAt(str.length() - 1) == '0'){ //even
                str.deleteCharAt(str.length() - 1);
            }else{
                int i;
                for(i = str.length() - 1; i >= 0;i--){
                    if(str.charAt(i) == '0'){
                        str.setCharAt(i ,'1');
                        break;
                    }else{
                        str.setCharAt(i ,'0');
                    }
                }
                if(i < 0){
                    str.insert(0,'1');
                }

            }
            k++;
        }
        return k;
    }
}