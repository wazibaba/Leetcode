public class Solution {

//    For example, given candidate set 2,3,6,7 and target 7, 
//    A solution set is: 
//    [7] 
//    [2, 2, 3] 


    public List<List<Integer>> retList;
    public void helper(int[] cand, int target, int len, int level, ArrayList<Integer>currList)
    {
        if(target == 0) {
            //System.out.println("target equal to 0, add and reteturn, current list:"  + currList);
            retList.add((ArrayList<Integer>) currList.clone());
            return;
        }
        if(target < 0) 
            return;
            
        for(int i = level; i < len; i++) {
            int tmp = target - cand[i];
            //System.out.println("current target, : " + tmp);
            if(tmp < 0) return;
            currList.add(cand[i]);
            helper(cand,tmp, len, i, (ArrayList<Integer>)currList.clone());
            currList.remove(currList.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        retList = new ArrayList<List<Integer>>();
        int len = candidates.length;
        if(len == 0) return retList;
        ArrayList<Integer> currList = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, len, 0, currList);
        return retList;
    }
}