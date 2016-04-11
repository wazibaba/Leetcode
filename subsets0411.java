public class Solution {
    public List<List<Integer>> retList;
    public void dfs(int[] nums, int len, int curr, List<Integer> currList) {
        retList.add((ArrayList<Integer>)((ArrayList<Integer>)currList).clone());
        if(curr == len) {
            return;
        }
        
        for(int i = curr; i < len; i++) {
            currList.add(nums[i]);
            dfs(nums, len, i+1, currList);
            currList.remove(currList.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        retList = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(len == 0) return retList;
        Arrays.sort(nums);
        List<Integer> currList = new ArrayList<Integer>();
        //retList.add(currList);
        dfs(nums, len, 0, currList);
        return retList;
    }
}
