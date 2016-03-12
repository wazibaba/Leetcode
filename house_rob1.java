public class Solution {
    public int rob(int[] nums) {
        //[1, 4, 9, 10, 5, 8, 7]  expect 22;
        // 0, 1, 2, 3, 4, 5, 6;  first, they are non-decreasing, sum_i <= sum_i+2
        //end with index;
        // 0:   1               s0 = 1
        // 1:   4               s1 = 4
        // 2:   1 + 9 = 10      s2 = max(s1, s0 + a2) = max(4, 10) = 10
        // 3:   4 + 10 = 14;    s3 = max(s2, s1 + a3) = (10, 4 + 10) = 14;
        // 4:   10 + 5 = 15;
        // 5:   14 + 5 = 19;
        // 6:   7 + 15 = 22;
        // [2,1,1,2]
        //  2
        //  
        int gs = 0;
        int len = nums.length;
        int[] sum = new int[len];
        if(len == 0) return 0;
        else if(len == 1) return nums[0];
        else if(len == 2)  {
            if(nums[0] > nums[1]) return nums[0];
            else                  return nums[1];
        }
        sum[0] = nums[0]; sum[1] = nums[1]; 
        if(sum[0] > gs) gs = sum[0];
        if(sum[1] > gs) gs = sum[1];
        for(int i = 2; i < 3; i++)
        {
            int t1 = sum[i-1];
            int t2 = sum[i-2] + nums[i];
            if(t1 > t2) sum[i] = t1;
            else        sum[i] = t2;
            if(sum[i] > gs) gs = sum[i];
        }
        for(int i = 3; i < len; i++)
        {
            int t1 = sum[i-1];
            int t2 = sum[i-2] + nums[i];
            int t3 = sum[i-3] + nums[i];
            if(t1 > t2) sum[i] = t1;
            else        sum[i] = t2;
            if(t3 > sum[i]) sum[i] = t3;
            if(sum[i] > gs) gs = sum[i];
        }
        return gs;

    }
}