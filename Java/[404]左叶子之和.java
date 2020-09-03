//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)
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

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }
        leftDfs(root.left, true);
        leftDfs(root.right, false);

        return sum;
    }

    public void leftDfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null
            && root.right == null) {
            if (isLeft) {
                sum += root.val;
            }

        }
        leftDfs(root.left, true);
        leftDfs(root.right, false);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
