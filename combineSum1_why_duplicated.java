public class Solution {
    /*
    For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
    */
    List<List<Integer>> retList;
    public void dfs(int[] cand, int level, int target, int sum, ArrayList<Integer> currList) {
        if(target == sum) {
            //here detect whether or not duplicate in the final returnList.
            retList.add( (ArrayList<Integer>)currList.clone() );
            return;
        }
        if(sum > target)
            return;
            
        for(int i = level; i < cand.length; i++) {
            if(i-1 >= 0 && cand[i] == cand[i-1])
                continue;
            if(sum + cand[i] <= target) {
                sum += cand[i];
                currList.add(cand[i]);
                
                dfs(cand, level, target, sum, currList);
                
                currList.remove(currList.size() - 1);
                sum -= cand[i];
            }
        }
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        retList = new ArrayList<List<Integer>>();
        int len = candidates.length;
        Arrays.sort(candidates);
        ArrayList<Integer> currList = new ArrayList<Integer>();
        
        dfs(candidates, 0, target, 0, currList);
        return retList;
    }
}
