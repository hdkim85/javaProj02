package project2.ver05;

public class Account{
	
	private String accNum;
	private String name;
	private int balance;
	
	public Account(String aN, String na, int bal) {
		accNum = aN;
		name = na;
		balance = bal;
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
