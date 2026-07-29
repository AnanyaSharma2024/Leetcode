class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int dp[][] = new int[height + 1][height + 1];
        // Bottom-Up DP
        for (int i = height - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // Current value + minimum of the two possible paths
                dp[i][j] = triangle.get(i).get(j)
                         + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}