// Created at: 23-August-2026
// Last revised at: 23-August-2026
// Link: https://leetcode.com/problems/rotate-image/

/*
Problem Description:
--------------------
Statement:
You are given an n × n matrix representing an image. Rotate the image by
90 degrees clockwise.

The rotation must be performed in-place without allocating another matrix.

Example:
Input:
matrix = [[1,2,3],
          [4,5,6],
          [7,8,9]]

Output:
[[7,4,1],
 [8,5,2],
 [9,6,3]]

Constraints:
- n == matrix.length == matrix[i].length
- 1 <= n <= 20
- -1000 <= matrix[i][j] <= 1000
*/

/*
Approach 1: Extra Matrix

Idea:
Create another matrix and place every element into its rotated position.

Time Complexity:
O(n²)

Space Complexity:
O(n²)

Drawbacks:
Requires an additional matrix, violating the in-place requirement.
*/

/*
Approach 2: Transpose + Reverse Each Row (Optimal)

Idea:
1. Transpose the matrix.
2. Reverse every row.

The transpose converts rows into columns, and reversing each row completes
the clockwise rotation.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Key Insight:
A 90° clockwise rotation can be decomposed into transpose followed by row reversal.
*/

/*
Method to Solve:
----------------
1. Transpose the matrix.
2. Reverse every row.
3. Return the modified matrix.
*/

package arrays.matrix;

public class LC48RotateMatrix {

    /**
     * Rotates the matrix by 90 degrees clockwise in-place.
     *
     * @param matrix input matrix
     * @return void
     */
    public void rotate(int[][] matrix) {

        int size = matrix.length;

        if (size <= 1) {
            return;
        }

        // transpose
        for (int row = 1; row < size; row++) {

            for (int col = 0; col < row; col++) {

                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // reverse every row
        for (int row = 0; row < size; row++) {
            reverseRow(matrix[row], 0, size - 1);
        }
    }

    /**
     * Reverses a row in-place.
     *
     * @param row   input row
     * @param left  starting index
     * @param right ending index
     * @return void
     */
    private void reverseRow(int[] row, int left, int right) {

        while (left < right) {

            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;

            left++;
            right--;
        }
    }

    // Time Complexity: O(n²)
    // Space Complexity: O(1)
}