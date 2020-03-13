/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (50.39%)
 * Likes:    648
 * Dislikes: 0
 * Total Accepted:    106.2K
 * Total Submissions: 210.7K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 *
 *
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
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
    //DFS
    public boolean isSymmetric(TreeNode root) {
        return root == null || judge(root.left, root.right);
    }
    boolean judge(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return t1 == t2;
        return t1.val == t2.val && judge(t1.left, t2.right) && judge(t1.right, t2.left);
    }

    //BFS
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()){
            TreeNode t1 = q.poll(), t2 = q.poll();
            if (t1 == null && t2 == null) continue;;
            if (t1 == null || t2 == null || t1.val != t2.val) return false;
            q.offer(t1.left); q.offer(t2.right);
            q.offer(t1.right); q.offer(t2.left);
        }
        return true;
    }
}
// @lc code=end

