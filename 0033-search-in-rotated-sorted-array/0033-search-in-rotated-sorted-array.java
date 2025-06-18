class Solution {
    public int search(int[] nums, int target) {
        // the sorted array is an imaginary array shifted by rotation value
        int rotation = findRotation(nums);
        int x = -1;
        int l = rotation  ; int r = nums.length - 1 + rotation ;
        while(l <= r){
            int imid  = (l + (r - l) / 2);
            int mid = imid % nums.length;
            if( nums[mid] < target){
                l = imid + 1 ;
            }else if (nums[mid] > target){
                r = imid - 1 ;
            }else{
               x = imid ;
               break;
            }
        }
        if (x >= nums.length){
            return x % nums.length;
        }else{
            return x;
        }
    }

    public int findRotation(int [] nums){
        int l = 0; int r = nums.length - 1;
        if (nums[r] > nums[0]){
            return 0;
        }
        while(l < r){
            int mid = l + (r - l) / 2;
            if( nums[mid] >= nums[0]){
                l = mid + 1;
            }else{
                r = mid ;
            }
        }
        return r ;
    }
}