package bitmanipulation.bitwise_xor;

// Created at: 14-July-2026
// Last revised at: 14-July-2026
// Link: https://leetcode.com/problems/single-number/

/*
Problem Description:
--------------------
Statement:
Given a non-empty integer array where every element appears exactly twice
except for one element, find that single element.

You must implement a solution with linear runtime complexity and use only
constant extra space.

Example:
Input:
nums = [2,2,1]

Output:
1

Example:
Input:
nums = [4,1,2,1,2]

Output:
4

Constraints:
1 <= nums.length <= 3 * 10^4
-3 * 10^4 <= nums[i] <= 3 * 10^4
Each element appears twice except for one.
*/

/*
Approach 1: XOR Cancellation

Idea:
XOR every number in the array.

Properties of XOR:
1. x ^ x = 0
2. x ^ 0 = x
3. XOR is commutative and associative.

Since every duplicated element cancels itself out, only the unique element
remains.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
Duplicate numbers eliminate each other through XOR, leaving only the element
that appears once.
*/

public class LC136SingleNumber {

    /*
     * Method to Solve:
     * ----------------
     * 1. Initialize the XOR accumulator to 0.
     * 2. XOR every element in the array.
     * 3. Return the final XOR value.
     */

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    /**
     * Finds the element that appears exactly once.
     *
     * @param nums input array
     * @return the unique element
     */
    public int singleNumber(int[] nums) {

        int xor = 0;

        // cancel duplicate numbers
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}