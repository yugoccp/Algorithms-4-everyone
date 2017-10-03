//after each iternation you have 1 number in the correct positon
//smallest to largest
//O(n2) - worst case
function selectionSortAscending(inputArray){
    for(var i = 0; i < inputArray.length - 1; i++){
      var minIndex = i;
      for(var j = i + 1; j < inputArray.length; j++){
        if(inputArray[minIndex] > inputArray[j]){
          minIndex = j;//found new minimum
        }
      }

      //swap if minimum isn't the current i iteration
      if(minIndex != i){
        var temp = inputArray[minIndex];
        inputArray[minIndex] = inputArray[i];
        inputArray[i] = temp;
      }
      console.log('In progress: ', inputArray);
    }
    return inputArray;
}

var input = [3,2,43,6,777,83,5,5];
console.log('Output: ', selectionSortAscending(input));
