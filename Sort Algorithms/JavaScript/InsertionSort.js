function InsertionSort(a)
{
    var temp,pos;
    for(var m=1;m<a.length;m++)
    {
        temp = a[m];
        for(pos=m-1;pos>=0&&a[pos]>temp;pos--){
            a[pos+1]=a[pos]
        }
        a[pos+1]=temp
    }
    return a;
}

var a= [6,5,4,3,2,1];
console.log("Elements Before Insertion sort-->",a);
console.log("Elements After Insertion Sort-->",InsertionSort(a));
