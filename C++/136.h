#ifndef _136_H
#define _136_H

#include<iostream>
#include<map>

using namespace std;
class Solution
{
public:
	int SingleNumber(int A[], int n)
	{
		map<int, int> count;
		
		for(int i = 0 ; i < n ; i++)
		{
			if(count.find(A[i]) == count.end())
				count[A[i]] = 1;
			else
				count[A[i]] = 2;
		}

		map<int, int>::iterator it;

		for(it = count.begin() ; it != count.end() ; it++)
		{
			if(it->second != 2)
				return it->first;
		}
	}
};

#endif