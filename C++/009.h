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
	bool isPalindrome(int x) {

		if(x < 0)
			return false;

		int size,left,right;
		int tmp = x;
		size = 0;

		while(tmp)
		{
			tmp = tmp/10;
			size++;
		}

		while(x)
		{
			right = x % 10;
			left = x / (int)pow(10,size-1);

			if(left != right)
				return false;

			x = x % (int)pow(10,size-1);
			x = x / 10;
			size -= 2;
		}

		return true;
        
    }

};

#endif