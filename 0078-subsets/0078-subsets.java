class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i  < (1 << nums.length); i++){ // i  < (1 << nums.length) = 2^n - 1
            List<Integer> sublist = new ArrayList<>();
            for(int j = 0 ; j < nums.length;j++){
                if((i & (1 << j)) != 0){
                    sublist.add(nums[j]);
                }
            }
            list.add(sublist);
        }
        return list;
    }
}