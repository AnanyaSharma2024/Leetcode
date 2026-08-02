class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : nums){
            map.put(num, false);
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(map.get(nums[i])){
                continue;
            }map.put(nums[i], true);
            int currLen = 1;
            //checking in the front direction
            int nextNum = nums[i] + 1;
            while(map.containsKey(nextNum) && map.get(nextNum) == false){
                currLen++;
                map.put(nextNum, Boolean.TRUE);
                nextNum++;
            }
            //checking in the backward direction
            int prevNum = nums[i] - 1;
            while(map.containsKey(prevNum) && map.get(prevNum) == false){
                currLen++;
                map.put(prevNum, Boolean.TRUE);
                prevNum--;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
}