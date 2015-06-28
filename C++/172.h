//factorial trailing zeros
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
/*��1-n���ҳ�5���ݺ�2���ݵĸ�����β��0����=min(5���ݣ�2����)
class Solution {
public:
    int trailingZeroes(int n) {

        int size5,size2;

		size5 = size2 = 0;

		if(n == 0)
			return 0;

		for(int i = 1 ; i <= n ; i++)
		{
			int k = i;
			while(k%5 == 0)
			{
				k = k /5;
				size5++;
			}

			//while(k%2 == 0)
			//{
			//	k = k/2;
			//	size2++;
			//}
		}

		//return min(size5,size2);
		return size5;
    }
};
*/
//���Ը��ݱ��֮���еĹ�ʽ���
class Solution {
public:
    int trailingZeroes(int n) {

		int ret = 0;

		while(n)
		{
			ret += n/5;
			n /= 5;
		}

		return ret;
        
    }
};

#endif