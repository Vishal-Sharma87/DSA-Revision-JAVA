package arrays;

import java.util.ArrayList;
import java.util.List;

public class LC118PascalsTriangle {

    public List<List<Integer>> generate(int n) {

        // link :https://leetcode.com/problems/pascals-triangle/description/

        /*
         * 118. Pascal's Triangle
         * Given an integer numRows, return the first numRows of Pascal's triangle.
         * 
         * In Pascal's triangle, each number is the sum of the two numbers directly
         * above it as shown:
         * 
         * 
         * 
         * 
         * Example 1:
         * 
         * Input: numRows = 5
         * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
         * Example 2:
         * 
         * Input: numRows = 1
         * Output: [[1]]
         * 
         * 
         * Constraints:
         * 
         * 1 <= numRows <= 30
         */
        /*
         * MEMOIZED
         * // private List<List<Integer>> pascals(int n, List<List<Integer>>[] dp) {
         * // if (n == 1) {
         * // return dp[1] =
         * // }
         * 
         * // if (dp[n] != null)
         * // return dp[n];
         * 
         * // List<List<Integer>> ans = pascals(n - 1, dp);
         * 
         * // int back = ans.size() - 1;
         * 
         * // List<Integer> temp = new ArrayList<>();
         * 
         * // for (int i = 0; i < n; i++) {
         * // int val = 0;
         * // if (i <= back)
         * // val += ans.get(back).get(i);
         * // if (i - 1 >= 0)
         * // val += ans.get(back).get(i - 1);
         * // temp.add(val);
         * // }
         * // ans.add(temp);
         * 
         * // return dp[n] = ans;
         * // }
         */

        /*
         * TABULATED
         * 
         * 
         * List<List<Integer>>[] dp = new ArrayList[n + 1];
         * 
         * dp[1] = new ArrayList<>(List.of(new ArrayList<>(List.of(1))));
         * 
         * for (int j = 2; j <= n; j++) {
         * List<List<Integer>> ans = dp[j - 1];
         * 
         * int back = ans.size() - 1;
         * 
         * List<Integer> temp = new ArrayList<>();
         * 
         * for (int i = 0; i < j; i++) {
         * int val = 0;
         * if (i <= back)
         * val += ans.get(back).get(i);
         * if (i - 1 >= 0)
         * val += ans.get(back).get(i - 1);
         * temp.add(val);
         * }
         * ans.add(temp);
         * 
         * dp[j] = ans;
         * }
         * 
         * return dp[n];
         */

        // SPACE OPTIMIZED
        List<List<Integer>> dp = new ArrayList<>(List.of(new ArrayList<>(List.of(1))));

        for (int j = 2; j <= n; j++) {

            int back = dp.size() - 1;

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < j; i++) {
                int val = 0;
                if (i <= back)
                    val += dp.get(back).get(i);
                if (i - 1 >= 0)
                    val += dp.get(back).get(i - 1);
                temp.add(val);
            }
            dp.add(temp);
        }

        return dp;
    }
}
