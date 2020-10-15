package com.git.thread;


public class Test7 {

	public static void main(String[] args) {
		// AtomicInteger sharedVal = new AtomicInteger(1000);
		NewInt sharedVal = new NewInt(1000);
		for(int i=0;i<100;i++){
			new Thread(() ->{
				// sharedVal.getAndUpdate(p -> p-10);
				sharedVal.autoDecreat();
			}).start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sharedVal.getValue());
	}
}

class NewInt{
	
	int value;
	
	public NewInt(int value){
		this.value = value;
	}
	
	public void autoDecreat(){
		this.value -= 10;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
