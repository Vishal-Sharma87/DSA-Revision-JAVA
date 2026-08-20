// Created at: 11-January-2026
// Last revised at: 21-August-2026
// Link: https://leetcode.com/problems/pascals-triangle/description/

package arrays.thinking;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description:
--------------------
Statement:
Given an integer numRows, return the first numRows of Pascal's Triangle.

Each number is the sum of the two numbers directly above it.
The first and last element of every row is always 1.

Example:
Input: numRows = 5
Output:
[
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
]

Input: numRows = 1
Output:
[[1]]

Constraints:
- 1 <= numRows <= 30
*/

/*
Approach 1: Memoization

Idea:
Generate the first (n - 1) rows recursively and build the nth row
from the last generated row.

Time Complexity:
O(n²)

Space Complexity:
O(n²)

Drawbacks:
Uses recursion and additional memoization storage without improving
the overall complexity.
*/

/*
Approach 2: Tabulation

Idea:
Store every intermediate state and build each row iteratively.

Time Complexity:
O(n²)

Space Complexity:
O(n²)

Key Insight:
Removes recursion but still stores every intermediate DP state.
*/

/*
Approach 3: Iterative Construction (Optimal)

Idea:
Start with the first row [1].
Each new row is generated using only the previous row.

- First and last elements remain 1.
- Middle elements are the sum of two adjacent values
  from the previous row.

Time Complexity:
O(n²)

Space Complexity:
O(n²)

Key Insight:
Only the previously generated row is required to construct the next row.
The returned triangle itself occupies O(n²) space.
*/

/*
Method to Solve:
----------------
1. Initialize the answer with the first row.
2. Repeat until numRows rows are generated.
3. Construct the next row using the previous row.
4. Append the newly generated row.
5. Return the complete triangle.
*/

public class LC118PascalsTriangle {

    /**
     * Generates the first numRows of Pascal's Triangle.
     *
     * @param numRows number of rows
     * @return Pascal's Triangle
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(1)));

        for (int row = 2; row <= numRows; row++) {

            List<Integer> previous = triangle.get(triangle.size() - 1);
            List<Integer> current = new ArrayList<>();

            for (int col = 0; col < row; col++) {

                int value = 0;

                // left parent
                if (col - 1 >= 0) {
                    value += previous.get(col - 1);
                }

                // right parent
                if (col < previous.size()) {
                    value += previous.get(col);
                }

                current.add(value);
            }

            triangle.add(current);
        }

        return triangle;
    }
}

// Time Complexity: O(n²)
// Space Complexity: O(n²)