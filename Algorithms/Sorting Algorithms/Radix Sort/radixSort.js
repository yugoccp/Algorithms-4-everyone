

//This piece of code does radix sort in ascending order


//function to do zero padding of numbers
function zeroPad(num , width)
{
	num = String(num);
	pad = width - num.length;
	var zeros="";
		
	if(pad > 0)
	{
		while(pad--)
		{
			zeros+="0";
		}
		return zeros+ num;
	}
	return num;
}

//The radixSort functions takes an input unsorted array as argument and returns the sorted array
function radixSort(x)
{
		//To find the maximum value in an array
	var max = x.reduce(function(a, b) {
	    return Math.max(a, b);
	});;
	var maxDigits =String(max).length; //Number of digits in the maximum element required for zeropadding

		//zero padding of each element is done using the function call
	for(var i=0; i<x.length;i++)
	{
		x[i]=zeroPad(x[i], maxDigits); //call to the zeroPad function above 
	}

	//This outer loop iterates for the required number of phases
	for(var i=0; i<maxDigits; i++)
	{
		var buckets = [[],[],[],[],[],[],[],[],[],[]]; //Buckets in a two dimensional array correspomding to each from digit 0 to 9
		for(var j=0; j<x.length;j++)
		{
			buckets[x[j][Number(maxDigits)-i-1]].push(x[j]); //Elements are pushed into the bucket at their corresponding position.
		}
		
		//The input unsorted array is emptied to refill after each phase
		x=[];
		for(k=0;k<10;k++)
		{
			for(l=0;l<buckets[k].length;l++)
			{
				if(buckets[k][l] != null)
				{
					x.push(buckets[k][l]); // Refilling of the input array after phase i
				}
			}
		}
	}

	return x; // Returns the array sorted
}


console.log(radixSort([110,2,88,3,99,2,8]));

