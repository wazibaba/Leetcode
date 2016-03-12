public class Solution {
    public boolean isPalindrome(int x) {
        // 121   121 / 10 = 12  121 % 10 = 1;
        //       12  / 10 = 1    12 % 10 = 2;
        //        1  / 10  = 0    1 % 10  = 1;
        if(x < 0) return false;
        if(x == 0) return true;
        int temp = 0;
        int new_x = x;
        while(new_x > 0)
        {
            temp = temp * 10 +  new_x % 10;    //temp = 1;   temp = 10 + 2 = 12  ;   temp =121; 
            new_x = new_x / 10;                    //x = 12;     x = 1;                 x = 0
        }
        return x == temp;
    }
}