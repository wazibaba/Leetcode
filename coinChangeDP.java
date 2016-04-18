public class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if(amount == 0) return 0;
        else if(len == 0) return -1;
        
        int[] changes = new int[amount+1];
        changes[0] = 0;
        for(int i = 1; i <= amount; i++) 
            changes[i] = Integer.MAX_VALUE;
        
        for(int i = 1; i <= amount; i++) 
            for(int j = 0; j < len; j++) {
                if(i >= coins[j]) {
                    if(changes[i - coins[j]] != Integer.MAX_VALUE &&changes[i - coins[j]] + 1  <  changes[i] )
                        changes[i] = changes[i - coins[j]] + 1;
                }
            }
        return changes[amount] == Integer.MAX_VALUE ? -1 : changes[amount];
    }
}
