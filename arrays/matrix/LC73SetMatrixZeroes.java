// Created at: 23-August-2026
// Last revised at: 23-August-2026
// Link: https://leetcode.com/problems/set-matrix-zeroes/

/*
Problem Description:
--------------------
Statement:
Given an m × n integer matrix, if an element is 0, set its entire row and
column to 0. The operation must be performed in-place.

Example:
Input:
matrix = [[1,1,1],
          [1,0,1],
          [1,1,1]]

Output:
[[1,0,1],
 [0,0,0],
 [1,0,1]]

Constraints:
- m == matrix.length
- n == matrix[0].length
- 1 <= m, n <= 200
- -2³¹ <= matrix[i][j] <= 2³¹ - 1
*/

/*
Approach 1: Extra Row & Column Arrays

Idea:
Maintain two boolean arrays to remember which rows and columns should become zero.

Time Complexity:
O(m × n)

Space Complexity:
O(m + n)

Drawbacks:
Uses additional memory proportional to the number of rows and columns.
*/

/*
Approach 2: First Row & First Column as Markers (Optimal)

Idea:
Use the first row and first column to store marker information.
Two additional boolean variables track whether the original first row or
first column should be zeroed.

Time Complexity:
O(m × n)

Space Complexity:
O(1)

Key Insight:
The first row and first column act as marker arrays, eliminating the need
for extra space.
*/

/*
Method to Solve:
----------------
1. Scan the matrix and mark affected rows and columns using the first row and first column.
2. Track whether the first row and first column originally contain a zero.
3. Zero marked rows.
4. Zero marked columns.
5. Finally update the first row and first column if required.
*/

package arrays.matrix;

public class LC73SetMatrixZeroes {

    /**
     * Sets entire rows and columns to zero whenever a zero is found.
     *
     * @param matrix input matrix
     * @return void
     */
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // store markers
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == 0) {

                    matrix[row][0] = 0;
                    matrix[0][col] = 0;

                    if (row == 0) {
                        firstRowZero = true;
                    }

                    if (col == 0) {
                        firstColZero = true;
                    }
                }
            }
        }

        // zero marked rows
        for (int row = 1; row < rows; row++) {

            if (matrix[row][0] == 0) {

                for (int col = 1; col < cols; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // zero marked columns
        for (int col = 1; col < cols; col++) {

            if (matrix[0][col] == 0) {

                for (int row = 1; row < rows; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // update first row
        if (firstRowZero) {

            for (int col = 0; col < cols; col++) {
                matrix[0][col] = 0;
            }
        }

        // update first column
        if (firstColZero) {

            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }
    }

    // Time Complexity: O(m × n)
    // Space Complexity: O(1)
}