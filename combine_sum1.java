public class Solution {
    public List<List<Integer>> ret_list;
    public void helper(int[] candidates, int start_index, int target, ArrayList<Integer> curr_list)
    {
        if(target == 0)
        {
            System.out.println("Found !!!  " + curr_list.toString() + "\n\n");
            ret_list.add((ArrayList<Integer>) curr_list.clone());
            return;
        }
        if(target < 0) return;
        
        while( start_index < candidates.length )
        {
            curr_list.add(candidates[start_index]);
            helper(candidates, start_index, target - candidates[start_index], (ArrayList<Integer>) curr_list.clone() );
            curr_list.remove(curr_list.size() - 1);
            start_index++;
        }
        
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret_list = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr_list = new ArrayList<Integer>();
        if(candidates.length == 0) return ret_list;
        Arrays.sort(candidates);
        helper(candidates, 0, target, curr_list);
        return ret_list;
    }
    //2,3,6,7 and target 7, 
    //[7]
    //[2, 2, 3]
    
}