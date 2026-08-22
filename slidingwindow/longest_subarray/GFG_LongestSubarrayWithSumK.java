// Created at: 22-August-2026
// Last revised at: 22-August-2026
// Link: https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

package slidingwindow.longest_subarray;

import java.util.HashMap;

/*
Problem Description:
--------------------
Statement:

Given an array of integers and an integer k, find the length of the
longest subarray whose sum is exactly equal to k.

Examples:

Input:
arr = [10, 5, 2, 7, 1, 9]
k = 15

Output:
4

Explanation:
The longest subarray is [5, 2, 7, 1].

Input:
arr = [-1, 2, 3]
k = 6

Output:
0

Constraints:
1 <= arr.length <= 10^5
-10^5 <= arr[i] <= 10^5
-10^9 <= k <= 10^9
*/

/*
Approach 1: Brute Force

Idea:
Generate every possible subarray and compute its sum separately.

Time Complexity:
O(n³)

Space Complexity:
O(1)

Drawbacks:
Recomputes the same sums repeatedly.
*/

/*
Approach 2: Improved Brute Force

Idea:
Generate every subarray while maintaining a running sum instead of
recalculating it every time.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Drawbacks:
Still too slow for large inputs.
*/

/*
Approach 3: Prefix Sum + HashMap (Optimal)

Idea:
Maintain a running prefix sum while traversing the array.

If the current prefix sum equals k, then the subarray from index 0 to
the current index is valid.

Otherwise, if (prefixSum - k) has appeared before, then the elements
between that previous index and the current index form a valid subarray.

Store only the first occurrence of every prefix sum using putIfAbsent().
Keeping the earliest occurrence always gives the longest possible
subarray.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Insight:
If:

currentPrefixSum - previousPrefixSum = k

then the elements between those two prefix sums form the required
subarray.
*/

/*
Method to Solve:
----------------
1. Traverse the array while maintaining the prefix sum.
2. If the prefix sum equals k, update the answer.
3. Search for (prefixSum - k) in the HashMap.
4. If found, update the maximum length.
5. Store the prefix sum only if it appears for the first time.
*/

public class GFG_LongestSubarrayWithSumK {

    /**
     * Returns the length of the longest subarray whose sum equals k.
     *
     * @param nums input array
     * @param k    target sum
     * @return maximum subarray length
     */
    public int getLength(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumToIndex = new HashMap<>();

        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            if (prefixSum == k) {
                maxLength = i + 1;
            }

            Integer index = prefixSumToIndex.get(prefixSum - k);

            if (index != null) {
                maxLength = Math.max(maxLength, i - index);
            }

            // store first occurrence only
            prefixSumToIndex.putIfAbsent(prefixSum, i);
        }

        return maxLength;
    }

    /**
     * Checks whether the given subarray sums to the target value.
     * Used by the brute force approach.
     *
     * @param nums   input array
     * @param start  starting index
     * @param end    ending index
     * @param target target sum
     * @return true if subarray sum equals target
     */
    public boolean isSubarraySumEqualsK(int[] nums, int start, int end, int target) {
        return getSumOfSubArray(nums, start, end) == target;
    }

    /**
     * Returns the sum of a subarray.
     *
     * @param nums  input array
     * @param start starting index
     * @param end   ending index
     * @return subarray sum
     */
    public int getSumOfSubArray(int[] nums, int start, int end) {

        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }

        return sum;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
