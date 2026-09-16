class Solution { 
    public int lengthOfLIS(int[] nums) { 
        // Base case: If the input array is empty, the LIS length is 0
        if (nums.length == 0) { 
            return 0; 
        } 
        
        // dp[i] will store the length of the longest increasing subsequence ending at index i
        int dp[] = new int[nums.length]; 
        
        // The first element alone forms a valid subsequence of length 1
        dp[0] = 1; 
        
        // Tracks the overall maximum length found so far
        int ans = 1; 
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < dp.length; i++) { 
            int max = 0; // Tracks the maximum LIS length available from previous valid elements
            
            // Look back at all elements before index i
            for (int j = 0; j < i; j++) { 
                // If the current element is strictly greater than the previous element,
                // it can extend the increasing subsequence ending at index j
                if (nums[i] > nums[j]) { 
                    max = Math.max(max, dp[j]); 
                } 
            } 
            
            // The LIS ending at i is the best previous LIS length plus the current element itself
            dp[i] = max + 1; 
            
            // Update the global maximum length found across all indices
            ans = Math.max(ans, dp[i]); 
        } 
        
        // Return the ultimate longest increasing subsequence length
        return ans; 
    } 
}
