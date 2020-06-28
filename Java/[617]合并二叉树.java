//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        return merge(t1,t2);
    }

    public TreeNode merge(TreeNode t1, TreeNode t2) {

        TreeNode root = null;
        if (null != t1 && null != t2) {
            root = new TreeNode(t1.val+t2.val);
            root.left = merge(t1.left, t2.left);
            root.right = merge(t1.right, t2.right);

        } else if (null != t2){

            root = new TreeNode(t2.val);
            root.left = merge(null, t2.left);
            root.right = merge(null, t2.right);

        } else if (null != t1){
            root = new TreeNode(t1.val);
            root.left = merge(t1.left, null );
            root.right = merge(t1.right,null);
        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
