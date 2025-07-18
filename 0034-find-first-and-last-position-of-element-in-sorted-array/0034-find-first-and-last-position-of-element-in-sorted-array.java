class Solution {
    public int[] searchRange(int[] nums, int target) {
        int arr [] = {- 1, -1};

        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                int rem = mid;
                arr[0] = rem ;
                arr[1] = rem ;
                while(rem >= 0 && nums[rem] == target){
                    arr[0] = rem;
                    rem-- ;

                }
                rem = mid;
                while(rem <= nums.length - 1 && nums[rem] == target){
                    arr[1] = rem;
                    rem++;
                }

                return arr;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return arr;
    }
}