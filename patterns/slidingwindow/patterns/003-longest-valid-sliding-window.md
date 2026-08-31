# Longest Valid Sliding Window

## 🧠 Pattern

Use when you need to find the **longest subarray / substring that satisfies a condition**.

> **EXPAND → CHECK → SHRINK → UPDATE**

## 💻 Template

```js
    function longestValid(arr) {
        let left = 0;
        let answer = 0;

        for (let right = 0; right < arr.length; right++) {

            // ADD
            // add arr[right] to window

            // CHECK → SHRINK until valid
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
