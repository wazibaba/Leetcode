    public List<List<Integer>> outcome_list;
    
    public void combine_helper(int n, int k, boolean[] used, ArrayList<Integer> inner_list)
    {

        for(int i = 1; i <= n; i++)
        {
        if(inner_list.size() == k)
        {
            ArrayList<Integer> tmp_list = new ArrayList<Integer>();
            for(int j = 0; j < inner_list.size(); j++ )
                tmp_list.add(inner_list.get(j));
            outcome_list.add(tmp_list);
            return;
        }
        
            if(used[i] == true) continue;
            inner_list.add(i); 
            used[i] = true;
            combine_helper(n, k, used, inner_list);
            used[i] = false;
            inner_list.remove(inner_list.size() - 1);
        }
        
    }
    public List<List<Integer>> combine(int n, int k) {
        outcome_list = new ArrayList<List<Integer>>();
        if(k == 0) return outcome_list;
        if(n == 0) return outcome_list;
        
        boolean[] used = new boolean[n + 1];
        for(int i = 0; i < n + 1; i++) used[i] = false;
        ArrayList<Integer> inner_list = new ArrayList<Integer>();
        combine_helper(n, k, used, inner_list);
        return outcome_list;
    }