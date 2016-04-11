public class Solution {
    public int color;
    public void dfs(char[][] grid, int currX, int currY, int width, int length) {
        int[][] move = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        for(int i = 0; i < move.length; i++)
        {
            int newX = currX + move[i][0]; int newY = currY + move[i][1];
            if(newX < 0 || newX >= length || newY < 0 || newY >= width)
                continue;
            if(grid[newX][newY] == '1') {
                grid[newX][newY] = (char) (color + '0');
                dfs(grid, newX, newY, width, length);
            }
        }
    }
    public int numIslands(char[][] grid) {
//11000
//11000
//00100
//00011
    color = 1;
    int length = grid.length;
    if(length == 0) return 0;
    int width = grid[0].length;
    for(int i = 0; i < length; i++)
        for(int j = 0; j < width; j++) {
            if(grid[i][j] == '1')
            {
                color++;
                dfs(grid, i, j, width, length);
            }
    }
    return color - 1; 
    }
}
