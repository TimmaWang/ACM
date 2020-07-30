//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
//
//
//
// 提示：
//
//
// board 和 word 中只包含大写和小写英文字母。
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3
//
// Related Topics 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] move= new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    private String word;
    private char[][] board;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int i, int j, int index) {
        if (index == word.length()-1) {
            return  board[i][j] == word.charAt(index);
        }

        if (board[i][j] == word.charAt(index)) {

            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int curI = i + move[k][0];
                int curJ = j + move[k][1];
                if (inArea(curI, curJ) && !visited[curI][curJ] ) {
                    if (dfs(curI, curJ, index+1)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }

        return false;
    }

    public boolean inArea(int i, int j) {
        int m = board.length;
        int n = board[0].length;
        return i >= 0 && j >= 0 && i <m && j < n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
