class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        // Include first, exclude last
        int arr1[] = new int[n - 1];
        for(int i = 0; i < n - 1; i++) {
            arr1[i] = nums[i];
        }
        // Exclude first, include last
        int arr2[] = new int[n - 1];
        for(int i = 1; i < n; i++) {
            arr2[i - 1] = nums[i];
        }
        int case1 = helper(arr1);
        int case2 = helper(arr2);
        return Math.max(case1, case2);
    }
    //same robber 1 ka code hai yeh wala
    public int helper(int[] nums) {
        if(nums.length < 2) return nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}