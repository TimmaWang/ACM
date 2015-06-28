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

/*递归方法一般都出现超时的现象
class Solution
{
public:
	int sum;

	int unique(int i, int j, vector<vector<int> > &obstacleGrid)
	{
		if(i == 0 || j == 0)
		{
			return 1;
		}
		else if(obstacleGrid[i][j] == 1)
		{
			return 0;
		}
		else
		{
			return unique(i-1,j,obstacleGrid)+unique(i,j-1,obstacleGrid);
		}
	}
	int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {

		int m = obstacleGrid.size();
		int n = obstacleGrid[0].size();
		sum = unique(m-1,n-1,obstacleGrid);

		return sum;
    }

};
*/

//非递归方法
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {
        int s[100][100];

		int m = obstacleGrid.size();
		int n = obstacleGrid[0].size();

		s[0][0] = 1-obstacleGrid[0][0];

		for(int i = 1 ; i < m ; i++)
		{
			if(obstacleGrid[i][0] == 1)
				s[i][0] = 0;
			else
				s[i][0] = s[i-1][0];
		}

		for(int i = 1 ; i < n ; i++)
		{
			if(obstacleGrid[0][i] == 1)
				s[0][i] = 0;
			else
				s[0][i] = s[0][i-1];
		}


		for(int i = 1 ; i < m ; i++)
		{
			for(int j = 1 ; j < n ; j++)
			{
				if(obstacleGrid[i][j] == 1)
				{
					s[i][j] = 0;
				}
				else
					s[i][j] = s[i-1][j] + s[i][j-1];
			}
		}

		return s[m-1][n-1];
    }
};
#endif