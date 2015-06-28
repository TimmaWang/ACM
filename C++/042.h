#ifndef _LEETCODE_H
#define _LEETCODE_H

#include<iostream>
#include<string>
#include<vector>
#include<stack>
#include<map>
#include<queue>
#include<algorithm>
#include<math.h>

using namespace std;

class Solution
{
public:
	int trap(int A[], int n) {

		if(n < 2)
			return 0;
		int *lmh = new int[n];
		int maxh ;
		int waterSum = 0;
		int container;

		lmh[0] = 0;
		maxh = A[0];

		for(int i = 1 ; i < n ; i++)
		{
			lmh[i] = maxh;
			if(A[i] > maxh)
				maxh = A[i];
		}

		maxh = A[n-1];

		for(int j = n-2 ; j > 0 ; j--)
		{
			container = min(lmh[j],maxh);
			
			if(container > A[j])
				waterSum += (container-A[j]);

			if(A[j] > maxh)
				maxh = A[j];
		}

		delete lmh;
		return waterSum;

	}

};

#endif