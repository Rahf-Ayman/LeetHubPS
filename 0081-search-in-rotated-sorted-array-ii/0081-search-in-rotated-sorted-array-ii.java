class Solution {
    public  boolean search(int[] nums, int target) {
        int pivot = findPivot(nums) ;
        int l = pivot ;
        int r = (pivot + nums.length - 1);

        while( l <= r){
            int imid = (l + (r - l) / 2 );
            int mid = imid % nums.length;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                l = imid + 1;
            }else{
                r = imid - 1;
            }
        }
        return false;
    }
    public  int findPivot(int [] nums){
        for(int i = 0 ;i < nums.length - 1 ; i++){
            if(nums[i] > nums[i + 1]){
                return i + 1;
            }
        }
        return 0;
    }
}