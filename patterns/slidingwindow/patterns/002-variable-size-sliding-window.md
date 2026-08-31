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
