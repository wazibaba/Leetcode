public class Solution {
    public List<List<Integer>> retList;
    public void helper(int[] nums, int len, ArrayList<Integer> currList, boolean[] used) {
        if(currList.size() == len) {
            retList.add((ArrayList<Integer>)currList.clone() );
            return;
        }
        for(int i = 0; i < len; i++) {
         if(used[i]) continue;
         used[i] = true;
         currList.add(nums[i]);
         helper(nums, len, (ArrayList<Integer>)currList, used);
         currList.remove(currList.size() - 1);
         used[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        retList = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(len == 0) return retList;
        boolean[] used = new boolean[len];
        for(int i = 0; i< len; i++) used[i] = false;
        ArrayList<Integer> currList = new ArrayList<Integer>();
        helper(nums, len, currList, used);
        return retList;
        
    }
}