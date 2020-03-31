package project2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import project2.ver05.Account;
import project2.ver05.MenuChoice;
import project2.ver05.Puzzle;

public class BankingSystemVer05 implements MenuChoice{
	
	static String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	static String ORACLE_URL = "jdbc:oracle:thin://@localhost:1521:orcl";
	
	static int numAcc = 0;
	
	public static PreparedStatement ps;
	public static Statement st;
	public static Connection conn;
	public static ResultSet rs;
	
	public static void connectDB() {
		try {
			Class.forName(ORACLE_DRIVER);
			conn = DriverManager.getConnection(ORACLE_URL, "kosmo", "1234");
		}
		catch(ClassNotFoundException e){
			System.out.println("클래스를 찾지 못하였습니다.");
		}
		catch (SQLException e) {
			System.out.println("DB연결 실패");
		}
		
	}
	
	public static void close() {
		
		try {
			if(ps!=null) ps.close();
			if(st!=null) st.close();
			if(rs!=null) rs.close();
			if(conn!=null) conn.close();
		}
		catch (Exception e) {
			System.out.println("자원반납에 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	
	
	public static void showMenu() {
		connectDB();
		System.out.println("1. 계좌계설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 전체계좌정보출력");
		System.out.println("5. 계좌정보 검색");
		System.out.println("6. 3X3 퍼즐게임");
		System.out.println("7. 프로그램종료");
	}
	
	public static void makeAccount(String aN, String na, int bal) {
		try {
			String sql = "INSERT INTO banking_tb VALUES(seq_banking.nextval,?,?,?)";
			ps = conn.prepareStatement(sql); 
			
			ps.setString(1, aN);
			ps.setString(2, na);
			ps.setInt(3, bal);
			if(ps.executeUpdate()==1) {
				System.out.printf("계좌번호 : %s\n"
						+ "고객이름 : %s\n"
						+ "잔고 : %d\n", aN, na, bal);

				System.out.println("계좌개설이 완료되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void depositMoney(String accN, int money) {
		
		
		try {
			String sql = "update banking_tb set balance = balance + ?"
					+ "where accNum = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, money);
			ps.setString(2, accN);
			
			
			if(ps.executeUpdate()!=0) {
				System.out.println("계좌번호: " + accN);
				System.out.println("입금액: " + money);
				System.out.println("입금이 완료되었습니다.");
			}
			else {
				System.out.println("계좌번호가 잘못되었습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
		
	public static void withdrawMoney(String accN, int money) {
		
		try {
			String sql = "UPDATE banking_tb SET balance = balance - ?"
					+ "WHERE accNum = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2, accN);
			
			if(ps.executeUpdate()!=0) {
				System.out.println("계좌번호: " + accN);
				System.out.println("출금액: " + money);
				System.out.println("출금이 완료되었습니다.");
			}
			else {
				System.out.println("계좌번호가 잘못되었습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void showAccInfo() {
		
		
		try {
			String sql = "SELECT * FROM banking_tb";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			System.out.printf("%-10s | %-10s | %-10s | %-10s\n", 
					"id", "계좌번호", "예금주", "잔고");
			while(rs.next()) {
				int id = rs.getInt(1);
				String acc = rs.getString(2);
				String name = rs.getString(3);
				int balance = rs.getInt(4);
				
				
				System.out.printf("%-10s | %-10s | %-10s | %-10s\n", 
						id, acc, name, balance);
				
			}
			
		} catch (SQLException e) {
			System.out.println("계좌정보 출력에 실패하였습니다.");
		}
	}	
	
	
	public static void searchAcc(String accN) {
		
		try {
			String sql = "SELECT * FROM banking_tb WHERE accNum like '%" + accN + "%'";
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			System.out.printf("%-10s | %-10s | %-10s | %-10s\n", 
					"id", "계좌번호", "예금주", "잔고");
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String acc = rs.getString(2);
				String name = rs.getString(3);
				int balance = rs.getInt(4);
				System.out.printf("%-10s | %-10s | %-10s | %-10s\n", 
						id, acc, name, balance);
				
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("계좌정보 출력에 실패하였습니다.");
		}
		
	}
	
	
	public static void main(String[] args) {
		
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
				makeAccount(accN1, na1, bal1);
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
				showAccInfo();
				System.out.println("전체계좌 정보 출력이 완료되었습니다.");
				break;
				
			case SEARCH:
				System.out.println("***계좌정보 검색***");
				System.out.print("계좌번호:");
				String sear = scan.next();
				searchAcc(sear);
				break;
			case PUZZLE:
				new Puzzle(3).start();
				break;
			case EXIT:
				System.out.println("프로그램을 종료합니다.");
				close();
				System.exit(0);
			default:
				break;
			}
		}
	}

}
