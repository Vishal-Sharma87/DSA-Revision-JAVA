// Created at: 27-Jan-2026
// Last revised at: 27-Jan-2026
// Link: https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

package math.advanced;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Problem Description:
--------------------
Statement:

Given an unsorted array of size n containing numbers from 1 to n,
exactly one number appears twice and exactly one number is missing.

Return the repeating number followed by the missing number.

Examples:

Input:
arr = [2, 2]

Output:
[2, 1]

Input:
arr = [1, 3, 3]

Output:
[3, 2]

Input:
arr = [4, 3, 6, 2, 1, 1]

Output:
[1, 5]

Constraints:
2 <= n <= 10^6
1 <= arr[i] <= n
*/

/*
Approach 1: Brute Force

Idea:
For every value from 1 to n, count its frequency by traversing the
entire array.

The element with frequency 2 is repeating, while the element with
frequency 0 is missing.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Drawbacks:
Repeatedly scans the entire array.
*/

/*
Approach 2: HashSet (Better)

Idea:
Traverse the array once.

- If an element already exists in the HashSet, it is the repeating number.
- Otherwise, insert it into the set.

Finally, iterate from 1 to n and find the number that is absent from
the HashSet.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Insight:
The HashSet allows duplicate detection in constant time while also
tracking every unique value present in the array.
*/

/*
Approach 3: Mathematical Formula (Optimal Space)

Idea:
Use the expected sum and sum of squares of numbers from 1 to n to form
two equations involving the missing and repeating numbers.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
Eliminates the need for any extra data structure by using arithmetic
relationships.
*/

/*
Method to Solve:
----------------
1. Traverse the array and insert each element into a HashSet.
2. If an element already exists, record it as the repeating number.
3. Iterate from 1 to n.
4. The first value absent from the HashSet is the missing number.
5. Return both values.
*/

public class GFG_FindMissingAndRepeatingNumber {

    /**
     * Finds the repeating and missing numbers.
     *
     * @param nums input array
     * @return list containing [repeating, missing]
     */
    public ArrayList<Integer> findTwoElement(int[] nums) {

        int repeating = -1;
        int missing = -1;

        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {

            if (seen.contains(num)) {
                repeating = num;
            } else {
                seen.add(num);
            }
        }

        for (int value = 1; value <= nums.length; value++) {

            if (!seen.contains(value)) {
                missing = value;
                break;
            }
        }

        return new ArrayList<>(List.of(repeating, missing));
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
