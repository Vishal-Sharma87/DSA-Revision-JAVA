// Created at: 23-August-2026
// Last revised at: 23-August-2026
// Link: https://leetcode.com/problems/spiral-matrix/

/*
Problem Description:
--------------------
Statement:
Given an m x n matrix, return all elements of the matrix in spiral order.

Example:
Input:
matrix = [[1,2,3],
          [4,5,6],
          [7,8,9]]

Output:
[1,2,3,6,9,8,7,4,5]

Constraints:
- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 10
- -100 <= matrix[i][j] <= 100
*/

/*
Approach 1: Simulation with Visited Matrix

Idea:
Simulate movement in four directions while marking visited cells.
Whenever a boundary or visited cell is encountered, rotate the direction.

Time Complexity:
O(m × n)

Space Complexity:
O(m × n)

Drawbacks:
Requires an additional visited matrix.
*/

/*
Approach 2: Boundary Traversal (Optimal)

Idea:
Maintain four boundaries:
- top
- bottom
- left
- right

Traverse:
1. Left to Right
2. Top to Bottom
3. Right to Left
4. Bottom to Top

Shrink the corresponding boundary after every traversal and continue until
all elements are visited.

Time Complexity:
O(m × n)

Space Complexity:
O(1) (excluding the output list)

Key Insight:
Instead of tracking visited cells, continuously shrink the active rectangle.
*/

/*
Method to Solve:
----------------
1. Initialize top, bottom, left, and right boundaries.
2. Traverse the top row.
3. Traverse the right column.
4. Traverse the bottom row if it exists.
5. Traverse the left column if it exists.
6. Repeat until all boundaries cross.
*/

package arrays.matrix;

import java.util.ArrayList;
import java.util.List;

public class LC54SpiralMatrix {

    /**
     * Returns the elements of the matrix in spiral order.
     *
     * @param matrix input matrix
     * @return spiral traversal
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> spiral = new ArrayList<>();

        int rows = matrix.length;

        if (rows == 0) {
            return spiral;
        }

        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {

            // traverse left to right
            for (int col = left; col <= right; col++) {
                spiral.add(matrix[top][col]);
            }
            top++;

            // traverse top to bottom
            for (int row = top; row <= bottom; row++) {
                spiral.add(matrix[row][right]);
            }
            right--;

            // traverse right to left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    spiral.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // traverse bottom to top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    spiral.add(matrix[row][left]);
                }
                left++;
            }
        }

        return spiral;
    }

    // Time Complexity: O(m × n)
    // Space Complexity: O(1) excluding the output list
}