/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    let res = [];
    function helper(array , depth){
        for(let key of array){
            if(Array.isArray(key)){
                if(depth < n){
                    helper(key ,depth + 1);
                }else{
                    res.push(key);
                }
            }else{
                res.push(key);
            }
            
        }
        
    }

    helper(arr , 0);
    return res;
};