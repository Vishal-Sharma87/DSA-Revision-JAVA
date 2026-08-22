// Created at: 24-Jan-2026
// Last revised at: 24-Jan-2026
// Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/

package arrays.traversal;

/*
Problem Description:
--------------------
Statement:

Given an array containing an equal number of positive and negative
integers, rearrange the array such that:

1. The first element is positive.
2. Positive and negative numbers alternate.
3. The relative order among positive numbers is preserved.
4. The relative order among negative numbers is preserved.

Return the rearranged array.

Examples:

Input:
nums = [3,1,-2,-5,2,-4]

Output:
[3,-2,1,-5,2,-4]

Input:
nums = [-1,1]

Output:
[1,-1]

Constraints:
2 <= nums.length <= 2 * 10^5
nums.length is even
nums contains equal numbers of positive and negative integers.
*/

/*
Approach 1: Partition Then Merge

Idea:
First separate all positive and negative numbers into two contiguous
halves of an auxiliary array while preserving their order.

Then alternately copy one positive and one negative element back into
the original array.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Insight:
Separating both groups first makes alternating them straightforward.
*/

/*
Approach 2: Direct Placement (Optimal)

Idea:
Create one answer array.

Maintain:

- even index for positive numbers
- odd index for negative numbers

Traverse the original array once and directly place every element into
its final position.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Insight:
Since the final positions are already known, partitioning is unnecessary.
*/

/*
Method to Solve:
----------------
1. Store all positive numbers in the first half of a temporary array.
2. Store all negative numbers in the second half.
3. Traverse both halves simultaneously.
4. Alternately copy positive and negative numbers back into the original array.
5. Return the modified array.
*/

public class LC2149RearrangeArrayBySign {

    /**
     * Rearranges the array so that positive and negative numbers
     * appear alternately while preserving their relative order.
     *
     * @param nums input array
     * @return rearranged array
     */
    public int[] rearrangeArray(int[] nums) {

        int length = nums.length;

        int[] partitionBySign = new int[length];

        int positiveIndex = 0;
        int negativeIndex = length / 2;

        // partition positives and negatives
        for (int num : nums) {

            if (num >= 0) {
                partitionBySign[positiveIndex++] = num;
            } else {
                partitionBySign[negativeIndex++] = num;
            }
        }

        positiveIndex = 0;
        negativeIndex = length / 2;

        int index = 0;

        // merge alternately
        while (index < length) {
            nums[index++] = partitionBySign[positiveIndex++];
            nums[index++] = partitionBySign[negativeIndex++];
        }

        return nums;
    }

    /**
     * Rearranges the array so that positive and negative numbers
     * appear alternately while preserving their relative order.
     *
     * @param nums input array
     * @return rearranged array
     */
    public int[] rearrangeArrayOptimal(int[] nums) {

        int[] result = new int[nums.length];

        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int num : nums) {

            if (num > 0) {
                result[positiveIndex] = num;
                positiveIndex += 2;
            } else {
                result[negativeIndex] = num;
                negativeIndex += 2;
            }
        }

        return result;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
}

// Time Complexity: O(n)
// Space Complexity: O(n)