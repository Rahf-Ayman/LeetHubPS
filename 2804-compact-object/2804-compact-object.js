/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */

var compactObject = function(obj) {
    if (Array.isArray(obj)) {
        return obj.map(v => compactObject(v)).filter(Boolean); 
    } else if (obj !== null && typeof obj === "object") {
        let newObj = {};
        for (let key in obj) {
            let value = compactObject(obj[key]);
            if (Boolean(value)) { // a built-in function that converts a value to true or false.
                newObj[key] = value;
            }
        }
        return newObj;
    }
    return obj;
};
