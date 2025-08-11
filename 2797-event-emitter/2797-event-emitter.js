class EventEmitter {
    constructor(){
        this.map = new Map();
    }
    
    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {
        if(!this.map.has(eventName)){
            this.map.set(eventName , []);
            this.map.get(eventName).push(callback);
        }else{
            this.map.get(eventName).push(callback);
        }

        return {
            unsubscribe: () => {
                let arr = this.map.get(eventName) || [];
                this.map.set(eventName , arr.filter(v => v !== callback));
                return undefined;
            }
        };
    }
    
    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
        let res = [];
        let arr = this.map.get(eventName) || [];
        for(let func of arr){
            if(func === undefined){
                continue;
            }
            res.push(func(...args));
            
            
        }
        return res;
    }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */