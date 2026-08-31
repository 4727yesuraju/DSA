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
