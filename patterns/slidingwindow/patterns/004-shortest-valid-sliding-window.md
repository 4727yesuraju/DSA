# Shortest Valid Sliding Window

## 🧠 Pattern

Use when you need to find the **shortest subarray / substring that satisfies a condition**.

> **EXPAND → CHECK → UPDATE → SHRINK**

## 💻 Template

```js
    function shortestValid(arr) {
        let left = 0;
        let answer = Infinity;

        for (let right = 0; right < arr.length; right++) {

            // ADD
            // add arr[right] to window

            // CHECK → SHRINK while valid
            while (windowIsValid()) {

                // UPDATE
                answer = Math.min(answer, right - left + 1);

                // REMOVE
                // remove arr[left] from window

                left++;
            }
        }

        return answer === Infinity ? 0 : answer;
    }
```

# Shortest Valid Sliding Window — Example Problem

## 🧩 Problem

Given an array of positive integers `arr` and an integer `k`, find the **length of the shortest subarray whose sum is greater than or equal to `k`**.

### Example

```text
Input:
arr = [2, 3, 1, 2, 4, 3]
k = 7

Output:
2
```

### Explanation

```text
[2, 3, 1, 2] → sum = 8  → length = 4
    [3, 1, 2, 4] → sum = 10 → length = 4
        [1, 2, 4] → sum = 7 → length = 3
            [2, 4, 3] → sum = 9 → length = 3
                [4, 3] → sum = 7 → length = 2 ✅
```

The shortest valid subarray is:

```text
[4, 3]
```

Answer:

```text
2
```

## 💡 Approach

> **EXPAND → CHECK → UPDATE → SHRINK**

```js
function shortestSubarray(arr, k) {
    let left = 0;
    let sum = 0;
    let answer = Infinity;

    for (let right = 0; right < arr.length; right++) {

        // ADD
        sum += arr[right];

        // CHECK → SHRINK while valid
        while (sum >= k) {

            // UPDATE
            answer = Math.min(answer, right - left + 1);

            // REMOVE
            sum -= arr[left];
            left++;
        }
    }

    return answer === Infinity ? 0 : answer;
}
```

## ⏱️ Complexity

```text
Time:  O(n)
Space: O(1)
```

### 🧠 Remember

```text
EXPAND
   ↓
Valid?
   ↓
YES → UPDATE
   ↓
SHRINK
   ↓
Try smaller window
```
