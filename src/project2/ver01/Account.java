package project2.ver01;

public class Account {
	
	private String accNum;
	private String name;
	private int balance;
	Account[] accArr;
	private int numAcc = 0;
	
	
	public Account(int num) {
		accArr = new Account[num];
	}
	
	private Account(String aN, String na, int bal) {
		accNum = aN;
		name = na;
		balance = bal;
	}
	
	
	void showMenu() {
		System.out.println("1. 계좌계설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 전체계좌정보출력");
		System.out.println("5. 프로그램종료");
	}
	
	void makeAccount(String aN, String na, int bal) {
		
		
		
		Account acc = new Account(aN, na, bal);
		accArr[numAcc++] = acc;
		
		System.out.printf("계좌번호 : %s\n"
				+ "고객이름 : %s\n"
				+ "잔고 : %d\n", aN, na, bal);
		
		System.out.println("계좌개설이 완료되었습니다.");
	}
	
	void depositMoney(String accN, int money) {
		
		for(Account acc : accArr) {
			if(!acc.accNum.equals(accN))
				acc.balance += money;
				System.out.println("계좌번호: " + accN);
				System.out.println("입금액: " + money);
				System.out.println("입금이 완료되었습니다.");
				
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

	void withdrawMoney() {
		
	}
	
	void showAccInfo() {
		
	}
	
}
