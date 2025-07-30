/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
    
    return new Promise(resolve => {
        let t = Date.now();
        
        setTimeout( _ => resolve(Date.now() - t) , millis);
    })
}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */