package arrays.traversal;

// Created at: 21 August 2026
// Last revised at: 21 August 2026
// Link: https://leetcode.com/problems/max-consecutive-ones/

/*
Problem Description:
--------------------
Statement:
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example:
Input:
nums = [1,1,0,1,1,1]

Output:
3

Constraints:
- 1 <= nums.length <= 10^5
- nums[i] is either 0 or 1.
*/

/*
Approach 1: Brute Force

Idea:
For every index containing 1, continue scanning until a 0 is found and compute
the length of that consecutive block.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Drawbacks:
The same elements may be scanned multiple times, making it inefficient.
*/

/*
Approach 2: Linear Traversal (Optimal)

Idea:
Traverse the array once while maintaining the current streak of consecutive 1's.
Reset the streak whenever a 0 is encountered and update the maximum streak.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
Only the current streak and the best answer are required, allowing a single-pass solution.
*/

/*
Method to Solve:
----------------
1. Initialize current streak and maximum streak.
2. Traverse the array once.
3. Increment the streak for every 1.
4. Reset the streak when a 0 is encountered.
5. Return the maximum streak found.
*/

// Time Complexity: O(n)
// Space Complexity: O(1)

public class LC485MaxConsecutiveOnes {

    /**
     * Finds the maximum number of consecutive ones.
     *
     * @param nums binary input array
     * @return maximum consecutive ones
     */
    public int findMaxConsecutiveOnes(int[] nums) {

        int currentStreak = 0;
        int maximumStreak = 0;

        for (int value : nums) {

            if (value == 1) {
                currentStreak++;
                maximumStreak = Math.max(maximumStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }

        return maximumStreak;
    }
}