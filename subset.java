public class Solution {
    List<List<Integer>> ret_list;
    public void helper(int[] nums, int curr_index, ArrayList<Integer> curr_list)
    {
        //System.out.println("current looking at index:  " + curr_index);
        //System.out.println("current input list size: " + curr_list.size() + "\n\n");
        
        for(int i = curr_index; i < nums.length; i++)
        {
            curr_list.add(nums[i]); 
            
            System.out.println("pervious ret_list: " + ret_list.toString());
            System.out.println("going to add : " + curr_list.toString());
            ret_list.add((ArrayList<Integer>)curr_list.clone());
            System.out.println("after add: " + ret_list.toString());
            
            if(i+1 < nums.length)
                helper(nums, i+1, (ArrayList<Integer>).clone());
            curr_list.remove(curr_list.size() -1);
            System.out.println("\n after remove last element \n" + curr_list.toString());
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        ret_list = new ArrayList<List<Integer>>();
        ret_list.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>() );
        
        return ret_list;
    }
    
}


trace log: 



pervious ret_list: [[]]
going to add : [1]
after add: [[], [1]]
pervious ret_list: [[], [1]]
going to add : [1, 2]
after add: [[], [1], [1, 2]]
pervious ret_list: [[], [1], [1, 2]]
going to add : [1, 2, 3]
after add: [[], [1], [1, 2], [1, 2, 3]]

 after remove last element 
[1, 2]

 after remove last element 
[1]

pervious ret_list: [[], [1], [1, 2], [1, 2, 3]]

going to add : [1, 3]
after add: [[], [1], [1, 2], [1, 2, 3], [1, 3]]

 after remove last element 
[1]

 after remove last element 
[]


pervious ret_list: [[], [1], [1, 2], [1, 2, 3], [1, 3]]

going to add : [2]
after add: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2]]
pervious ret_list: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2]]
going to add : [2, 3]
after add: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3]]

 after remove last element 
[2]

 after remove last element 
[]

pervious ret_list: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3]]
going to add : [3]
after add: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

after remove last element 
[]
