//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maximalSquare(char[][] matrix) {

        if (null == matrix) {
            return 0;
        }

        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;

        if (n == 0) {
            return 0;
        }

        int max[][] = new int[m][n];
        int maxLength = 0;
        if (matrix[0][0] == '1') {
            max[0][0] = 1;
            maxLength = 1;
        } else {
            max[0][0] = 0;
        }

        for (int i =0; i < m; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j ==0) {
                        max[i][j] = 1;
                    } else {
                        max[i][j] = Math.min(max[i-1][j], Math.min(max[i-1][j-1], max[i][j-1])) + 1;
                    }

                    if (maxLength < max[i][j]) {
                        maxLength = max[i][j];
                    }
                }
            }
        }

        return maxLength*maxLength;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
