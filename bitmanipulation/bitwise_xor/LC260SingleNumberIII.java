package bitmanipulation.bitwise_xor;

// Created at: 16-July-2026
// Last revised at: 16-July-2026
// Link: https://leetcode.com/problems/single-number-iii/

/*
Problem Description:
--------------------
Statement:
Given an integer array nums where exactly two elements appear only once and
all the other elements appear exactly twice, return the two elements that
appear only once.

The answer can be returned in any order.

Example:
Input:
nums = [1,2,1,3,2,5]

Output:
[3,5]

Constraints:
2 <= nums.length <= 3 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
Exactly two elements appear only once.
*/

/*
Approach 1: HashMap Frequency Count

Idea:
Count the frequency of every number and collect the elements whose frequency
is one.

Time Complexity:
O(n)

Space Complexity:
O(n)

Drawbacks:
Requires additional memory for storing frequencies.
*/

/*
Approach 2: XOR + Rightmost Set Bit (Optimized)

Idea:
XOR all elements together. Duplicate numbers cancel each other, leaving
xor = unique1 ^ unique2.

The rightmost set bit in xor indicates a bit where the two unique numbers
differ. Partition all numbers based on this bit and XOR each partition
independently to recover the two unique numbers.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
Duplicates always fall into the same partition and cancel out, while the two
unique numbers end up in different partitions.
*/

/*
Method to Solve:
----------------
1. XOR every element in the array.
2. Find the rightmost set bit of the XOR result.
3. Divide numbers into two groups using that bit.
4. XOR each group separately.
5. Return the two unique numbers.
*/

public class LC260SingleNumberIII {

    /**
     * Returns the two elements that appear exactly once.
     *
     * @param nums input array
     * @return array containing the two unique numbers
     */
    public int[] singleNumber(int[] nums) {

        int xor = 0;

        // XOR every element
        for (int num : nums) {
            xor ^= num;
        }

        // isolate the rightmost set bit
        int rightMostSetBit = xor & -xor;

        int firstUnique = 0;
        int secondUnique = 0;

        for (int num : nums) {

            // partition based on the set bit
            if ((num & rightMostSetBit) == 0) {
                firstUnique ^= num;
            } else {
                secondUnique ^= num;
            }
        }

        return new int[] { firstUnique, secondUnique };
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
