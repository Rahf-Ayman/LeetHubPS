class Solution {
    public static int candy(int[] ratings) {
        int c = 0;
        int [] candies = new int [ratings.length];
        Arrays.fill(candies ,1);
        for(int i = 0;i < ratings.length - 1;i++){
            if(ratings[i + 1] > ratings[i]){
                candies[i + 1] = candies[i] + 1;
            }
        }
        for(int i = ratings.length - 1;i > 0;i--){
            if(ratings[i - 1] > ratings[i]){
                candies[i - 1] = Math.max(candies[i - 1] , candies[i] + 1);
            }
        }
        for(int i : candies){
            c += i;
        }
        return c;
    }
}