public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        //beginWord = "hit"
        //endWord = "cog"
        //wordList = ["hot","dot","dog","lot","log"]
        //  "hit" -> "hot" -> "dot" -> "dog" -> "cog",
        if(beginWord == null || endWord == null) return 0;
        if(beginWord.compareTo(endWord) == 0) return 0;   //return 0 or anything else ?
        Queue curr_level = new LinkedList(); 
        Queue next_level = new LinkedList();
    
        for(char c = 'a'; c <= 'z'; c++)
        {
            if(beginWord.charAt(0) == c) continue;
            StringBuilder begin_tmp = new StringBuilder(beginWord);
            begin_tmp.setCharAt(0, c);
            String tmp = begin_tmp.toString();
            if(wordList.contains(tmp)) {
                if(tmp.compareTo(endWord) == 0) 
                    return 1;
                else
                    curr_level.add(tmp);
            }
        }
        for(int lev = 1; lev < beginWord.length(); lev++)
        {
            while(curr_level.size() > 0)
            {
                String top = (String)curr_level.poll();
                for(char c = 'a'; c <= 'z'; c++)
                {
                    if(top.charAt(lev) == c) continue;
                    StringBuilder begin_tmp = new StringBuilder(top);
                    begin_tmp.setCharAt(lev, c);
                    String tmp = begin_tmp.toString();
                    if(wordList.contains(tmp)) {
                    if(tmp.compareTo(endWord) == 0) 
                        return lev + 1;
                    else
                        next_level.add(tmp);
                    }
            }
            while(next_level.size() > 0) 
                curr_level.add((String)next_level.poll());
        }
        }
        return 0;    
    }
    
}