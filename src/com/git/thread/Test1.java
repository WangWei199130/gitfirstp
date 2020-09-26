package com.git.thread;

public class Test1 {

	private static int count = 0;
	
	public static void main(String[] args){
		Thread t1 = new Thread(() ->{
			for(int i=0;i<10000;i++){
				count++;
			}
		});
		Thread t2 = new Thread(() ->{
			for(int i=0;i<10000;i++){
				count--;
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
	}
}
