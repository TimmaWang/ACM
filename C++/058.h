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
	int lengthOfLastWord(const char *s) {

		string t = string(s);

		int length = t.size();

		while(s[length-1] == ' ')
			length--;

		for(int i = length-1; i >= 0 ; i--)
		{
			if(s[i] == ' ')
				return length - i-1;
		}

		return length;
    }

};

#endif