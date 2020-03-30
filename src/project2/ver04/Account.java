package project2.ver04;

import java.io.Serializable;

public abstract class Account implements Serializable{
	
	private String accNum;
	private String name;
	private int balance;
	
	public Account(String aN, String na, int bal) {
		accNum = aN;
		name = na;
		balance = bal;
	}
	
	public void showAccInfo() {
			
			System.out.println("---------------");
			System.out.println("계좌번호: " + accNum);
			System.out.println("이름: " + name);
			System.out.println("잔고: " + balance);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accNum == null) ? 0 : accNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Account acc = (Account) obj;
		if(acc.accNum.equals(this.accNum)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}


	
}
