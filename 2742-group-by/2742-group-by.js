/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    let jsonObject = {};
    for(let i = 0;i < this.length ;i++){
        if(jsonObject[fn(this[i])] === undefined){
           jsonObject[fn(this[i])] = [];
           jsonObject[fn(this[i])].push(this[i]); 
        }else{
           jsonObject[fn(this[i])].push(this[i]);  
        }
    }
    return jsonObject;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */