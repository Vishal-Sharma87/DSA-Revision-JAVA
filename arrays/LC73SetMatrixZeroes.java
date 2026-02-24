public class LC73SetMatrixZeroes {
    public void setZeroes(int[][] m) {
        // link:https://leetcode.com/problems/set-matrix-zeroes/description/
        /*
         * 73. Set Matrix Zeroes
         * Solved
         * Medium
         * Topics
         * premium lock icon
         * Companies
         * Hint
         * Given an m x n integer matrix matrix, if an element is 0, set its entire row
         * and column to 0's.
         * 
         * You must do it in place.
         * 
         * 
         * 
         * Example 1:
         * 
         * 
         * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
         * Output: [[1,0,1],[0,0,0],[1,0,1]]
         * Example 2:
         * 
         * 
         * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
         * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
         * 
         * 
         * Constraints:
         * 
         * m == matrix.length
         * n == matrix[0].length
         * 1 <= m, n <= 200
         * -231 <= matrix[i][j] <= 231 - 1
         * 
         * 
         * Follow up:
         * 
         * A straightforward solution using O(mn) space is probably a bad idea.
         * A simple improvement uses O(m + n) space, but still not the best solution.
         * Could you devise a constant space solution?
         */
        int row = m.length, col = m[0].length;

        boolean firstCol = false, firstRow = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (m[i][j] == 0) {
                    m[i][0] = 0;
                    m[0][j] = 0;

                    if (i == 0)
                        firstRow = true;
                    if (j == 0)
                        firstCol = true;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            if (m[i][0] == 0) {
                // set the whole row as 0
                for (int j = 1; j < col; j++) {
                    m[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < col; i++) {
            if (m[0][i] == 0) {
                // set the whole col as 0
                for (int j = 1; j < row; j++) {
                    m[j][i] = 0;
                }
            }
        }

        if (m[0][0] == 0) {
            if (firstRow) {
                for (int j = 1; j < col; j++) {
                    m[0][j] = 0;
                }
            }
            if (firstCol) {
                for (int j = 1; j < row; j++) {
                    m[j][0] = 0;
                }
            }
        }

    }
}
