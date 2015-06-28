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

/*用回溯模板做的话，发现有重复元素
class Solution
{
public:

	int m[100];

	vector<vector<int>> v;
	vector<vector<int> > subsets(vector<int> &S) {

		for(int k = 1 ; k <= S.size(); k++)
		{
			backtracking(0, k, S.size(), S);
		}

		return v;
        
    }

	void backtracking(int i, int k, int n, vector<int> &S)
	{
		if(i == k)
		{
			vector<int> tmp;

			for(int a = 0 ; a < k ; a++)
			{
				tmp.push_back(m[a]);
				cout<<m[a]<<" ";
			}

			cout<<endl;
			v.push_back(tmp);
		}
		else
		{
			for(int p = 0 ; p < n ; p++)
			{
				m[i] = S[p];
				bool check = true;

				for(int q = 0 ; q < i ; q++)
				{
					if(m[i] == m[q])
					{
						check = false;
						break;
					}
				}

				if(check)
					backtracking(i+1, k , n, S);
			}
		}
	}

};
*/

//构建一个状态二叉树，level表示当前节点，有两个状态：加、不加
class Solution {
public:
    vector<vector<int> > subsets(vector<int> &S) {
		vector<vector<int> > result;
		vector<int> tmp;

		sort(S.begin(),S.end());

		recuisive(S,tmp,0,result);

		return result;
        
    }

	void recuisive(vector<int> &S,vector<int> tmp,int level,vector<vector<int> > &result)
	{
		if(level == S.size())
		{
			result.push_back(tmp);
			return ;
		}
		else
		{
			recuisive(S,tmp,level+1,result);

			tmp.push_back(S[level]);

			recuisive(S,tmp,level+1,result);

		}
	}
};

#endif