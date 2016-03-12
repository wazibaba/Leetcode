    public List<List<Integer>> retList;
    public void helper(int n, int k, int level, ArrayList<Integer>currList)
    {
        if(currList.size() == k){
            retList.add((ArrayList<Integer>)currList.clone());
            return;
        }
        for(int i = level; i <=n; i++)
        {
            currList.add(i);
            helper(n, k, i+1, (ArrayList<Integer>)currList.clone() );
            currList.remove(currList.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        retList = new ArrayList<List<Integer>>();
        if(n == 0 || k == 0) return retList;
        
        ArrayList<Integer> currList = new ArrayList<Integer>();
        helper(n, k, 1, currList);
        return retList;
    }