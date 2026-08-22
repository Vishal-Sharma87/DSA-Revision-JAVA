// Created at: 23-August-2026
// Last revised at: 23-August-2026
// Link: https://leetcode.com/problems/-consecutive-sequence/

package arrays.thinking;

import java.util.HashMap;
import java.util.HashSet;

/*
Problem Description:
--------------------
Statement:

Given an unsorted array of integers, return the length of the longest
consecutive sequence.

The algorithm must run in O(n) time.

Examples:

Input:
nums = [100,4,200,1,3,2]

Output:
4

Explanation:
The longest consecutive sequence is:
[1,2,3,4]

Input:
nums = [0,3,7,2,5,8,4,6,0,1]

Output:
9

Input:
nums = [1,0,1,2]

Output:
3

Constraints:
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
*/

/*
Approach 1: Brute Force

Idea:
For every element, repeatedly search for the next consecutive value
inside the array.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Drawbacks:
Repeatedly searches the same values.
*/

/*
Approach 2: HashMap + Visited (Current Solution)

Idea:
Store every value and its index inside a HashMap.

Start from every unvisited element and expand in both directions.

Mark every visited index so that an entire sequence is processed only
once.

Time Complexity:
O(n) Average

Space Complexity:
O(n)

Drawbacks:
Requires both a HashMap and a visited array.
Duplicate values overwrite previous indices, making the implementation
more complex than necessary.
*/

/*
Approach 3: HashSet Sequence Starter (Optimal)

Idea:
Insert every value into a HashSet.

Only begin expanding from numbers whose previous value does not exist.

If (num - 1) is absent, then num is the first element of a sequence.

Expand only in the positive direction.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Insight:
Every sequence is traversed exactly once.
No visited array is required.
*/

/*
Method to Solve:
----------------
1. Insert every value into a HashSet.
2. Iterate through every unique value.
3. Start expanding only if the previous value is absent.
4. Count consecutive values.
5. Return the maximum sequence length.
*/

public class LC128LongestConsecutiveSequence {

    /**
     * Expands in one direction while counting consecutive values.
     *
     * @param visited      visited indices
     * @param valueToIndex value to index map
     * @param value        starting value
     * @param forward      true for increasing direction
     * @return consecutive count
     */
    private int getCount(boolean[] visited,
            HashMap<Integer, Integer> valueToIndex,
            int value,
            boolean forward) {

        int count = 0;

        Integer index = valueToIndex.get(value);

        while (index != null && !visited[index]) {

            visited[index] = true;
            count++;

            value = forward ? value + 1 : value - 1;
            index = valueToIndex.get(value);
        }

        return count;
    }

    /**
     * HashMap + Visited solution.
     *
     * @param nums input array
     * @return longest consecutive sequence length
     */
    public int longestConsecutive(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        boolean[] visited = new boolean[nums.length];
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            valueToIndex.put(nums[i], i);
        }

        int longest = 1;

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            int positive = getCount(visited, valueToIndex, nums[i] + 1, true);

            int negative = getCount(visited, valueToIndex, nums[i] - 1, false);

            longest = Math.max(longest, 1 + positive + negative);
        }

        return longest;
    }

    /**
     * Optimal HashSet solution.
     *
     * @param nums input array
     * @return longest consecutive sequence length
     */
    public int longestConsecutiveOptimal(int[] nums) {

        HashSet<Integer> values = new HashSet<>();

        for (int num : nums) {
            values.add(num);
        }

        int longest = 0;

        for (int num : values) {

            // beginning of a sequence
            if (!values.contains(num - 1)) {

                int current = num;
                int length = 1;

                while (values.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)