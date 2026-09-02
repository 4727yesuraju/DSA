# Variable-Size Sliding Window

## 🧠 Pattern

Use when the window size is **not fixed** and must expand or shrink based on a condition.

> **EXPAND → CHECK → SHRINK → UPDATE**

## 💻 Template

```js
    function variableWindow(arr) {
        let left = 0;
        let answer = 0;

        for (let right = 0; right < arr.length; right++) {

            // ADD
            // add arr[right] to window

            // CHECK → SHRINK
            while (windowIsInvalid()) {

                // REMOVE
                // remove arr[left] from window

                left++;
            }

            // UPDATE
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
```

# Variable-Size Sliding Window — Example Problem

## 🧩 Problem

Given an array of positive integers `arr` and an integer `k`, find the **length of the longest subarray whose sum is less than or equal to `k`**.

### Example

```text
Input:
arr = [2, 1, 3, 1, 1]
k = 5

Output:
3
```

### Explanation

```text
[2, 1]       → sum = 3  ✅
[2, 1, 3]    → sum = 6  ❌ → shrink
[1, 3, 1]    → sum = 5  ✅
[3, 1, 1]    → sum = 5  ✅
```

The longest valid subarray has length `3`.

## 💡 Approach

Use a **Variable-Size Sliding Window**.

> **EXPAND → CHECK → SHRINK → UPDATE**

```js
function longestSubarray(arr, k) {
    let left = 0;
    let sum = 0;
    let answer = 0;

    for (let right = 0; right < arr.length; right++) {

        // ADD
        sum += arr[right];

        // CHECK → SHRINK
        while (sum > k) {
            sum -= arr[left];
            left++;
        }

        // UPDATE
        answer = Math.max(answer, right - left + 1);
    }

    return answer;
}
```

## ⏱️ Complexity

```text
Time:  O(n)
Space: O(1)
```

### 🧠 Remember

```text
Window size = VARIABLE
        ↓
EXPAND
        ↓
Invalid?
        ↓
SHRINK
        ↓
Valid
        ↓
UPDATE longest
```
