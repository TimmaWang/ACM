package com.timma.algorithm;

public class T223 {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C-A)*(D-B)+(G-E)*(H-F);
        
        //�ж��Ƿ����ص�
        //����
        if(C <= E || H <= B || G <= A || D <= F)
        	return area;
        
        //����
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        
        return area - (top-bottom)*(right-left);
    }

}
