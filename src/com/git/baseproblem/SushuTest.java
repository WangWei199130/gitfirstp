package com.git.baseproblem;


/**
 * 求素数
 * @author 15001
 *
 */
public class SushuTest {
	// 如果0开头，则默认是8进制；
	int testi = 0111;
	
	public boolean isSushu(int i){
		boolean result = true;
		for(int j=2;j<i;j++){
			if(i%j == 0){
				result = false;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
//		SushuTest test = new SushuTest();
//		System.out.println(test.testi);
//		System.out.println(Integer.parseInt("000111"));
		int a = '0'; // 48
		int b = '-'; // 45
		int c = '+'; // 43
//		System.out.println(-c);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
