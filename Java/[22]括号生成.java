//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    ArrayList<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        backtrack(new StringBuilder(), 0, 0, n);
        return res;

    }

    public void backtrack(StringBuilder current, int open, int close, int n) {
        if (current.length() == n*2) {
            res.add(current.toString());
            return;
        }

        if (open < n) {
            current.append("(");
            backtrack(current, open+1, close, n);
            current.deleteCharAt(current.length()-1);
        }
        if (close < open) {
            current.append(")");
            backtrack(current, open, close+1, n);
            current.deleteCharAt(current.length()-1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
