/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    const res = [];
    let c = 0;
    let i = 0;
    while(c < arr.length ){
        temp = [];
        for(let j = 0;j < size && c < arr.length;j++ ){
            temp.push(arr[c]);
            c++;
        }
        res.push(temp);
    }
    return res;
};
