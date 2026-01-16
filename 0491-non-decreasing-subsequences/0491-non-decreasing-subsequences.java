class Solution {
    public static List<List<Integer>> findSubsequences(int[] nums){
        List<List<Integer>> res = new LinkedList<>();
        go(new LinkedList<>(), 0,nums, res);
        return res;
    }

    public static void go(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res){
        if(list.size() > 1) res.add(new LinkedList<>(list));
        Set<Integer> set = new HashSet<>();
        for(int i = index;i < nums.length;i++) {
            if(set.contains(nums[i])) continue;  // can not repeat the same number at the same level prevent repeated seq
            if (list.isEmpty() || list.getLast() <= nums[i]){
                list.add(nums[i]);
                set.add(nums[i]);
                go(list, i + 1, nums, res);
                list.removeLast(); //backtrack
            }
        }
    }
}