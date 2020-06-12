//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();
        if (n<=1) {
            return s;
        }
        boolean dp[][] = new boolean[n][n];
        String res = s.substring(0,1);

        for (int i = n-2; i >= 0 ; i--) {
            for (int j = i; j <= n-1 ; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    int size = j-i+1;
                    if (size > res.length()) {
                        res = s.substring(i, j+1);
                    }
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i >= 2 && dp[i+1][j-1]) {
                        dp[i][j] = true;
                        int size = j-i+1;
                        if (size > res.length()) {
                            res = s.substring(i, j+1);
                        }
                    } else if (j-i< 2){
                        dp[i][j] = true;
                        int size = j-i+1;
                        if (size > res.length()) {
                            res = s.substring(i, j+1);
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }else {
                    dp[i][j] = false;
                }
            }
        }

        return res;

    }
    
    
    // 比较清晰的写法
    class Solution {
    public String longestPalindrome(String s) {
        if(s.equals(""))  return s;

        int len = s.length(),left = 0,right = 0;
        // db[i][j] 表示字符串区间 [i, j] 是否为回文串
        boolean[][] db = new boolean[len][len];
        // 注意,这里的遍历与平常我们对字符串的遍历不一样
        for(int j = 0;j<len;j++)
            for(int i =0;i<=j;i++){
                db[i][j] = (s.charAt(i) == s.charAt(j))&&(j-i<2 || db[i+1][j-1]);
                //如果是回文字符串，并且比之前的回文字符串要长，更新字符串长度，记录字符串
                if(db[i][j] && j-i>right-left){
                    left = i;
                    right = j;
                }
            }
        return s.substring(left,right+1);
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
