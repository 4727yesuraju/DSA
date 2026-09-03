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

# Longest Valid Sliding Window — Example Problem

## 🧩 Problem

Given a string `s`, find the **length of the longest substring without repeating characters**.

### Example

```text
Input:
s = "abcabcbb"

Output:
3
```

### Explanation

```text
"abc" → all characters are unique ✅
"bca" → all characters are unique ✅
"cab" → all characters are unique ✅
"abc" → all characters are unique ✅
"bb"  → duplicate ❌
```

The longest valid substring is:

```text
"abc"
```

Answer:

```text
3
```

## 💡 Approach

Use a **Longest Valid Sliding Window**.

> **EXPAND → CHECK → SHRINK → UPDATE**

```js
function longestUnique(s) {
    let left = 0;
    let answer = 0;
    const seen = new Set();

    for (let right = 0; right < s.length; right++) {

        // ADD
        while (seen.has(s[right])) {

            // REMOVE
            seen.delete(s[left]);
            left++;
        }

        seen.add(s[right]);

        // UPDATE
        answer = Math.max(answer, right - left + 1);
    }

    return answer;
}
```

## ⏱️ Complexity

```text
Time:  O(n)
Space: O(n)
```

### 🧠 Remember

```text
EXPAND
   ↓
Duplicate?
   ↓
YES → SHRINK
   ↓
Valid Window
   ↓
UPDATE longest
```
