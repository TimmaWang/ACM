#ifndef _104_H
#define _104_H

#include<iostream>
#include<map>
#include<stack>
#include<queue>

using namespace std;

struct TreeNode
{
	char val;
	TreeNode * left;
	TreeNode * right;
	TreeNode(int x) : val(x),left(NULL),right(NULL){}
};

class Solution
{
public:
	int maxDepth(TreeNode *root)
	{
		int maxLeft,maxRight;

		if(root)
		{
			maxLeft = maxDepth(root->left) + 1;
			maxRight = maxDepth(root->right) + 1;

			if(maxLeft > maxRight)
				return maxLeft;
			else
				return maxRight;
		}
		else
			return 0;
	}

	void createTree(TreeNode * &T)
	{
		char value;

		if(cin>>value && value != '#')
		{
			T = new TreeNode(value);

			createTree(T->left);
			createTree(T->right);
		}
		else
		{
			T = NULL;
		}
	}


};

#endif