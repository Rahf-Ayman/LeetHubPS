class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        float [] diff = new float [gas.length];
        Queue<Integer> queue = new ArrayDeque<>();
        if(gas.length == 1){
            return gas[0] - cost[0] >= 0? 0 : -1;
        }
        for(int i = 0;i < gas.length;i++){
            diff[i] = gas[i] - cost[i];
            if (diff[i] > 0){
                queue.offer(i);
            }
        
        }
        while(!queue.isEmpty()){
            int max = queue.poll();
            int i = max;
            int pre = 0;
            while(i < gas.length * 2){
                pre = pre + gas[i % gas.length] - cost[i % gas.length];
                if(pre >= 0){

                    i++;
                }else{
                    break;
                }

                if((i + 1) / gas.length == 2 && pre >= 0){
                    return max;
                }
            }
        }

        return -1;
    }
}