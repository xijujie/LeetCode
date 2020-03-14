/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
 *
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/description/
 *
 * algorithms
 * Easy (48.80%)
 * Likes:    278
 * Dislikes: 0
 * Total Accepted:    38.4K
 * Total Submissions: 78.8K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *
 * ⁠         1
 * ⁠        / \
 * ⁠       2   3
 * ⁠      / \
 * ⁠     4   5
 *
 *
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 1; //直径上的结点数
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max - 1;
    }
    int dfs(TreeNode root){
        if (root == null) return 0;
        int l = dfs(root.left); //左子树的高度
        int r = dfs(root.right); //右子树的高度
        max = Math.max(max, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
// @lc code=end

