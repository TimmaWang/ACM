//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) {
            return res;
        }

        res.add(Arrays.asList(1));
        for (int row = 1 ; row < numRows; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                int left = 0;
                int right = 0;
                if (col-1 < 0) {
                    left = 0;
                } else {
                    left = res.get(row-1).get(col-1);
                }

                if (col >= row) {
                    right = 0;
                } else {
                    right = res.get(row-1).get(col);
                }

                rowList.add(left+right);
            }
            res.add(rowList);
        }

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
