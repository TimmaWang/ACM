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
	int longestConsecutive(vector<int> &num) {

		if(num.empty())
				return 0;
        map<int,int> m;
		map<int,int>::iterator it;
		int maxsize = 1;
		int current;

		for(int i = 0 ; i < num.size() ; i++)
		{
			it = m.find(num[i]);
			if(it != m.end() )
				m[num[i]]++;
			else
				m[num[i]] = 1;
		}

		for(int i = 0 ; i < num.size() ; i++)
		{
			current = 1;
			if(!m[num[i]])
				continue;
			m[num[i]] = 0;
			int number = num[i]+1;

			it = m.find(number);
			while(it != m.end())
			{
				if(m[number] == -1)
					break;
				m[number] = -1;
				current++;
				number++;
				it = m.find(number);
			}

			number = num[i]-1;

			it = m.find(number);
			while(it != m.end())
			{
				if(m[number] == -1)
					break;
				m[number] = -1;
				current++;
				number--;
				it = m.find(number);
			}

			if(current > maxsize)
				maxsize = current;

		}

		return maxsize;

    }

};

#endif