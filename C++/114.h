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
 /*这个方法有问题，没有在原来的树的基础上做修改
class Solution
{
public:
	void flatten(TreeNode *root) {


		if(!root)
			return;

		preOrder(root);

		TreeNode  *p;

		root = p = new TreeNode(v[0]);
		//head->left = p->left = NULL;

		for(int i = 1 ; i < v.size() ; i++)
		{
			p->right = new TreeNode(v[i]);
			p->left = NULL;

			p = p->right;
		}

		//root = head;
        
    }

	vector<int> v;

	void preOrder(TreeNode *root)
	{
		if(root)
		{
			v.push_back(root->val);
			preOrder(root->left);
			preOrder(root->right);
		}
	}

};
*/


//先序遍历，记录上一个节点？不是很清楚
class Solution {  
private:  
    TreeNode *node;  
    void flat(TreeNode *root) {  
        if (root != NULL) {  
            if (node != NULL) {  
                node->left = NULL;  
                node->right = root;  
            }  
            node = root;  
            TreeNode *left = root->left;  
            TreeNode *right = root->right;  
            flat(left);  
            flat(right);  
        }          
    }  
      
public:      
    void flatten(TreeNode *root) {  
        node = NULL;  
        flat(root);  
    }  
};  
#endif