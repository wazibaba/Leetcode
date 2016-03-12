import java.util.*;
public class Solution {
    public List<List<Integer>> ret_list;
    public void permute_helper(int[] nums, int step, HashMap<Integer,Boolean> visited, ArrayList<Integer> curr_list)
    {
        if(step == nums.length)
        {   ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i = 0; i < curr_list.size(); i++) tmp.add(nums[i]);
            ret_list.add(tmp); return;
        }
        for(int j = 0; j < nums.length; j++)
        {
            if(! visited.get(nums[j]))
            {
                curr_list.add(nums[j]);   //[1, ]
                visited.put(nums[j], true);
                permute_helper(nums, step + 1, visited, curr_list);  // from 1, [1,]   //from 2, [1, 2] //
                curr_list.remove(curr_list.size() -1);
                visited.put(nums[j], false);
            }
                
            }
    }
    public List<List<Integer>> permute(int[] nums) {
        ret_list = new ArrayList<List<Integer>>();
        HashMap<Integer,Boolean> visited = new HashMap<Integer, Boolean>();
        for(int i = 0; i < nums.length; i++) visited.put(nums[i], false);
        ArrayList<Integer> curr_list = new ArrayList<Integer>();
        permute_helper(nums, 0, visited, curr_list);
        
        return ret_list;
    }
}