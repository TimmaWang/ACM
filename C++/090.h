//subsets II
#ifndef _LEETCODE_H
#define _LEETCODE_H

#include<iostream>
#include<string>
#include<vector>
#include<stack>
#include<map>
#include<queue>
#include<set>
#include<algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int> > subsetsWithDup(vector<int> &S) {
        set<vector<int>> t;
		vector<vector<int>> v;
		vector<int> tmp;

		sort(S.begin(),S.end());
		dfs(S,tmp,t,0);

		set<vector<int>>::iterator it;

		for(it = t.begin() ; it != t.end(); it++)
		{
			v.push_back(*it);
		}

		return v;
    }

	void dfs(vector<int> &s, vector<int> tmp, set<vector<int>> &ret, int level)
	{
		if(level == s.size())
		{
			ret.insert(tmp);
			return;
		}

		dfs(s,tmp,ret,level+1);

		tmp.push_back(s[level]);

		dfs(s,tmp,ret,level+1);
	}
};
#endif