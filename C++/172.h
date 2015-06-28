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
/*从1-n中找出5的幂和2的幂的个数，尾数0个数=min(5的幂，2的幂)
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
//可以根据编程之美中的公式求解
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