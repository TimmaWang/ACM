#ifndef _LEETCODE_H
#define _LEETCODE_H

#include<iostream>
#include<string>
#include<vector>
#include<stack>
#include<map>
#include<queue>
#include<algorithm>

using namespace std;

class Solution
{
public:
	int search(int A[], int n, int target) {
        
		int start,end,mid;

		start = 0;
		end = n-1;

		while(start <= end)
		{
			mid = (start + end)/2;

			if(A[mid] == target)
				return mid;

			if(A[mid] < A[end])
			{
				if(target <= A[end] && target > A[mid])
					start = mid + 1;
				else
					end = mid - 1;
			}
			else
			{
				if(target >= A[start] && target < A[mid])
					end = mid -1;
				else
					start = mid + 1;
			}
		}

		return -1;
    }
};

#endif