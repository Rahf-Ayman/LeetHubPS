class Solution {
    public  int findJudge(int n, int[][] trust) {
        int [] arr = new int [n];

        for(int [] one : trust){
            arr[one[1] - 1]++;
            arr[one[0] - 1]--;
            
        }
        for(int i =0 ;i < n ; i++){
            if (arr[i] == n - 1)
                return i + 1;

        }
        return -1;
    }
}