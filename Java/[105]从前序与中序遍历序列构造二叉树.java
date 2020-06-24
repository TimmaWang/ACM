//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

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

    HashMap<Integer, Integer> nodeIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        for (int i = 0 ; i < inorder.length; i++) {
            nodeIndexMap.put(inorder[i], i);
        }

        return buildMyTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildMyTree(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        
        // todo 这个地方的比较，需要琢磨下
        if (preBegin > preEnd ) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preBegin]);


        int nodeIndex = nodeIndexMap.get(preorder[preBegin]);
        root.left = buildMyTree(preorder, inorder, preBegin+1, preBegin+(nodeIndex-inBegin), inBegin, nodeIndex-1);
        root.right = buildMyTree(preorder, inorder, preEnd-(inEnd-nodeIndex-1), preEnd, nodeIndex+1, inEnd);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
