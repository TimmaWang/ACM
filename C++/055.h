//jump game
#ifndef _LEETCODE_H
#define _LEETCODE_H

#include<iostream>
#include<string>
#include<vector>
#include<stack>
#include<map>
#include<queue>
#include<algorithm>
#include<set>

using namespace std;

//还是不是很清楚贪心算法

class Solution {
public:
    bool canJump(int A[], int n) {

		int canarrive = 0;
		if(n == 0 || n == 1)
			return true;
        
		for(int i = 0 ; i <= canarrive && canarrive < n-1 ; i++)
		{

			if(A[i] + i > canarrive)
				canarrive = A[i] + i;
		}

		return canarrive >= n-1;
    }
};

#endif