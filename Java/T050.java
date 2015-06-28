package com.leetcode.practice;

public class T050 {
	 public double myPow(double x, int n) {
		//可以采用倍增法
		 double res = 1;
		 boolean neg = false;
		 
		 if(n < 0){
			 neg = true;
			 n = -n;
		 }
		 
		 double tmp = x;		 
		 int bound = n;
		 
		 while(bound > 0) {
			 long i = 1;
			 
			 for(; i*2 < bound ; i*=2) {
				 tmp = tmp*tmp;
			 }
			 
			 bound -= i;			 
			 res *= tmp;			 
			 tmp = x;
			 	 
		 }
		 
		 if(neg)
			 res = 1/res;
		 
		 return res;
	        
	 }

}
