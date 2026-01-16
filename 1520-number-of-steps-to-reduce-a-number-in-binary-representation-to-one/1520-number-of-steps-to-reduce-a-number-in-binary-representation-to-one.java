class Solution {
    public static  int numSteps(String s) {
        int k = s.length() - 1;
        int carry = 0;
        for(int i = s.length() - 1; i > 0;i--){
            if(s.charAt(i) - '0' + carry == 1){
                k++;
                carry = 1;
            }
        }
        
        return k + carry;
    }
}