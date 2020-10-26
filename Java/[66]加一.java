//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int n = digits.length;
        for (int i = n-1; i>= 0; i--) {
            if (i == n-1) {
                int tmpCarry = (digits[i]+1+carry)/10;
                digits[i] = (digits[i]+1+carry)%10;
                carry = tmpCarry;
            } else {
                int tmpCarry = (digits[i]+carry)/10;
                digits[i] = (digits[i]+carry)%10;
                carry = tmpCarry;
            }

        }

        if (carry > 0) {
            int[] res = new int[n+1];
            res[0] = carry;
            for (int i = 1; i <= n; i++) {
                res[i] = digits[i-1];
            }
            return res;
        } else {
            return digits;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
