package com.git.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {

	
	public static void main(String[] args) {
		ShareObject shareObject = new ShareObject();
		int forCount = 1000 * 1000;
		Thread t1 = new Thread(() -> {
			for(int i=0;i<forCount;i++){
				shareObject.add();
			}
		});
		t1.start();
		Thread t2 = new Thread(() -> {
			for(int i=0;i<forCount;i++){
				shareObject.add();
			}
		});
		t2.start();
		Thread t3 = new Thread(() -> {
			for(int i=0;i<forCount;i++){
				shareObject.add();
			}
		});
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("计数器："+shareObject.getCalc());
		
		List<String> as = new ArrayList<String>();
		as.add("");
	}
}
