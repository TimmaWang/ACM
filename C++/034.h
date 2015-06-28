//search for a range
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

class Solution {
public:
    vector<int> searchRange(int A[], int n, int target) {

		int l,r,mid,start,end;

		vector<int> v;

		l = 0;
		r = n-1;

		while(l <= r)
		{
			mid = l + (r-l)/2;

			if(A[mid] == target)
			{
				start = end = mid;

				while(A[start] == target)
				{
					start--;
					if(start < 0)
					{
						start = -1;
						break;
					}
				}
				while(A[end] == target)
				{
					end++;
					if(end > n-1)
					{
						end = n;
						break;
					}
				}

				v.push_back(start+1);
				v.push_back(end-1);

				return v;


				
			}

			if(A[mid] < target)
			{
				while(A[mid] == A[mid+1])
					mid++;

				l = mid+1;
			}
			else
			{
				while(A[mid] == A[mid-1])
					mid--;

				r = mid-1;
			}

		}

		v.push_back(-1);
		v.push_back(-1);

		return v;
        
    }
};
#endif