removeEven = (arr)=>{
    return arr.filter(i=>i%2!=0)
}

reverseArray = (arr)=>{
    for(let i=0,j=arr.length-1;i<j;i++,j--){
        arr[i] += arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] -= arr[j];
    }
    return arr;
}

findMin = (arr)=>{
     let min = arr[0];
     for(let i=1;i<arr.length;i++){
        if(arr[i]<min) min = arr[i];
     }
     return min;
}

findSecondMax = (arr)=>{
    let [firstMax,secondMax] = [Number.MIN_VALUE,Number.MIN_VALUE];
    for(let i=0;i<arr.length;i++){
        if(arr[i]>firstMax){
            secondMax = firstMax;
            firstMax = arr[i]
        }else if(arr[i]>secondMax && arr[i]!=firstMax) secondMax = arr[i];
    }
    return secondMax;
}


moveAllZerosRight = (arr)=>{
    for(let j=0,i=0;i<arr.length;i++){
        if(arr[i]!=0 && arr[j]==0){
            arr[i]+=arr[j];
            arr[j]=arr[i]-arr[j];
            arr[i]-=arr[j]
        }
        if(arr[j]!=0) j++;
    }
    return arr;
}

findMissingNumber = (arr)=>{
    return arr.reduce((acc,ele)=>{
      return acc-ele
    },(arr.length+1)*(arr.length+2)/2)

}

isPalindrome = (str)=>{
    for(i=0,j=str.length-1;i<j;i++,j--)
        if(str.charAt(i)!=str.charAt(j)) return false;
    return true
}
// console.log(removeEven([3,2,4,5,8,9]))
// console.log(reverseArray([10,2,3,4,5,6]))

// console.log(findMin([3,1,6,8,3,0,,-1]))
// console.log(findSecondMax([5,2,5,2,5,3]))
// console.log(moveAllZerosRight([0,2,3,0,4,0]))
// console.log(findMissingNumber([1,4,5,3,2]))

console.log(isPalindrome("madam"))