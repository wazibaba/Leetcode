public class Solution {
    public List<List<Integer>> ret_list;
    public void helper(int[] candidates, int start_index_ori, int target, ArrayList<Integer> curr_list)
    {
        if(target == 0)
        {
            System.out.println("Found !!!  " + curr_list.toString() + "\n\n");
            ret_list.add((ArrayList<Integer>) curr_list.clone());
            return;
        }
        if(target < 0) return;
        
        for(int start_index = start_index_ori; start_index < candidates.length; start_index++ )
        {
            curr_list.add(candidates[start_index]);
            if(target - candidates[start_index] == 0)
            {
                 System.out.println("Found !!!  " + curr_list.toString() + "\n\n");
                ret_list.add((ArrayList<Integer>) curr_list.clone());
                return;
            }
            if(start_index + 1 < candidates.length)
            helper(candidates, start_index+1, target - candidates[start_index], (ArrayList<Integer>) curr_list.clone() );
            curr_list.remove(curr_list.size() - 1);
            
            while(start_index + 1 < candidates.length && candidates[start_index] == candidates[start_index + 1])
                start_index++;
        }
        
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ret_list = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr_list = new ArrayList<Integer>();
        if(candidates.length == 0) return ret_list;
        Arrays.sort(candidates);
        helper(candidates, 0, target, curr_list);
        return ret_list;
    }

}