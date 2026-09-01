# Fixed-Size Sliding Window

## 🧠 Pattern

Use when the window size is fixed at `k`.

> **ADD → CHECK → REMOVE**

## 💻 Template

```js
    function fixedWindow(arr, k) {
        let window = 0;
        let answer = 0;

        for (let i = 0; i < arr.length; i++) {

            // ADD
            window += arr[i];

            // CHECK when window size reaches k
            if (i >= k - 1) {

                answer = Math.max(answer, window);

                // REMOVE outgoing element
                window -= arr[i - k + 1];
            }
        }

        return answer;
    }
```

# Fixed-Size Sliding Window — Example Problem

## 🧩 Problem

Given an array of integers `arr` and an integer `k`, find the **maximum sum of any subarray of size `k`**.

### Example

```text
Input:
arr = [2, 1, 5, 1, 3, 2]
k = 3

Output:
9
```

### Explanation

The windows of size `3` are:

```text
    [2, 1, 5] → sum = 8
    [1, 5, 1] → sum = 7
    [5, 1, 3] → sum = 9  ← maximum
    [1, 3, 2] → sum = 6
```

So the answer is:

```text
    9
```

## 💡 Approach

Use a **Fixed-Size Sliding Window**.

> **ADD → CHECK → REMOVE**

```js
    function maxSum(arr, k) {
        let windowSum = 0;
        let answer = -Infinity;

        for (let i = 0; i < arr.length; i++) {

            // ADD
            windowSum += arr[i];

            // CHECK
            if (i >= k - 1) {
                answer = Math.max(answer, windowSum);

                // REMOVE outgoing element
                windowSum -= arr[i - k + 1];
            }
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
    Window size = FIXED
            ↓
    ADD new element
            ↓
    Window reaches k
            ↓
    CHECK answer
            ↓
    REMOVE old element
```
