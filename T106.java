//Construct Binary Tree from InOrder and PostOrder Traversal
package com.timma.algorithm;

public class T106 {
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	int findInorderIndex(int []inorder, int target) {
		for(int i = 0 ; i < inorder.length ; i++) {
			if(inorder[i] == target)
				return i;
		}
		
		return -1;
	}
	
	TreeNode build(int[] inorder, int[] postorder, 
			int inStart, int inEnd, int postStart, int postEnd) {
		
		TreeNode root = null;
		
		if(inStart <= inEnd && postStart <= postEnd){
			root = new TreeNode(postorder[postEnd]);
			int mid = findInorderIndex(inorder, postorder[postEnd]);
			
			root.left = build(inorder, postorder, inStart, 
					mid-1, postStart, postStart+mid-inStart-1);
			
			root.right = build(inorder, postorder, mid+1, 
					inEnd, postStart+mid-inStart, postEnd-1);
			
		}
		
		return root;
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		
		TreeNode root = null;
		int inStart = 0;
		int inEnd = inorder.length-1;
		int postStart = 0;
		int postEnd = postorder.length-1;
		
		root = build(inorder, postorder, inStart, inEnd,
				postStart, postEnd);
		
		return root;
        
    }
}
