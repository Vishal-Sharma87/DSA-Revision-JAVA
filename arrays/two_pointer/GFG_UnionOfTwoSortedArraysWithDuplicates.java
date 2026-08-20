// Created at: 21 August 2026
// Last revised at: 21 August 2026
// Link: https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-with-duplicate-elements/

package arrays.two_pointer;

import java.util.ArrayList;

/*
Problem Description:
--------------------
Statement:
Given two sorted arrays that may contain duplicate elements, return the union of
both arrays. The resulting union should contain only distinct elements and must
remain sorted.

Example:
Input:
a = [1, 2, 2, 3, 4]
b = [2, 3, 5]

Output:
[1, 2, 3, 4, 5]

Constraints:
- Both arrays are sorted in non-decreasing order.
- Arrays may contain duplicate values.
*/

/*
Approach 1: Using HashSet

Idea:
Insert all elements from both arrays into a HashSet and then sort the result.

Time Complexity:
O((n + m) log(n + m))

Space Complexity:
O(n + m)

Drawbacks:
Extra space is required and sorting is needed after insertion.
*/

/*
Approach 2: Two Pointer Traversal (Optimal)

Idea:
Traverse both sorted arrays simultaneously using two pointers.
Always insert the smaller element into the answer while avoiding duplicates.
If both elements are equal, insert only once and move both pointers.
Finally, process any remaining elements.

Time Complexity:
O(n + m)

Space Complexity:
O(1) Auxiliary Space
(Excluding the output list)

Key Insight:
Since both arrays are already sorted, duplicate removal can be handled by simply
comparing the current value with the last inserted value.
*/

/*
Method to Solve:
----------------
1. Initialize two pointers for both arrays.
2. Compare the current elements.
3. Insert the smaller element if it is not already present.
4. If both elements are equal, insert once and move both pointers.
5. Add the remaining elements from either array while skipping duplicates.
*/

// Time Complexity: O(n + m)
// Space Complexity: O(1) Auxiliary Space

public class GFG_UnionOfTwoSortedArraysWithDuplicates {

    /**
     * Returns the union of two sorted arrays.
     *
     * @param first  first sorted array
     * @param second second sorted array
     * @return union containing unique sorted elements
     */
    public ArrayList<Integer> getUnion(int[] first, int[] second) {
        ArrayList<Integer> union = new ArrayList<>();

        if (first.length == 0 && second.length == 0) {
            return union;
        }

        int i = 0;
        int j = 0;

        while (i < first.length && j < second.length) {

            if (first[i] == second[j]) {
                insertIfUnique(union, first[i]);
                i++;
                j++;
            } else if (first[i] < second[j]) {
                insertIfUnique(union, first[i]);
                i++;
            } else {
                insertIfUnique(union, second[j]);
                j++;
            }
        }

        // process remaining elements
        while (i < first.length) {
            insertIfUnique(union, first[i]);
            i++;
        }

        while (j < second.length) {
            insertIfUnique(union, second[j]);
            j++;
        }

        return union;
    }

    /**
     * Inserts a value only if it is different from the last inserted value.
     *
     * @param union result list
     * @param value current value
     * @return void
     */
    private void insertIfUnique(ArrayList<Integer> union, int value) {
        if (union.isEmpty() || union.get(union.size() - 1) != value) {
            union.add(value);
        }
    }
}