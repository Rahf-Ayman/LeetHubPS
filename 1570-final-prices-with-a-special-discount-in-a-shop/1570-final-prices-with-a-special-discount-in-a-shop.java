class Solution {
    public static int[] finalPrices(int[] prices) {
        int [] ans = new int [prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = prices.length - 1;i >= 0;i--){
            while (!stack.isEmpty() && prices[i] < stack.peek())
                stack.pop();

            ans[i] =!stack.isEmpty()? prices[i] - stack.peek() : prices[i];
            stack.push(prices[i]);
        }
        return ans;
    }
}