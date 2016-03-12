import java.util.*;

public class HelloWorld {
	public static List<List<Integer>> outcome_list;
    
    public static void combine_helper(int n, int k, boolean[] used, ArrayList<Integer> inner_list)
    {
    	System.out.println("current inner_list size: " + inner_list.size());
        for(int i = 1; i <= n; i++)
        {
        	if(inner_list.size() == k)
        	{
            ArrayList<Integer> tmp_list = new ArrayList<Integer>();
            for(int j = 0; j < inner_list.size(); j++ )
                tmp_list.add(inner_list.get(j));
            System.out.println(tmp_list);
            outcome_list.add(tmp_list);
            return;
        	}

        	System.out.println("current i is:  " + i);

            if(used[i] == true) {
            	System.out.println("however used_i is true");
            	continue;
            }
            inner_list.add(i); 
            used[i] = true;
            combine_helper(n, k, used, inner_list);
            used[i] = false;
            inner_list.remove(inner_list.size() - 1);
            System.out.println("after remove the last from inner_list in last step");
            System.out.println(inner_list);
        }
        
    }
    public static List<List<Integer>> combine(int n, int k) {
        outcome_list = new ArrayList<List<Integer>>();
        if(k == 0) return outcome_list;
        if(n == 0) return outcome_list;
        
        boolean[] used = new boolean[n + 1];
        for(int i = 0; i < n + 1; i++) {
        	used[i] = false;
        	System.out.println(i + "th" + "of used is false");
        }
        ArrayList<Integer> inner_list = new ArrayList<Integer>();
        combine_helper(n, k, used, inner_list);
        return outcome_list;
    }
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");

        combine(1, 1);

        combine(10, 7);
    }

}