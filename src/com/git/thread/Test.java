package com.git.thread;

import java.util.Random;

/**
 * 转账
 * 
 * @author 15001
 *
 */
public class Test {
	
	public static Random random = new Random();

	public static void main(String[] args) {
		Account a = new Account(1000);
		Account b = new Account(1000);
		Thread t1 = new Thread(() -> {
			for(int i=0;i<1000;i++){
				b.transfer(a, randomAmount());
			}
		});
		Thread t2 = new Thread(() -> {
			for(int i=0;i<1000;i++){
				a.transfer(b, randomAmount());
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
		System.out.println(a.getMoney()+b.getMoney());
	}
	
	public static int randomAmount(){
		return random.nextInt(5)+1;
	}
}
