class Solution {
    public int countArrangement(int n) {

        int arr [] = new int [n + 1];
        for(int i = 1 ; i <= n; i++){
            arr[i] = i;
        }
        return go(1 ,arr );
    }
    public int go(int index  , int [] arr){
        if(index == arr.length ) return 1;
        int count = 0;
        for(int i = index ; i < arr.length ;i++){
            if(arr[i] % index == 0 || index % arr[i]  == 0 ) {
                swap(arr, index, i);
                count += go(index + 1, arr);
                swap(arr, index, i);
            }
        }
        return count;
    }

    public void swap(int [] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}