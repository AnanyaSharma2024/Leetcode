class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0; 
        int fast = 0;
        //CYCLE DHOONDHNA 
        //doing first cause abhidono same place pr h toh while condition false ho jayegi
        do {
            slow = nums[slow];    //1     
            fast = nums[nums[fast]]; //2 
        } while (slow != fast);        
        //DUPLICATE DHOONDHNA 
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];   
            fast = nums[fast];   
        }
        return slow; //fast bhi return krsatke kyuki dono same place
    }
}
