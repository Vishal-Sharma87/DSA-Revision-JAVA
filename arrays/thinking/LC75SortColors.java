// Created at: 23-August-2026
// Last revised at: 23-August-2026
// Link: https://leetcode.com/problems/sort-colors/

/*
Problem Description:
--------------------
Statement:
Given an integer array nums containing only 0s, 1s, and 2s, sort the array
in-place so that objects of the same color are adjacent in the order:
0 (Red), 1 (White), and 2 (Blue).

You must solve the problem without using the library's sort function.

Example:
Input:
nums = [2,0,2,1,1,0]

Output:
[0,0,1,1,2,2]

Constraints:
- 1 <= nums.length <= 300
- nums[i] is either 0, 1, or 2
*/

/*
Approach 1: Counting Sort

Idea:
Count the occurrences of 0, 1, and 2, then overwrite the array accordingly.

Time Complexity:
O(n)

Space Complexity:
O(1)

Drawbacks:
Requires two passes over the array.
*/

/*
Approach 2: Dutch National Flag Algorithm (Optimal)

Idea:
Maintain three pointers:
- left: next position for 0
- mid: current element
- right: next position for 2

Process each element once:
- If current is 0, swap with left and move both pointers.
- If current is 1, simply move mid.
- If current is 2, swap with right and decrease right without moving mid.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
Each element is processed at most once, giving a one-pass in-place solution.
*/

/*
Method to Solve:
----------------
1. Initialize left, mid, and right pointers.
2. Traverse while mid <= right.
3. Place 0s to the left.
4. Place 2s to the right.
5. Leave 1s in the middle.
*/

package arrays.thinking;

public class LC75SortColors {

    /**
     * Sorts the array containing only 0, 1, and 2 using the
     * Dutch National Flag algorithm.
     *
     * @param nums input array
     * @return void
     */
    public void sort(int[] nums) {

        int length = nums.length;

        if (length <= 1) {
            return;
        }

        int left = 0;
        int mid = 0;
        int right = length - 1;

        while (mid <= right) {

            if (nums[mid] == 0) {

                swap(nums, left, mid);
                left++;
                mid++;

            } else if (nums[mid] == 2) {

                swap(nums, mid, right);
                right--;

            } else {

                mid++;
            }
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * @param nums   input array
     * @param first  first index
     * @param second second index
     * @return void
     */
    private void swap(int[] nums, int first, int second) {

        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
}