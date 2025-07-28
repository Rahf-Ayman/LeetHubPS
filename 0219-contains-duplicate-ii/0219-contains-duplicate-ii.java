class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer , Integer> indx = new HashMap<>(); // save last index
        for(int i = 0; i< nums.length ;i++){
            if(indx.containsKey(nums[i])){
                if(i - indx.get(nums[i]) <= k){
                    return true;
                }
            }
            indx.put(nums[i] , i);
        }
        return false;
    }
}