class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> dp = new ArrayList<>();
        for(int i =0 ;i <= rowIndex ; i++){
            dp.add(new ArrayList<>(i + 1));
        }
        dp.get(0).add(0,1);
        for(int i =1 ; i <= rowIndex ; i++ ){
            for (int j =0 ; j <= i ; j++ ){
                if(j == 0 || j == i){
                    dp.get(i).add(j,1);
                }else{
                    dp.get(i).add(j , dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j ) );
                }

            }
        }
        return dp.get(rowIndex);
    }
}