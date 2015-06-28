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

class Solution
{
public:
	int minDepth(TreeNode *root) {
		int leftmin,rightmin;
		
		if(root)
		{
			if(root->left && root->right)
			{
				leftmin = minDepth(root->left);
				rightmin = minDepth(root->right);
				return min(leftmin,rightmin)+1;
			}
			else if(root->left)
			{
				return minDepth(root->left)+1;
			}
			else if(root->right)
				return minDepth(root->right)+1;
			else
				return 1;

		}
		else
			return 0;
        
    }

};

#endif