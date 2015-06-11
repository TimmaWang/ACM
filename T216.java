package com.timma.algorithm;

import java.util.ArrayList;
import java.util.List;

public class T216 {
	
	int m[] = new int[100];
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	
	public void backTrack(int sum, int i , int k , int n) {
		if(i == k) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			
			if(sum == n) {
				
				for(int a = 0 ; a < k ; a++) {
					tmp.add(m[a]);
				}
				list.add(tmp);
				return ;
			}
			else {
				return;
			}
		}
		else {
			
			for(int j = 1 ; j <= 9 ; j++) {
				boolean check = true;
				m[i] = j;
				for(int q = 0 ; q < i ; q++) {
					if(m[i] == m[q] || m[q] > m[i]) {
						check = false;
						break;
					}
				}

				if(check) {
					backTrack(sum + j,i+1, k, n);
				}
				
				if(sum > n)
					break;
					
			}
		}
	}
	public List<List<Integer>> combinationSum3(int k, int n) {
		backTrack(0, 0, k, n);
		return list;
        
    }
	
	public static void main(String argv[]) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		
		T216 solution = new T216();
		l = solution.combinationSum3(3, 15);
		
		System.out.println(l);
		
	}

}
