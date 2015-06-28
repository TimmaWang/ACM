//unique binary search tree II
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

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

	class Solution {
	public:
		vector<TreeNode *> generateTrees(int n) {
			return buildTree(1,n);
		}

		vector<TreeNode *> buildTree(int start, int end)
		{
			vector<TreeNode *> ret;

			if(start > end)
			{
				ret.push_back(NULL);
				return ret;
			}

		

			for(int k = start; k <= end ; k++)
			{
				vector<TreeNode *> left,right;
				left = buildTree(start, k-1);
				right = buildTree(k+1,end);

				for(int i = 0 ; i < left.size() ; i++)
				{
					for(int j = 0 ; j < right.size() ;j++)
					{
						TreeNode * root = new TreeNode(k);
						root->left = left[i];
						root->right = right[j];

						ret.push_back(root);
					}
				}


			}

			return ret;
		}
	};

#endif