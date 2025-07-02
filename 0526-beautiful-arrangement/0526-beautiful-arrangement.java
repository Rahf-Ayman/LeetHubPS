class Solution {
    public int c = 0;
    public int countArrangement(int n) {

        int arr [] = new int [n + 1];
        for(int i = 1 ; i <= n; i++){
            arr[i] = i;
        }

         go(1 ,arr );
         return c;
    }
    public void go(int index  , int [] arr){
        if(index == arr.length ) c++;

        for(int i = index ; i < arr.length ;i++){
            if(arr[i] % index == 0 || index % arr[i]  == 0 ) {
                swap(arr, index, i);
                go(index + 1, arr);
                swap(arr, index, i);
            }
        }
    }

    public void swap(int [] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}