//remove Nth node from end of list
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

class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {

		ListNode * first = head;
		ListNode * second = head;

		int step = n;

		while(step)
		{
			first = first->next;
			step--;
		}

		if(!first)
		{
			head = head->next;

			return head;
		}

		while(first->next)
		{
			first = first->next;
			second = second->next;
		}

		second->next = second->next->next;

		return head;

        
    }
};

#endif