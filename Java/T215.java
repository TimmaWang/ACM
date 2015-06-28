package com.timma.algorithm;

import java.util.Arrays;

public class T215 {
	public int findKthLargest(int[] nums, int k) {
		//not a good method.
        Arrays.sort(nums);
        return nums[nums.length-k];
        
        //can use heap sort...
    }

}
