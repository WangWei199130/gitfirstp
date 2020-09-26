package com.git.thread;

/**
 * 线程共享对象
 * @author 15001
 *
 */
public class ShareObject {
	
	private int calc = 0;
	
	public void add(){
		calc++;
	}

	public int getCalc() {
		return calc;
	}

	
	
}
