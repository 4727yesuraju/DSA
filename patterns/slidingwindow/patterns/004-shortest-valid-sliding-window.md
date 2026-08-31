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
