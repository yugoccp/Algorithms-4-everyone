// can execute script with Node.js (v6) by running: node BinarySearch.js

const generateArray = (length, multiplier) => {
    let arr = [];
    for (i = 1; i <= length; i++) {
        arr.push(i * multiplier);
    }
    return arr;
};

const binarySearch = (arr, valueToFind) => {
    let min = 0;
    let max = arr.length - 1;
    let iterations = 0;
    let searchIndex, found;

    while (max >= min) {
        // start by looking at value in middle of array (assuming it is sorted)
        searchIndex = Math.floor((max + min) / 2);
        foundValue = arr[searchIndex];
        iterations++;

        if (foundValue === valueToFind) {
            break;
        }
        // on each iteration, reduce search range by half by:
        // adjusting min if midway value was less than search value, or
        // adjusting max if midway value was greater than search value
        min = foundValue < valueToFind ? searchIndex + 1 : min;
        max = foundValue > valueToFind ? searchIndex - 1 : max;
    }
    foundValue = foundValue === valueToFind ? valueToFind : -1;
    return {
        foundValue,
        searchIndex,
        iterations
    };
};

const main = () => {
    const arr = generateArray(Math.ceil(Math.random() * 100), Math.ceil(Math.random() * 10));
    console.log(`Array is: [ ${arr.join(', ')} ]`);

    const value = Math.ceil(Math.random() * 100);
    console.log(`Will attempt to find ${value} in array.`);

    const { foundValue, iterations, searchIndex } = binarySearch(arr, value);
    if (foundValue === -1) {
        console.log(`Did not find value in ${iterations} iterations.`)
    } else {
        console.log(`Found ${foundValue} at index ${searchIndex} after ${iterations} iterations.`)
    }
};

main();
