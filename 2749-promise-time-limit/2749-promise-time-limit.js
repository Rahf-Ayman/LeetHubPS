/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    
    return async function(...args) {
        return new Promise ( (resolve , reject) => {
            let flag = false;

            const timeId = setTimeout(_ => {
                if(!flag){
                    flag = true;
                    reject("Time Limit Exceeded");
                }
            }, t);

            fn(...args).then( res =>{
                if(!flag){
                    resolve(res);
                    clearTimeout(timeId);
                }
            }).catch(err =>{
                if(!flag){
                    reject(err)
                    clearTimeout(timeId);
                }
                
            })
        });
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */