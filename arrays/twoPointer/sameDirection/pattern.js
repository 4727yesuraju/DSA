// Two Pointer — Same Direction
// Unlike opposite ends (where pointers move toward each other), 
// same-direction pointers both start from the left and move right — but at different speeds or for different jobs.


//remove Duplicates in sorted array

function removeDuplicatesInSortedArray(arr) {
    let slow = 0;
    for (let fast = 1; fast < arr.length; fast++) {
        if (arr[slow] !== arr[fast]) arr[++slow] = arr[fast]
    }
    return ++slow
}

const arr1 = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
const newLength = removeDuplicatesInSortedArray(arr1)
console.log(arr1.slice(0, newLength))