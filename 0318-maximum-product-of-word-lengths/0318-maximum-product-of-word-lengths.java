class Solution {
    public static  int maxProduct(String[] words) {
        int mask [] = new int [words.length];
        for(int i = 0;i < words.length;i++){
            for(int j = 0;j < words[i].length();j++){
                mask[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }
        int len = 0;
        for(int i = 0;i < words.length - 1;i++ ){
            for(int j = i; j < words.length;j++){
                if((mask[i] & mask[j]) == 0){
                    len = Math.max(len , words[i].length() * words[j].length());
                }
            }

        }
        return len;
    }
}