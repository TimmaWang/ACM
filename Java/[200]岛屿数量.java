//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int move[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    private int m;
    private int n;
    private char[][] grid;
    private boolean [][] visited;

    public int numIslands(char[][] grid) {

        this.m = grid.length;
        if (m == 0) {
            return 0;
        }
        this.n = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[m][n];
        int size = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (!visited[i][j]) {
                    if (grid[i][j] == '1') {
                        dfs(i,j);
                        size++;
                    }
                }

            }
        }

        return size;

    }

    public void dfs(int x, int y){

        if (!inLimit(x,y) || grid[x][y] == '0' || visited[x][y] == true) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + move[i][0];
            int newY = y + move[i][1];
            if (inLimit(newX, newY)) {
                dfs(newX, newY);
//                visited[newX][newY] = false;
            }


        }


    }

    public boolean inLimit(int i, int j) {
        return i < m && j < n && i >=0 && j >=0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
