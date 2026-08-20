package arrays.two_pointer;

// Created at: 21-August-2026
// Last revised at: 21-August-2026
// Link: https://leetcode.com/problems/distribute-elements-into-two-arrays-i/

/*
Problem Description:
--------------------
Statement:
Given an integer array nums, split its elements into two arrays arr1 and arr2.

Initially:
- arr1 contains nums[0]
- arr2 contains nums[1]

For every remaining element nums[i]:
- If the last element of arr1 is greater than the last element of arr2,
  append nums[i] to arr1.
- Otherwise, append nums[i] to arr2.

Return the concatenation of arr1 followed by arr2.

Example:
Input:
nums = [2,1,3,3]

Output:
[2,3,1,3]

Explanation:
arr1 = [2]
arr2 = [1]

3 > 1, so 3 is added to arr1.
3 is not greater than 3, so it is added to arr2.

Final:
arr1 = [2,3]
arr2 = [1,3]

Constraints:
- 2 <= nums.length <= 100
- 1 <= nums[i] <= 100
*/

/*
Approach 1: Brute Force

Idea:
Maintain two separate dynamic arrays and append each element to the
appropriate array based on the last elements of the two arrays.

Time Complexity:
O(n)

Space Complexity:
O(n)

Drawbacks:
Requires additional dynamic-array structures for arr1 and arr2.
*/

/*
Approach 2: Two Pointers with One Result Array

Idea:
Use a single result array.

- Store arr1 from the beginning of result.
- Store arr2 from the end of result.
- first points to the last element of arr1.
- second points to the last element of arr2.
- Compare result[first] and result[second] for each new element.
- After processing all elements, reverse the arr2 portion so that it
  appears in its original order.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Insight:
The second array is built from right to left. This avoids shifting
elements while still allowing both arrays to share one result array.
*/
public class LC3069DistributeElementsIntoTwoArraysI {

    /*
     * Method to Solve:
     * ----------------
     * 1. Initialize pointers for the two arrays inside result.
     * 2. Place nums[0] in the first array and nums[1] in the second array.
     * 3. Compare the last elements of both arrays for every remaining value.
     * 4. Append the value to the appropriate side of result.
     * 5. Reverse the second-array portion to restore its order.
     * 6. Return result.
     */

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    /**
     * Distributes the elements of nums into two arrays according to
     * the comparison of their last elements and returns their concatenation.
     *
     * @param nums input array of integers
     * @return concatenation of the two constructed arrays
     */
    public int[] resultArray(int[] nums) {
        int length = nums.length;

        int[] result = new int[length];
        int first = 0;
        int second = length - 1;

        result[first] = nums[0];
        result[second] = nums[1];

        for (int i = 2; i < length; i++) {
            if (result[first] > result[second]) {
                first++;
                result[first] = nums[i];
            } else {
                second--;
                result[second] = nums[i];
            }
        }

        int index = length - 1;

        // restore the second array's order
        while (second < index) {
            int temp = result[second];
            result[second] = result[index];
            result[index] = temp;

            second++;
            index--;
        }

        return result;
    }
}