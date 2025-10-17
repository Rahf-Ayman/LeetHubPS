class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int curr = 0;
        int total = 0; // the sum of all element if >=0 there is a solution
        int res = 0;
        for(int i = 0;i < gas.length;i++){
            curr += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(curr < 0){ // assume i can start from res until it make sum < 0
                curr = 0;
                res = i + 1;
            }
        }

        return total >= 0 ? res : -1;
    }
}