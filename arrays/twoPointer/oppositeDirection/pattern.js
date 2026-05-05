// Two Pointer — Opposite Ends
// The core idea is simple: place one pointer at the start (L = 0) and one at the end (R = arr.length - 1), then move them toward each other based on some condition. This works efficiently on sorted arrays or strings and avoids nested loops — giving you O(n) time instead of O(n²).


// 1. Pair Sum
// Problem: Given a sorted array, find two numbers that add up to a target.
// Logic:

// If arr[L] + arr[R] === target → found it
// If the sum is too small → L++ (get a bigger number)
// If the sum is too large → R-- (get a smaller number)

// function pairSum(arr, target) {
//     let left = 0, right = arr.length - 1;
//     while (left < right) {
//         let sum = arr[left] + arr[right];
//         if (sum === target) return [left, right];
//         else if (sum < target) left++;
//         else right--
//     }
//     return [-1, -1];
// }

// const arr = [2, 7, 11, 15]
// const target = 90;
// console.log(pairSum(arr, target))



// 2. Reverse Array
// Problem: Reverse an array in -place without using.reverse().
//     Logic:

// Swap arr[L] and arr[R]
// Move both pointers inward: L++, R--
// Stop when they meet or cross


// function reverseArray(arr) {
//     let left = 0, right = arr.length - 1;
//     while (left < right) {
//         [arr[left++], arr[right--]] = [arr[right], arr[left]]
//         // left++;
//         // right--;

//     }
//     return arr;
// }

// console.log(reverseArray([1, 2, 3, 4]))





// 3. Palindrome Check
// Problem: Check if a string(or array of chars) reads the same forwards and backwards.
//     Logic:

// Compare s[L] and s[R]
// If they match → move inward
// If they don't → return false immediately
// If pointers cross without a mismatch → return true


function isPalindrome(str) {
    let left = 0, right = str.length - 1;

    while (left < right) {
        if (str[left++] !== str[right--]) return false;
        // left++;
        // right--;
    }
    return true;
}

console.log(isPalindrome("racecar"))
