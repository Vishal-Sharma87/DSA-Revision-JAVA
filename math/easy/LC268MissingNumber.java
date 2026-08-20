// Created at: 21 August 2026
// Last revised at: 21 August 2026
// Link: https://leetcode.com/problems/missing-number/

/*
Problem Description:
--------------------
Statement:
Given an array containing n distinct numbers in the range [0, n], return the
only number in the range that is missing from the array.

Example:
Input:
nums = [3, 0, 1]

Output:
2

Constraints:
- n == nums.length
- 1 <= n <= 10^4
- 0 <= nums[i] <= n
- All numbers are unique.
*/

/*
Approach 1: Sorting

Idea:
Sort the array and compare each index with its corresponding value.
The first mismatch indicates the missing number.

Time Complexity:
O(n log n)

Space Complexity:
O(1) or O(log n) depending on the sorting algorithm.

Drawbacks:
Sorting modifies the array and is slower than necessary.
*/

/*
Approach 2: Hashing

Idea:
Store all numbers in a boolean array or HashSet and scan from 0 to n
to find the missing value.

Time Complexity:
O(n)

Space Complexity:
O(n)

Drawbacks:
Requires additional memory.
*/

/*
Approach 3: Mathematical Sum (Optimal)

Idea:
Compute the expected sum of numbers from 0 to n using the arithmetic
series formula. Subtract every array element from this sum. The remaining
value is the missing number.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
Since exactly one number is missing, the difference between the expected
sum and the actual sum directly gives the answer.
*/

/*
Method to Solve:
----------------
1. Compute the expected sum from 0 to n.
2. Traverse the array.
3. Subtract every element from the expected sum.
4. Return the remaining value.
*/

// Time Complexity: O(n)
// Space Complexity: O(1)

package math.easy;

public class LC268MissingNumber {

    /**
     * Finds the missing number in the range [0, n].
     *
     * @param nums input array containing distinct numbers
     * @return the missing number
     */
    public int find(int[] nums) {

        int n = nums.length;

        // expected sum from 0 to n
        int expectedSum = n * (n + 1) / 2;

        // subtract every existing number
        for (int value : nums) {
            expectedSum -= value;
        }

        return expectedSum;
    }
}