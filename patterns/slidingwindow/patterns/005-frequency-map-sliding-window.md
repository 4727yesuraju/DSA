# Frequency Map Sliding Window

## 🧠 Pattern

Use when you need to **track the frequency/count of elements or characters inside the window**.

> **ADD → UPDATE FREQUENCY → CHECK → SHRINK → UPDATE**

## 💻 Template

```js
    function frequencyMapWindow(arr) {
        let left = 0;
        let answer = 0;
        const freq = new Map();

        for (let right = 0; right < arr.length; right++) {

            // ADD
            freq.set(arr[right], (freq.get(arr[right]) || 0) + 1);

            // CHECK → SHRINK
            while (windowIsInvalid()) {

                // REMOVE
                freq.set(arr[left], freq.get(arr[left]) - 1);

                if (freq.get(arr[left]) === 0) {
                    freq.delete(arr[left]);
                }

                left++;
            }

            // UPDATE
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
```
