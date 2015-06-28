//intersection of two linked lists
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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {

		int lengthA = 0, lengthB = 0;

		ListNode *pA, *pB;

		pA = headA;
		pB = headB;

		while(pA)
		{
			lengthA++;
			pA = pA->next;
		}

		while(pB)
		{
			lengthB++;
			pB = pB->next;
		}

		pA = headA;
		pB = headB;

		if(lengthA > lengthB)
		{
			int size = lengthA  - lengthB;
			while(size--)
			{
				pA = pA->next;
			}
		}
		else
		{
			int size = lengthB  - lengthA;
			while(size--)
			{
				pB = pB->next;
			}
		}

		while(pA && pB)
		{
			if(pA == pB)
				return pA;
			else
			{
				pA = pA->next;
				pB = pB->next;
			}
		}

		return NULL;
        
    }
};

#endif