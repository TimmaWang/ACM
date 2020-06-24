//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxHight(root);
        return diameter;
    }

    int maxHight(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (null == root.left && null == root.right) {
            return 0;
        }

        int leftHight = maxHight(root.left);
        int rightHight = maxHight(root.right);

        int hight = leftHight+rightHight;

        if (null != root.left){
            hight++;
        }
        if (null != root.right){
            hight++;
        }

        if (diameter < hight) {
            diameter = hight;
        }

        if (null != root.left && null != root.right) {
            return Math.max(leftHight, rightHight) + 1;
        } else {
            return root.left == null ? rightHight+1 : leftHight+1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
