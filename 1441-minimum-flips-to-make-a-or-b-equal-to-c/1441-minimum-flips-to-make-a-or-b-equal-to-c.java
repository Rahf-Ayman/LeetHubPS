class Solution {
    public int minFlips(int a, int b, int c) {
        int num = (a | b);
        int temp = num ^ c;
        int co = 0;
        for(int i = 0;i < 32;i++){
            if((temp & (1 << i)) != 0){
                if((num & (1 << i)) != 0){
                    co += 2;
                }else{
                    co++;
                }
            }
        }
        return co;
    }
}