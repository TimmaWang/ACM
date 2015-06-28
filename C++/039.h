//combination sum
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

class Solution {
public:
	int m[100];
	vector<vector<int>> v;
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
		sort(candidates.begin(),candidates.end());

		int k = (target/candidates[0]) + 1;

		for(int i = 0 ; i < k ; i++)
			backtracking(candidates,0,i,target);

		return v;
        
    }

	void backtracking(vector<int> &candidates, int i, int k, int target)
	{
		if(i == k)
		{
			int sum = 0;
			for(int a = 0 ; a < i ; a++)
				sum += m[a];

			if(sum == target)
			{
				vector<int> tmp;
				for(int a = 0 ; a < i ; a++)
				{
					tmp.push_back(m[a]);
				}
				v.push_back(tmp);

			}
		}
		else
		{
			for(int q = 0 ; q < candidates.size() ; q++)
			{
				m[i] = candidates[q];

				if(i > 0 && m[i-1] > m[i])
					continue;
				
				backtracking(candidates,i+1,k,target);
			}
			
		}
	}
};
#endif