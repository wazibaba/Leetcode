public class Solution {
    public List<String> ret_list;
    public HashMap<String, String> keys;
    //1, "";  2, abc;  3, def; 4, ghi; 5; jkl, 6; mno, 7 pqrs, 8 tuv 9 wxyz 0 ""
    public void helper(String digits, int curr, int len, String curr_str)
    {
        if(curr == digits.length() )
        {
            ret_list.add(curr_str);
            return;
        }
        String t = keys.get(digits.charAt(curr) + "");
        for(int i = 0; i < t.length(); i++)
        {
            curr_str += t.charAt(i);
            helper(digits, curr + 1, len, curr_str);
            curr_str = curr_str.substring(0, curr_str.length() - 1);
        }
        
    }
    public List<String> letterCombinations(String digits) {
        ret_list = new ArrayList<String>();
        keys = new HashMap<String, String>();
        keys.put("1", ""); keys.put("2", "abc");keys.put("3", "def");keys.put("4", "ghi");
        keys.put("5", "jkl");keys.put("6", "mno");keys.put("7","pqrs");keys.put("8","tuv");keys.put("9","wxyz");
        keys.put("0", "");
        if(digits.length() == 0) return ret_list;
        helper(digits, 0, digits.length(), "");
        return ret_list;
    }
}