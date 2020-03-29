package project2;

import java.util.Scanner;

import project2.ver01.Account;
import project2.ver01.MenuChoice;

public class BankingSystemVer01 implements MenuChoice{
	
	static int numAcc = 0;
	
	public static void showMenu() {
		
		System.out.println("1. 계좌계설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 전체계좌정보출력");
		System.out.println("5. 프로그램종료");
	}
	
	public static void makeAccount(Account[] accArr, String aN, String na, int bal) {

		Account acc = new Account(aN, na, bal);
		accArr[numAcc++] = acc;
		System.out.printf("계좌번호 : %s\n"
				+ "고객이름 : %s\n"
				+ "잔고 : %d\n", acc.getAccNum(), acc.getName(), acc.getBalance());

		System.out.println("계좌개설이 완료되었습니다.");
	}
	
	public static void depositMoney(Account[] accArr, String accN, int money) {
		
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
		
	public static void withdrawMoney(Account[] accArr, String accN, int money) {
		
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

	public static void showAccInfo(Account[] accArr) {
		for(int i=0; i<numAcc; i++) {
			
			System.out.println("---------------");
			System.out.println("계좌번호:" + accArr[i].getAccNum());
			System.out.println("이름" + accArr[i].getName());
			System.out.println("잔고" + accArr[i].getBalance());
			System.out.println("---------------");
		}
	}	
	
	public static void main(String[] args) {
		
		Account[] account = new Account[50];
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			
			showMenu();
			int choice = scan.nextInt();
			
			switch (choice) {
			case MAKE:
				System.out.println("***신규계좌 개설***");
				System.out.print("계좌번호:");
				String accN1 = scan.next();
				System.out.print("이름:");
				String na1 = scan.next();
				System.out.print("잔고:");
				int bal1 = scan.nextInt();
				makeAccount(account, accN1, na1, bal1);
				break;
				
			case DEPOSIT:
				System.out.println("***입  금***");
				System.out.print("계좌번호:");
				String accN2 = scan.next();
				System.out.print("입금액:");
				int money2 = scan.nextInt();
				depositMoney(account, accN2, money2);
				break;
				
			case WITHDRAW:
				System.out.println("***출  금***");
				System.out.print("계좌번호:");
				String accN3 = scan.next();
				System.out.print("출금액:");
				int money3 = scan.nextInt();
				withdrawMoney(account, accN3, money3);
				break;
				
			case INQUIRE:
				System.out.println("***전체 계좌정보 출력***");	
				showAccInfo(account);
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

}
