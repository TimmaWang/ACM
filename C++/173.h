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

class BSTIterator {
public:
    BSTIterator(TreeNode *root) {

		inOrder(root);

		size = v.size();
		start = 0;
        
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {

		return (size - start);
        
    }

    /** @return the next smallest number */
    int next() {


		return v[start++];
        
    }

	int size,start;

	vector<int> v;

	void inOrder(TreeNode *root)
	{
		if(root)
		{
			inOrder(root->left);
			v.push_back(root->val);
			inOrder(root->right);
		}
	}
};

#endif