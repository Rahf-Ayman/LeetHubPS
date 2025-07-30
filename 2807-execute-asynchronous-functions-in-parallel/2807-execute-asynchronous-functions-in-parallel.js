/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {
    return new Promise ((resolve , reject) =>{
        let c = 0;
        const result = [];
        for(let i = 0;i < functions.length;i++){
            functions[i]().then(res =>{
                result[i] = res;
                c++;
                if(c == functions.length){
                    resolve(result);
                }
            }).catch(err => reject(err));
        }
        
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */