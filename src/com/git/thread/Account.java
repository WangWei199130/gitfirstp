package com.git.thread;

/**
 * 银行账户
 * @author 15001
 *
 */
public class Account {

	private int money;
	
	public Account(int money){
		this.money = money;
	}
	
	/**
	 * 给a账户转账
	 * @param a
	 * @param money
	 */
	public void transfer(Account a,int money){
		synchronized(Account.class) {
			if(this.money >= money){
				this.money -= money;
				a.setMoney(a.getMoney() + money);
			}
		}
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
