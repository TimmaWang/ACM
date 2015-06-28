//Binary Tree Right Side View 
package com.timma.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class T199 {
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public List<Integer> rightSideView(TreeNode root) {
    	//method:level traverse
    	List<Integer> res = new ArrayList<Integer>();
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	int numCurLevel = 1;
    	int numNextLevel = 0;
    	TreeNode tmp = null;
    	if(root != null){
    		queue.offer(root); 		
    		
    		
    		while(queue.isEmpty() != true) {
    			
    			while(numCurLevel != 0){
    				tmp = queue.poll();
    				numCurLevel--;
        			if(tmp.left != null){
        				queue.offer(tmp.left);
        				numNextLevel++;
        			}
        			if(tmp.right != null){
        				queue.offer(tmp.right);
        				numNextLevel++;
        			}
    			}
    			
    			numCurLevel = numNextLevel;
    			numNextLevel = 0;
    			
    			res.add(tmp.val);
    			
    			
    		}
    		
    	}
    	
        return res;
    }
}

