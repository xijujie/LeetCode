/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 *
 * https://leetcode-cn.com/problems/max-area-of-island/description/
 *
 * algorithms
 * Medium (59.81%)
 * Likes:    208
 * Dislikes: 0
 * Total Accepted:    27.9K
 * Total Submissions: 45.2K
 * Testcase Example:  '[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]'
 *
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地)
 * 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,1,1,0,1,0,0,0,0,0,0,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,0,1,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,1,1,0,0],
 * ⁠[0,0,0,0,0,0,0,0,0,0,1,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *
 *
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 *
 * [[0,0,0,0,0,0,0,0]]
 *
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 */

// @lc code=start
class Solution {
    // 1 DFS
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    int dfs(int[][] grid, int i, int j){
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0; // 访问后置0，避免再次访问
            return 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
        }
        return 0;
    }

    // 2 并查集
    public int maxAreaOfIsland1(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] pre = new int[row * col];
        Arrays.fill(pre, -1);
        int cnt = 0;
        for (int i = 0, k = 0; i < row; i++) {
            for (int j = 0; j < col; j++, k++) {
                if (grid[i][j] == 1){
                    cnt++;
                    if (i != 0 && grid[i - 1][j] == 1) merge(pre, k, k - col);
                    if (j != 0 && grid[i][j - 1] == 1) merge(pre, k, k -1);
                }
            }
        }
        if (cnt == 0) return 0;
        int res = pre[0];
        for (int i:pre) res = Math.min(res, i);
        return Math.abs(res);
    }

    int find(int[] pre, int k){
        if (pre[k] < 0) return k;
        return pre[k] = find(pre, pre[k]); //路径压缩
    }

    void merge(int[] pre, int x, int y){
        int r1 = find(pre, x), r2 = find(pre, y);
        if (r1 < r2){  //按秩合并
            pre[r1] += pre[r2];
            pre[r2] = r1;
        }
        else if (r2 < r1){
            pre[r2] += pre[r1];
            pre[r1] = r2;
        }
    }
}
// @lc code=end

