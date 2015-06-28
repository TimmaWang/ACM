//partition list
#ifndef _LEETCODE_H
#define _LEETCODE_H

#include<iostream>
#include<string>
#include<vector>
#include<stack>
#include<map>
#include<queue>
#include<algorithm>
#include<set>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution {
public:
    ListNode *partition(ListNode *head, int x) {

		if(!head)
			return NULL;
        int size = 0;

		ListNode *tail = head, *stop;
		ListNode *cur = head,*pre;

		while(tail->next)
		{
			tail = tail->next;
		}

		stop = tail;

		while(cur != stop)
		{
			if(cur->val >= x)
			{
				tail->next = new ListNode(cur->val);
				tail = tail->next;
				if(cur == head)
				{
					head = head->next;
					cur = head;
				}
				else
				{
					pre->next = cur->next;
					cur = cur->next;
				}
			}
			else
			{
				pre = cur;
				cur = cur->next;
			}
		}

		if(cur->val >= x)
		{
			tail->next = new ListNode(cur->val);
			tail = tail->next;
			if(cur == head)
			{
				head = head->next;
				cur = head;
			}
			else
			{
				pre->next = cur->next;
				cur = cur->next;
			}
		}
		else
		{
			pre = cur;
			cur = cur->next;
		}

		return head;

    }
};

#endif