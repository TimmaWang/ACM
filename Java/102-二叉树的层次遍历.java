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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

       List<List<Integer>> result = new ArrayList<>();
       if(null == root) {
           return result;
       }

       queue.offer(root);
       while(!queue.isEmpty()) {

           int size = queue.size();
           ArrayList<Integer> tmp = new ArrayList<>();

           for(int i = 0 ; i<size; i++) {
               
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(null != node.left) {
                    queue.offer(node.left);
                }
                if(null != node.right) {
                    queue.offer(node.right);
                }
           }

           result.add(tmp);
           
       }

       return result;
    }
}