public class Solution {
    public List<List<Integer>> ret_list; 
    
    public void helper(int[] nums, HashMap<Integer, Boolean> visited, ArrayList<Integer> curr_list)
    {
        if(curr_list.size() == nums.length)
        {
            ret_list.add( (ArrayList<Integer>) curr_list.clone() );
            return;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(visited.get(i)) continue;
            visited.put(i, true);
            curr_list.add(nums[i]);
            helper(nums, visited, curr_list);
            curr_list.remove(curr_list.size() - 1);
            visited.put(i, false);
            while(i+1 < nums.length && nums[i] == nums[i+1])
                i++;
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        ret_list = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr_list = new ArrayList<Integer>();
        if(nums.length == 0) return ret_list;
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        for(int i = 0; i < nums.length; i++)
            visited.put(i, false);
        Arrays.sort(nums);
        helper(nums, visited, curr_list);
        return ret_list;
    }
    
}