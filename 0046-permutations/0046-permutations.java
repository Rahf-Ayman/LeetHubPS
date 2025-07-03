class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        go(0 , nums , list , list1);
        return list;
    }
    public void go(int index  , int [] arr , List<List<Integer>> list , List<Integer> list1 ){
        if(index == arr.length ) list.add(new ArrayList<>(list1));

        for(int i = index ; i < arr.length ;i++){
                list1.add(index,arr[i]);
                swap(arr, index, i);
                go(index + 1, arr ,list ,list1);
                list1.remove(index);  // backtrack
                swap(arr, index, i);

        }

    }

    public void swap(int [] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
