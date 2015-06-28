package com.timma.algorithm;

public class T201 {
	public int rangeBitwiseAnd(int m, int n) {
       //解题技巧：找出m和n二进制表示形式的公共头部
		
		int mov = 0;
		if(m > n)
			return 0;
		
		while(m != n && m != 0) {
			m >>= 1;
			n >>= 1;
			
			mov++;
		}
		
		return m <<= mov;            
    }
}
