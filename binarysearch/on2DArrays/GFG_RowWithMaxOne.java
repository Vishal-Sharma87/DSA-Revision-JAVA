
public class GFG_RowWithMaxOne {

    // Created at: March 8, 2026
    // // Last revised at: March 8, 2026
    // // Link: GeeksforGeeks - Row with max 1s
    // /*Problem Description
    // Given a boolean 2D array of $n \times m$ dimensions, where each row is sorted, find the 0-based index of the first row that has the maximum number of 1s.Example:Input:mat[][] = [[0, 1, 1, 1],[0, 0, 1, 1],[1, 1, 1, 1],[0, 0, 0, 0]]Output: 2Explanation: Row 2 contains 4 ones, which is the maximum.Constraints:$1 \le n, m \le 10^3$$0 \le mat[i][j] \le 1$*/Method to solve the ProblemThe code implements two strategies. The active one is the Staircase Search (Optimal):Initialize: Start at the top-right corner of the matrix (row = 0, col = m-1).Downwards Movement: We move down until we find a 1. If we find a 1, this row is a candidate for the maximum.Leftwards Movement: Once a 1 is found, we move as far left as possible in that same row to see if we can "beat" the current record of 1s.Repeat: We continue this "staircase" pattern until we either run out of rows or columns.Since the rows are sorted, moving left effectively reduces the threshold for the next row to be considered "better." If the next row doesn't have a 1 at the current col index, it cannot possibly have more 1s than our current best row.Complexity Analysis1. Optimal Approach (Staircase)Time Complexity: $O(n + m)$We traverse at most $n$ rows and $m$ columns. In the worst case, we touch each row and each column once.Space Complexity: $O(1)$We only use a few integer variables for tracking indices.2. Better Approach (Binary Search - Commented Out)Time Complexity: $O(n \log m)$We perform a Binary Search ($O(\log m)$) for every row ($n$).Space Complexity: $O(1)$Code ImplementationJavapackage binarysearch.on2DArrays;


    /**
     * Finds the first occurrence of 1 in a sorted binary array using Binary Search.
     * Used in the O(N log M) approach.
     */
    public int firstOccurrenceOfOne(int[] binary) {
        int low = 0;
        int high = binary.length - 1;
        if (high < 0) return -1;

        int firstIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (binary[mid] == 1) {
                firstIndex = mid;
                high = mid - 1; // Look for an even earlier 1
            } else {
                low = mid + 1;
            }
        }
        return firstIndex;
    }

    /**
     * Finds the row with the maximum number of 1s using the Staircase Approach.
     */
    public int rowWithMax1s(int mat[][]) {
        int n = mat.length;
        if (n <= 0) return -1;
        int m = mat[0].length;

        int index = -1;
        int row = 0;
        int col = m - 1; // Start from top-right

        while (row < n && col >= 0) {
            // Check if current row can improve our 'col' boundary
            boolean foundOneInRow = false;
            
            while (col >= 0 && mat[row][col] == 1) {
                foundOneInRow = true;
                index = row; // This row is now our best candidate
                col--;       // Move left to try and find more 1s
            }
            row++; // Move to the next row
        }

        return index;
    }
}