public class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        int appear = 1;
        int m = nums[0];
        for(int i = 1; i < len; i++)
        {
            if(appear == 0)
            {
                appear++; 
                m = nums[i];
                continue;
            }
            if(m == nums[i])
                appear++;
            else
                appear--;
            
        }
        return m;
    }
}