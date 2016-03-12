public class Solution {
    //Solve it without division and in O(n).
    //For example, given [1,2,3,4], return [24,12,8,6].
    public int[] result;
    
    public void DFS(int[] nums, int len, int currLevel) {
        if(currLevel == len )
            return;
        for(int i = 0; i < len; i++)
        {
            if(i == currLevel) continue;
            result[i] *= nums[currLevel];
        }
        DFS(nums, len, currLevel+1);
    }
    
    //1, 1, 1, 1 currLeve = 0;
    //2, 1, 2, 2  currLeve = 1;
    //6, 3, 2, 6   currLeve =2;    3 
    //24, 12, 8, 6  currLevel = 3, val = 4

    
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if(len == 0) return (new int[0]);
        result = new int[len];
        for(int i = 0; i < len; i++)
            result[i] = 1;
        DFS(nums, len, 0);
        return result;
    }
}