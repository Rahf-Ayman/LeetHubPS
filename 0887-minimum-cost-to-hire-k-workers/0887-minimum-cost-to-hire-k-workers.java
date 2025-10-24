class Solution {
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        ArrayList<double []> ratio =new ArrayList<>();

        for(int i = 0; i < quality.length;i++){
            ratio.add(new double []{(double)  wage[i]/ quality[i] , i});
        }
        Collections.sort(ratio, Comparator.comparingDouble(a -> a[0]));
        double res = Double.MAX_VALUE;
        int sumQ = 0;
        PriorityQueue<Integer> maxQuality = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < quality.length; i++) {
            int q = quality[(int) ratio.get(i)[1]];
            sumQ += q;
            maxQuality.add(q);

            if (maxQuality.size() > k)
                sumQ -= maxQuality.poll(); 

            if (maxQuality.size() == k)
                res = Math.min(res, ratio.get(i)[0] * sumQ);
        }
        
        return res;
    }
}