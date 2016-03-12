public class Solution {
    int[] levels;
    int[] parents;
    public int findParent(int x) {
        if(parents[x] == x) return x;
        return parents[x] = findParent(parents[x]);
    }
    public boolean union(int x, int y) {
        int p1 = findParent(x);
        int p2 = findParent(y);
        if(p1 == p2) return false;
        
        if(levels[p1] < levels[p2]) {
            parents[p1] = p2;
        }
        else if(levels[p2] < levels[p1]) {
            parents[p2] = p1;
        }
        else {
            levels[p1]++;
            parents[p2] = p1;
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        levels = new int[n];
        parents = new int[n];
        int size = edges.length;
        if(size == 0) return n == 1;
        int i, x, y;
        for(i = 0; i < n; i++) {
            levels[i] = 1;
            parents[i] = i;
        }
        for(i = 0; i < size; i++)
        {
            x = edges[i][0]; 
            y = edges[i][1];
            if(! union(x, y) ) return false;
        }
        int cnt = 0;
        for(i = 0; i < n; i++) {
            if(parents[i] == i)
                cnt++;
        }
        return cnt == 1; 
        //detec if parents only have one element equal to itself. other return false;
        // n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
//         0  1  2  3  4    
// p       0, 0, 0  0  1
// l       1  2  2  2  3
    }
}