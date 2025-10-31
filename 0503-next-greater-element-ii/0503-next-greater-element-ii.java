class Solution {
    public static int[] nextGreaterElements(int[] nums) {
        int [] res = new int [nums.length];
        Stack<Integer> decrese = new Stack<>();
        for(int i = nums.length * 2 - 2; i >= 0;i--){
            while (!decrese.isEmpty() && decrese.peek() <= nums[i % nums.length])
                decrese.pop();
            res[i % nums.length] = decrese.isEmpty() ? -1 : decrese.peek();
            decrese.push(nums[i % nums.length]);
        }
        
        return res;
    }
}