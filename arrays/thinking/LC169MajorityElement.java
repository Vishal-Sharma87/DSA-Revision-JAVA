// Created at: 12-January-2026
// Last revised at: 21-August-2026
// Link: https://leetcode.com/problems/majority-element/description/

package arrays.thinking;

/*
Problem Description:
--------------------
Statement:
Given an integer array nums of size n, return the majority element.

The majority element is the element that appears more than floor(n / 2) times.
It is guaranteed that a majority element always exists.

Example:
Input: nums = [3,2,3]
Output: 3

Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
- 1 <= nums.length <= 5 * 10^4
- -10^9 <= nums[i] <= 10^9

Follow-up:
Can you solve it in linear time and O(1) space?
*/

/*
Approach 1: Brute Force

Idea:
Count the frequency of every element and return the one whose frequency
is greater than n / 2.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Drawbacks:
Repeated counting makes it inefficient.
*/

/*
Approach 2: HashMap

Idea:
Store the frequency of every element using a HashMap.
Return the element whose count exceeds n / 2.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Insight:
Extra memory helps reduce repeated work.
*/

/*
Approach 3: Boyer-Moore Voting Algorithm (Optimal)

Idea:
Maintain a candidate and a counter.

- If the counter becomes zero, choose the current element as the new candidate.
- Increase the counter when the current element matches the candidate.
- Otherwise decrease the counter.

Since the majority element appears more than half the time, it survives all
pair cancellations and remains the final candidate.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
Pairwise cancellation removes equal numbers of majority and non-majority
elements without affecting the final answer.
*/

/*
Method to Solve:
----------------
1. Assume the first candidate.
2. Traverse the array while maintaining a counter.
3. Reset the candidate whenever the counter becomes zero.
4. Increase or decrease the counter based on matching values.
5. Return the final candidate.
*/

public class LC169MajorityElement {

    /**
     * Finds the majority element using Boyer-Moore Voting Algorithm.
     *
     * @param nums input array
     * @return majority element
     */
    public int find(int[] nums) {

        int major = nums[0];
        int cnt = 0;

        for (int num : nums) {

            // choose a new candidate
            if (cnt == 0) {
                major = num;
                cnt = 1;
            }
            // same candidate
            else if (num == major) {
                cnt++;
            }
            // cancel one occurrence
            else {
                cnt--;
            }
        }

        return major;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)