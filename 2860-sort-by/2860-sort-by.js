/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */

let mergeSort = function(arr , l,r , fn){
    if(l < r){
        let mid = Math.floor(l + (r - l) / 2);;
        mergeSort(arr ,l ,mid ,fn);
        mergeSort(arr ,mid + 1 ,r ,fn);
        merge(arr , l ,mid ,r ,fn);
    }
} 

let merge = function(arr , l, mid , r , fn){
    let left = [];
    let right = [];

    let size1 = mid - l + 1;
    let size2 = r - mid;

    for(let i = 0;i < size1;i++){
        left[i] = arr[l + i];
    }

    for(let i = 0;i < size2;i++){
        right[i] = arr[mid + 1 + i];
    }
    let i = 0;
    let j = 0;
    let k = l;

    while(i < size1 && j < size2){
        if(fn(left[i]) <= fn(right[j])){
            arr[k] = left[i];
            i++
        }else{
            arr[k] = right[j];
            j++;
        }
        k++;
    }

    while(i < size1){
        arr[k] = left[i];
        i++;
        k++;
    }

    while(j < size2){
        arr[k] = right[j];
        j++;
        k++;
    }
}
var sortBy = function(arr, fn) {
    let l = 0;
    let r = arr.length - 1;

    mergeSort(arr , 0 , arr.length - 1, fn );
    



    // for(let i = 0;i < arr.length ;i++){
    //     for(let j = i + 1;j < arr.length;j++){
    //         if(fn(arr[i]) > fn(arr[j])){
    //             let temp = arr[j];
    //             arr[j] = arr[i];
    //             arr[i] = temp;
    //         }
    //     }
    // }
    return arr;
};