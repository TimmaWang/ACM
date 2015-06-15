package com.leetcode.practice;

import java.util.ArrayList;

public class T131 {
	public void dfs(String s, int start, 
			ArrayList<String> partition, ArrayList<ArrayList<String>> result) {
		
		if(start == s.length()) {
			result.add(new ArrayList<String>(partition));
			
			return;
		}
		
		for(int i = start+1 ; i <= s.length() ; i++) {
			String tmpString = s.substring(start, i);
			
			if(isPalindrome(tmpString) == true){
				partition.add(tmpString);
				dfs(s, i, partition, result);
				partition.remove(partition.size()-1);
			}
		}
		
	}
	
	public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<String> partition = new ArrayList<String>();
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        if(s == null || s.length() == 0)
        	return result;
        
        dfs(s, 0, partition, result);
        
        return result;
    }
	
	
	boolean isPalindrome(String str) {
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i))
				return false;
		}
		
		
		return true;
	}
}
