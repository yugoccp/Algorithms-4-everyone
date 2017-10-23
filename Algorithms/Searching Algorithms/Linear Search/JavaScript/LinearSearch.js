/**
 * @author Patryk Jóźwiak
 */
function linearSearch(haystack, needle) {
    var len = haystack.length;
    // Go through all values
    for (var i = 0; i < len; i++) {
        // Check if current value is equel to search value
        if (haystack[i] === needle) return i;
    }
    return -1;
}

var haystack = [1, 2, 3, 4, 9, 51, 54, 65, 45, 77];
console.log( linearSearch(haystack, 65) );
