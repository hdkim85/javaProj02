package project2.ver03;

public abstract class Account {
	
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
