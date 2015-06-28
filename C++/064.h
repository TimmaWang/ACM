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
	int c[300][300];

	int minPathSum(vector<vector<int> > &grid) {

		int m = grid.size();
		int n = grid[0].size();
		int sum = 0;

		for(int i = 0 ; i < m ; i++)
		{
			sum += grid[i][0];
			c[i][0] = sum;			
		}

		sum = 0;
		for(int j = 0 ; j < n ; j++)
		{
			sum += grid[0][j];
			c[0][j] = sum;			
		}

		for(int i = 1 ; i < m ; i++)
		{
			for(int j = 1; j < n ; j++)
			{
				if(c[i-1][j] > c[i][j-1])
					c[i][j] = c[i][j-1] + grid[i][j];
				else
					c[i][j] = c[i-1][j] + grid[i][j];
			}
		}


		return c[m-1][n-1];
    }

};

#endif