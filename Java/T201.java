package com.timma.algorithm;

public class T201 {
	public int rangeBitwiseAnd(int m, int n) {
       //���⼼�ɣ��ҳ�m��n�����Ʊ�ʾ��ʽ�Ĺ���ͷ��
		
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
