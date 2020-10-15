package com.git.thread;


public class Test4 {

	private final Object obj1 = new Object();
	
	private final Object obj2 = new Object();
	
	public void study(){
		synchronized (obj1) {
			System.out.println("先学习");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (obj2) {
				System.out.println("然后睡觉");
			}
		}
	}
	
	public void sleep(){
		synchronized (obj2) {
			System.out.println("先睡觉");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (obj1) {
				System.out.println("然后学习");
			}
		}
	}
	
	public static void main(String[] args) {
		Test4 test = new Test4();
		new Thread(() -> {
			test.study();
		},"t1").start();
		
		new Thread(() -> {
			test.sleep();
		},"t2").start();;
	}
}
