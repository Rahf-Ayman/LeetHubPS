class Solution {
    public static List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < (1 << n);i++){
            int newN = i ^ (i >> 1);
            if(newN == start){
                idx = i;
            }
            list.add(newN);
        }
        for(int i = 0; i < (1 << n);i++){
            newList.add(list.get((i + idx) % (1 << n)));
        }
        list.clear();
        return newList;
    }
}