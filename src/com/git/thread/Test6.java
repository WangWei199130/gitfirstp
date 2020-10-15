package com.git.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Test6 {

	public static void main(String[] args) {
		Printer printer = new Printer(5);
		Condition a = printer.newCondition();
		Condition b = printer.newCondition();
		Condition c = printer.newCondition();
		new Thread(()->{
			printer.print("a", a, b);
		},"t1").start();
		
		new Thread(()->{
			printer.print("b", b, c);
		},"t1").start();
		
		new Thread(()->{
			printer.print("c", c, a);
		},"t1").start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printer.lock();
		try{
			System.out.println("开始....");
			a.signal();
		}finally{
			printer.unlock();
		}
	}
}

class Printer extends ReentrantLock {

	private int loopNumber;
	
	public Printer(int loopNumber){
		this.loopNumber = loopNumber;
	}
	
	public void print(String printStr,Condition current,Condition nextCondi){
		for(int i=0;i<loopNumber;i++){
			lock();
			try {
				current.await();
				System.out.print(printStr);
				nextCondi.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				unlock();
			}
		}
	}
}