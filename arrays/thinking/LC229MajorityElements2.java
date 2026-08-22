// Created at: 23-August-2026
// Last revised at: 23-August-2026
// Link: https://leetcode.com/problems/majority-element-ii/

package arrays.thinking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Problem Description:
--------------------
Statement:

Given an integer array of size n, return all elements that appear
more than ⌊n / 3⌋ times.

Examples:

Input:
nums = [3,2,3]

Output:
[3]

Input:
nums = [1]

Output:
[1]

Input:
nums = [1,2]

Output:
[1,2]

Constraints:
1 <= nums.length <= 5 * 10^4
-10^9 <= nums[i] <= 10^9

Follow Up:
Can you solve it in O(n) time using O(1) extra space?
*/

/*
Approach 1: Brute Force

Idea:
For every element, count its occurrences by scanning the entire array.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Drawbacks:
Repeatedly counts the same elements.
*/

/*
Approach 2: HashMap (Current Solution)

Idea:
Store the frequency of every element in a HashMap.

The required frequency is:

floor(n / 3) + 1

As soon as an element reaches this frequency, add it to the answer.

There can be at most two such elements, so once two are found, the
traversal can stop.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Insight:
Frequency counting allows majority elements to be detected in a single
pass.
*/

/*
Approach 3: Extended Boyer-Moore Voting Algorithm (Optimal)

Idea:
Since an element must appear more than n/3 times, there can be at most
two majority elements.

Maintain two candidates and their counts while traversing the array,
then verify both candidates in a second pass.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
For an n/3 majority, at most two valid candidates can exist.
*/

/*
Method to Solve:
----------------
1. Compute the required frequency threshold.
2. Traverse the array and count frequencies using a HashMap.
3. When an element reaches the threshold, add it to the answer.
4. Stop after finding two majority elements.
5. Return the result.
*/

public class LC229MajorityElements2 {

    /**
     * Returns all elements occurring more than floor(n / 3) times.
     *
     * @param nums input array
     * @return list of majority elements
     */
    public List<Integer> majorityElement(int[] nums) {

        HashMap<Integer, Integer> elementToOccurrence = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        int threshold = nums.length / 3 + 1;

        for (int num : nums) {

            int occurrence = elementToOccurrence.getOrDefault(num, 0) + 1;
            elementToOccurrence.put(num, occurrence);

            if (occurrence == threshold) {
                answer.add(num);

                if (answer.size() == 2) {
                    break;
                }
            }
        }

        return answer;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
