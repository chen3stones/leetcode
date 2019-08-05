package problem;

/**
 * [5] LongestPalindrome
 * 最长不重复回文字串
 * dp[i][j]表示i-j的字符串是回文串
 * 因为所有的单个字符都是回文串
 * 所以dp[i][i]都为true
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //用于记录回文串的左右边界
        int left = 0,right = 0;
        for(int i = n-2;i >= 0;i--){
            //单个字符一定为回文串
            dp[i][i] = true;
            for(int j = i + 1;j < n;j++){
                //i-j为回文串的条件是(i+1)-(j-1)为回文串且i==j
                //也有情况是只有两个字符，她们相同的话那么i-j就为回文串
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i < 3 || dp[i+1][j-1]);
                if(dp[i][j] && right-left < j-i){
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1);
    }
}
