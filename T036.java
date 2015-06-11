package com.timma.algorithm;

import java.util.HashMap;

public class T036 {
	public boolean isValidSudoku(char[][] board) {
		
		final int n = 9;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		//check row
		for(int i = 0 ; i < n ; i++) {
			map.clear();
			for(int j = 0 ; j < n ;j++) {
				if(board[i][j] == '.')
					continue;
				if(map.get(board[i][j]) != null)
					return false;
				else {
					map.put(board[i][j], 1);
				}
			}
		}
		
		
		//check column
		for(int i = 0 ; i < n ; i++) {
			map.clear();
			for(int j = 0 ; j < n ;j++) {
				if(board[j][i] == '.')
					continue;
				if(map.get(board[j][i]) != null)
					return false;
				else {
					map.put(board[j][i], 1);
				}
			}
		}
		
		
		//check square
		for(int i = 0 ; i < n ; i++) {
			map.clear();
			for(int j = (i/3)*3; j < (i/3)*3+3; j++) {
				for(int k = (i%3)*3; k <(i%3)*3+3 ; k++ ) {
					
					if(board[j][k] == '.')
						continue;
					if(map.get(board[j][k]) != null)
						return false;
					else {
						map.put(board[j][k], 1);
					}
				}
			}
		}
		
		return true;
    }

}
