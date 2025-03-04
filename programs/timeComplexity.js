function findSumOrder1(n){
     return n*(n+1)//2
}

function findSumOrderN(n){
    let sum = n+1;  //reducing 1 & last iterations
    for(let i=2;i<n;i++){
        sum+=i;
    }
    return sum;
}


function calculateTime(fun,n){
    let now = performance.now();
    fun(n);
    return performance.now() - now;
}


console.log("time taken for Order(1) : ",calculateTime(findSumOrder1,9999999))
console.log("time taken for Order(n) : ",calculateTime(findSumOrderN,9999999))