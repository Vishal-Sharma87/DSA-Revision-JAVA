// Created at: 22-August-2026
// Last revised 22-August-2026
// Link: https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1

package bitmanipulation.bitwise_xor;

import java.util.HashMap;

/*
Problem Description:
--------------------
Statement:

Given an integer array and an integer k, count the number of subarrays
whose XOR is exactly equal to k.

Examples:

Input:
arr = [4, 2, 2, 6, 4]
k = 6

Output:
4

Explanation:
The valid subarrays are:
[4, 2]
[4, 2, 2, 6, 4]
[2, 2, 6]
[6]

Input:
arr = [5, 6, 7, 8, 9]
k = 5

Output:
2

Input:
arr = [1, 1, 1, 1]
k = 0

Output:
4

Constraints:
1 <= arr.length <= 10^5
0 <= arr[i] <= 10^5
0 <= k <= 10^5
*/

/*
Approach 1: Brute Force

Idea:
Generate every possible subarray and compute its XOR.

Count every subarray whose XOR equals k.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Drawbacks:
Too slow for large arrays.
*/

/*
Approach 2: Prefix XOR + HashMap (Optimal)

Idea:
Maintain the prefix XOR while traversing the array.

Suppose the current prefix XOR is:

currentXOR

If a previous prefix XOR equals:

currentXOR ^ k

then,

(previousXOR ^ currentXOR) = k

which means the subarray between those two indices has XOR equal to k.

Store the frequency of every prefix XOR in a HashMap.

Initialize the map with:

0 → 1

to account for subarrays beginning from index 0.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Insight:
Unlike prefix sums where subtraction is used,

previousPrefix = currentPrefix - k

for XOR we use the self-inverse property:

a ^ b ^ b = a

Therefore,

previousPrefix = currentPrefix ^ k
*/

/*
Method to Solve:
----------------
1. Maintain the running prefix XOR.
2. Compute the required previous prefix XOR as currentXOR ^ k.
3. Add its frequency to the answer.
4. Store the current prefix XOR frequency.
5. Return the total count.
*/

public class CountSubarrayXOREqualsK {

    /**
     * Counts the number of subarrays having XOR equal to k.
     *
     * @param nums input array
     * @param k    target XOR
     * @return total number of valid subarrays
     */
    public long subarrayXor(int[] nums, int k) {

        HashMap<Long, Long> prefixXorFrequency = new HashMap<>();

        // empty prefix
        prefixXorFrequency.put(0L, 1L);

        long prefixXor = 0;
        long count = 0;

        for (int num : nums) {

            prefixXor ^= num;

            long requiredPrefix = prefixXor ^ k;

            count += prefixXorFrequency.getOrDefault(requiredPrefix, 0L);

            prefixXorFrequency.put(
                    prefixXor,
                    prefixXorFrequency.getOrDefault(prefixXor, 0L) + 1);
        }

        return count;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
