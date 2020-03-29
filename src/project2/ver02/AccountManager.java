package project2.ver02;

import java.util.Scanner;

import project2.ver02.Account;

public class AccountManager implements MenuChoice{
	static int numAcc = 0;
	Scanner scan = new Scanner(System.in);
	Account[] accArr;
	
	public AccountManager(int num) {
		accArr = new Account[num];
	}
	
	public void start() {
		
		while(true) {

			showMenu();
			int choice = scan.nextInt();

			switch (choice) {
			case MAKE:
				System.out.println("***신규계좌 개설***");
				makeAccount();
				break;

			case DEPOSIT:
				System.out.println("***입  금***");
				System.out.print("계좌번호:");
				String accN2 = scan.next();
				System.out.print("입금액:");
				int money2 = scan.nextInt();
				depositMoney(accN2, money2);
				break;

			case WITHDRAW:
				System.out.println("***출  금***");
				System.out.print("계좌번호:");
				String accN3 = scan.next();
				System.out.print("출금액:");
				int money3 = scan.nextInt();
				withdrawMoney(accN3, money3);
				break;

			case INQUIRE:
				System.out.println("***전체 계좌정보 출력***");	
				showInfo();
				System.out.println("전체계좌 정보 출력이 완료되었습니다.");
				break;

			case EXIT:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				break;
			}
		}


	}

	public void showMenu() {
		
		System.out.println("1. 계좌계설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 전체계좌정보출력");
		System.out.println("5. 프로그램종료");
	}
	
	public void makeAccount() {
		
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		int num = scan.nextInt();
		
		System.out.print("계좌번호:");
		String aN = scan.next();
		System.out.print("이름:");
		String na = scan.next();
		System.out.print("잔고:");
		int bal = scan.nextInt();
		
		if(num == 1) {
			System.out.printf("기본이자(%, 정수형태로 입력):");
			int ir = scan.nextInt();
			
			NormalAccount normalAccount = new NormalAccount(aN, na, bal, ir);
			accArr[numAcc++] = normalAccount;
			System.out.printf("계좌번호 : %s\n"
					+ "고객이름 : %s\n"
					+ "잔고 : %d\n"
					+ "기본이자 : %d"
					, normalAccount.getAccNum(), normalAccount.getName(),
					normalAccount.getBalance(), normalAccount.getInterest()
					);
			
			System.out.println("계좌개설이 완료되었습니다.");
		}
		else {
			System.out.printf("기본이자(%, 정수형태로 입력):");
			int ir = scan.nextInt();
			System.out.printf("신용등급(A, B, C등급:");
			String cr = scan.next();
			
			HighCreditAccount highCreditAccount = new HighCreditAccount(aN, na, bal, ir, cr);
			accArr[numAcc++] = highCreditAccount;
			System.out.printf("계좌번호 : %s\n"
					+ "고객이름 : %s\n"
					+ "잔고 : %d\n"
					+ "기본이자 : %d"
					+ "신용등급 : %s",
					highCreditAccount.getAccNum(),
					highCreditAccount.getName(),
					highCreditAccount.getBalance(),
					highCreditAccount.getInterest(),
					highCreditAccount.getCreditRate());
			
			System.out.println("계좌개설이 완료되었습니다.");
		}
	}
	
	public void depositMoney(String accN, int money) {
		
		for(int i = 0; i<numAcc; i++) {
			if(accArr[i].getAccNum().equals(accN)) {
				accArr[i].setBalance(accArr[i].getBalance()+money);
				System.out.println("계좌번호: " + accArr[i].getAccNum());
				System.out.println("입금액: " + money);
				System.out.println("입금이 완료되었습니다.");
			}
			else {
				System.out.println("계좌가 없습니다.");
			}
		}
	}
		
	public void withdrawMoney(String accN, int money) {
		
		for(int i = 0; i<numAcc; i++) {
			if(accArr[i].getAccNum().equals(accN)) {
				if(accArr[i].getBalance() < money) {
					System.out.println("잔액이 부족합니다.");
				}
				else {
					accArr[i].setBalance(accArr[i].getBalance()-money);
					System.out.println("계좌번호: " + accArr[i].getAccNum());
					System.out.println("출금액: " + money);
					System.out.println("출금이 완료되었습니다.");
				}
			}
			else {
				System.out.println("계좌가 없습니다.");
			}	
		}
	}
	
	public void showInfo() {
		
		for (int i=0; i<numAcc; i++) {
			
			accArr[i].showAccInfo();
		}
		
	}
	
	
}
