// tried this but ofc this was not how it was supposed to be the minimum path sum possible not take the next minimum possible in sum

// class MinimumtriangleSum {
//     public int minimumTotal(List<List<Integer>> triangle) {
//          int n = triangle.size();
//         // Copy the last row as our initial DP array
//         int[] dp = new int[n];
//         for (int i = 0; i < n; i++) {
//             dp[i] = triangle.get(n - 1).get(i);
//         }

//         // Start from the second-last row and move upwards
//         for (int row = n - 2; row >= 0; row--) {
//             for (int col = 0; col <= row; col++) {
//                 dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
//             }
//         }

//         // The top element now contains the minimum path sum
//         return dp[0];
//     }
// }


// so ofc gpt gave the right one

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
         int n = triangle.size();
        // Copy the last row as our initial DP array
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Start from the second-last row and move upwards
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        // The top element now contains the minimum path sum
        return dp[0];
    }
}
