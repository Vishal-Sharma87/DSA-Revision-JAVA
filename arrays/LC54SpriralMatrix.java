package arrays;

import java.util.ArrayList;
import java.util.List;

public class LC54SpriralMatrix {
    public List<Integer> spiralOrder(int[][] m) {
        // link:https://leetcode.com/problems/spiral-matrix/description/
        /*
         * 54. Spiral Matrix
         * Solved
         * Medium
         * Topics
         * premium lock icon
         * Companies
         * Hint
         * Given an m x n matrix, return all elements of the matrix in spiral order.
         * 
         * 
         * 
         * Example 1:
         * 
         * 
         * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
         * Output: [1,2,3,6,9,8,7,4,5]
         * Example 2:
         * 
         * 
         * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
         * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
         * 
         * 
         * Constraints:
         * 
         * m == matrix.length
         * n == matrix[i].length
         * 1 <= m, n <= 10
         * -100 <= matrix[i][j] <= 100
         */
        List<Integer> spiral = new ArrayList<Integer>();
        int row = m.length;

        if (row == 0)
            return spiral;

        int col = m[0].length;
        int top = 0, right = col, bottom = row, left = -1;
        int i = 0, j = 0;

        while (top < bottom && left < right) {
            // right
            while (j < right && i < bottom) {
                spiral.add(m[i][j]);
                j++;
            }
            right--;
            i++;
            j--;

            // bottom
            while (i < bottom && j > left) {
                spiral.add(m[i][j]);
                i++;
            }
            bottom--;
            i--;
            j--;

            // left
            while (j > left && i > top) {
                spiral.add(m[i][j]);
                j--;
            }
            left++;
            i--;
            j++;

            // top
            while (i > top && j < right) {
                spiral.add(m[i][j]);
                i--;
            }
            top++;
            i++;
            j++;
        }
        return spiral;
    }
}
