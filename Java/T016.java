//3Sum Closest
//
package com.timma.algorithm;

import java.util.Arrays;

public class T016 {
	public int threeSumClosest(int[] nums, int target) {
		int min = Integer.MAX_VALUE;
		int res = 0;
		
		Arrays.sort(nums);
		
		for(int i = 0 ; i < nums.length ; i++) {
			int j = i + 1;
			int k = nums.length - 1;
						
			while(j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				int dif = Math.abs(sum - target);
				
				if(dif == 0)
					return sum;
				
				if(dif < min){
					min = dif;
					res = sum;
				}
				
				if(sum <= target)
					j++;
				else
					k--;				
			}
		}
		
		return res;
		
	}
	
	public static void main(String args[]) {
		T016 t = new T016();
		int nums[] = {-1,2,1,-4};
		System.out.println(t.threeSumClosest(nums, 1));
		
	}
		
}
