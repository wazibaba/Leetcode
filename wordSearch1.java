import java.util.*;

public class Solution {
    //["aa"]   "aaa"  timeout.... 
    /*
      ["ABCE",
       "SFCS",
       "ADEE"]

"ABCCED"
     */
    public boolean DFS(char[][] board, int row, int col, int i, int j, int pos, String word, boolean[][]visited)
    {
        //System.out.println("enter with current pos: " + pos);
        if(pos == word.length()) 
        {
            //System.out.println("pos is :" + pos);
            return true;
        }
        int[][] move = {{0, 1},{0, -1}, {-1, 0}, {1, 0}};
    
        for(int m = 0; m < 4; m++) {
            int new_i = i + move[m][0]; 
            int new_j = j + move[m][1];
            
            if(new_i < 0 || new_i >= row || new_j < 0 || new_j >= col) continue;
            if(board[new_i][new_j] != word.charAt(pos)) continue;
            if(visited[new_i][new_j]) continue;
            
            //System.out.println("try board value: " + board[new_i][new_j] + "  VS word value: " + word.charAt(pos) );
            //System.out.println("new_i: " + new_i + "   new_j: " + new_j  );
            visited[new_i][new_j] = true;
            pos += 1;
            if( DFS(board, row, col, new_i, new_j, pos, word, visited) )
                return true;
            visited[new_i][new_j] = false;
            pos -= 1;
        }

        return false;

    }
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;  //not sure should return true or false.
        int row = board.length;
        if (row == 0) return false;
        int col = board[0].length; int i, j;
        boolean[][] visited = new boolean[row][col];
        
        for(i = 0; i < row; i++)
            for(j = 0; j < col; j++)
                visited[i][j] = false;
    
        
        for(i = 0; i < row; i++)
        for(j = 0; j < col; j++)
        {
            if (board[i][j] == word.charAt(0))
            {
                System.out.println("STart with: " + i + "  " + j);
                visited[i][j] = true;
                if(DFS(board, row, col, i, j, 1, word, visited))
                    return true;
                visited[i][j] = false;
            }
        }
        return false;
    }
}