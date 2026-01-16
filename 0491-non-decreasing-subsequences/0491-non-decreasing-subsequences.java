class Solution {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int v = (int)Math.pow(2, 2);
        int c = 2;
        for(int i = 3;i < (1 << nums.length);i++){
            if(i == v){
                c++;
                v = (int)Math.pow(2,c);
                continue;
            }
            List<Integer> subList = new ArrayList<>();
            for(int j = 0;j < nums.length;j++){
                if((i & (1 << j)) != 0){
                    if(!subList.isEmpty() && subList.getLast() > nums[j]) continue;
                    subList.add(nums[j]);
                }
            }
            if(subList.size() > 1 && !set.contains(subList)){
                set.add(subList);
                list.add(subList);
            }
        }
        return list;
    }
}