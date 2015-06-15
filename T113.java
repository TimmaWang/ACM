package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class T113 {
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	

	public void dfs(TreeNode root, List<Integer> v, List<List<Integer>> res, int sum) {
		
		if(root == null)
			return;
		
		if(root.left == null && root.right == null) {
			if(root.val == sum) {
				v.add(root.val);
				res.add(new ArrayList<Integer>(v));
				v.remove(v.size()-1);
				return ;
			}
		}
		
		v.add(root.val);
		
		if(root.left != null)
			dfs(root.left, v, res, sum-root.val);
		
		if(root.right != null)
			dfs(root.right, v, res, sum-root.val);
		
		v.remove(v.size()-1);
		
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		 
		 
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		 
		 
		List<Integer> tmp = new ArrayList<Integer>();
		
		dfs(root, tmp, list, sum);
		 
		
		return list;
	        
	 
	}
}
