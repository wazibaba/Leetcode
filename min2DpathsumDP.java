public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i, j;
        int[][] cost = new int[m][n];
        for(i = 0; i < m; i++)
            for(j = 0; j < n; j++)
                cost[i][j] = 0;
        cost[0][0] = grid[0][0];
        for(i = 1; i < m; i++) cost[i][0] = cost[i-1][0] + grid[i][0];
        for(j = 1; j < n; j++) cost[0][j] = cost[0][j-1] + grid[0][j];
        
        for(i = 1; i < m; i++)
        for(j = 1; j < n; j++)
            cost[i][j] = Math.min(cost[i-1][j], cost[i][j-1]) + grid[i][j];
        
        return cost[m-1][n-1];
    }
}