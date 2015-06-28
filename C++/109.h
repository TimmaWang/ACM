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

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

/*自上而下的方法创建二叉树，即二分法创建，会超时
class Solution
{
public:

	void buildTree(TreeNode *root, int start, int end, vector<int> v)
	{
		if(start <= end)
		{
			int mid = start + (end-start)/2;

			root = new TreeNode(v[mid]);

			buildTree(root->left,start,mid-1,v);
			buildTree(root->right,mid+1,end,v);
		}
		
	}
	TreeNode *sortedListToBST(ListNode *head) {
        vector<int> v;

		ListNode *p = head;

		while(p)
		{
			v.push_back(p->val);
			p = p->next;
		}


		TreeNode * root = NULL;
		int start = 0;
		int end = v.size()-1;

		buildTree(root, start, end, v);

		return root;
    }

};
*/

//好的方法，自下而上法创建二叉树，直接就可以从链表元素依次创建，
//不需要寻找middle值

class Solution {
public:
    TreeNode *sortedListToBST(ListNode *head) {
		ListNode *p = head;
		int len = 0;
		while(p)
		{
			p = p->next;
			len++;
		}
		return buildTree(head,0,len-1);
    }

	TreeNode * buildTree(ListNode * &list, int start, int end)
	{
		if(start > end)
			return NULL;

		int mid = start + (end - start)/2;

		TreeNode * leftChild = buildTree(list,start,mid-1);

		TreeNode * parent = new TreeNode(list->val);

		parent->left = leftChild;

		list = list->next;

		parent->right = buildTree(list,mid+1,end);

		return parent;
	}
};
#endif