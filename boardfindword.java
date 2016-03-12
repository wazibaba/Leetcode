import java.util.*;

public class Solution {
    public class Pair {
        int x;
        int y;
        Pair(int x1, int y1)
        {
            x = x1;
            y = y1;
        }
    }
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;  //not sure should return true or false.
        int row = board.length;
        if (row == 0) return false;
        int col = board[0].length;
        boolean[][] checked = new boolean[row][col];
        
        for(int i = 0; i < row; i++)
        for(int j = 0; j < col; j++)
            checked[i][j] = false;
            
        int d = 0;
        Stack stack = new Stack();
    
        for(int i = 0; i < row; i++)
        for(int j = 0; j < col; j++)
        {
            if (board[i][j] == word.charAt(d))
            {
                stack.push(new Pair(i, j)); ++d; checked[i][j] = true;
                while(stack.size() > 0 && stack.size() != word.length())
                {
                    Pair top = (Pair)stack.peek();
                    ArrayList<Pair> neighbors = new ArrayList<Pair>();
                    for(int m = -1; m <= 1; m++)
                    for(int n = -1; n <= 1; n++)
                    {
                        if(m == 0 && n == 0) continue;
                        if( Math.abs(m) + Math.abs(n) == 2) continue;
                        if(0 <= m + top.x && m+top.x < row && 0 <= n + top.y && n + top.y < col)
                            neighbors.add(new Pair(m + top.x, n + top.y));
                    }
                    int old_d = d;
                    for(int k = 0; k < neighbors.size(); k++)
                    {
                        Pair tmp = (Pair)neighbors.get(k);
                        if(d < word.length() && checked[tmp.x][tmp.y] == false && board[tmp.x][tmp.y] == word.charAt(d))
                        {
                            ++d; stack.push(tmp); checked[tmp.x][tmp.y] = true;
                        }
                    }
                    if(old_d == d)
                    {
                        --d;
                        checked[top.x][top.y] = false;
                        stack.pop();
                    }
                }
                if(stack.size() == word.length()) return true;
            }
        }
        return false;
    }
}