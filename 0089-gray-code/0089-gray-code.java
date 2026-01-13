class Solution {
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int num = 0;
        for(int i = 0; i < (1 << n); i++){
            num = i ^ (i >> 1);
            list.add(num);
        }
        return list;
    }
}