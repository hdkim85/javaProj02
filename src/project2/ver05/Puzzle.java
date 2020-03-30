package project2.ver05;

import java.util.Random;
import java.util.Scanner;

public class Puzzle {
	
	int sc = 0;
	
	String[][] puzzle;
	String[][] corr;
	
	public Puzzle(int sCnt) {
		
		puzzle = new String[3][3];
		sc = sCnt;
		String[] num = {"1","2","3","4","5","6","7","8","x"};
		int cnt = 0;
		
		for(int i = 0 ; i<puzzle.length ; i++) {
			for (int j = 0 ; j<puzzle[i].length ; j++) {
				puzzle[i][j] = num[cnt++];
			}
		}
		
		corr = new String[3][3];
		int ct = 0;
		
		for(int i = 0 ; i<corr.length ; i++) {
			for (int j = 0 ; j<corr[i].length ; j++) {
				corr[i][j] = num[ct++];
			}
		}
		
		shuffle(sCnt);
	}
	
	public void shuffle(int sCnt) {
		for(int i=0; i<sCnt; i++) {
			
			Random rand = new Random();
			switch ((rand.nextInt(4)+1)) {
			case 1:
				move("w");
				break;
			case 2:
				move("s");
				break;
			case 3:
				move("a");
				break;
			case 4:
				move("d");
				break;
			default:
				break;
			}
		}
	}
	
	
	public void start() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("게임시작");
		
		while(true) {
			show();
			System.out.println("[이동] a:Left d:Right w:Up s:Down");
			System.out.println("[종료] x: Exit");
			System.out.println("키를 입력해주세요 :");
			
			String input = scan.next();
			
			if(input.equals("x"))
				System.exit(0);
			
			move(input);
			boolean ans = answer();
			
			if(ans) {
				show();
				System.out.println("==^^정답입니다^^==");
				System.out.println("재시작하시겠습니까?(y누르면 재시작, 나머지는 종료)");
				String cho = scan.next();
				if(!(cho.toLowerCase().equals("y"))) {
					break;
				}
				shuffle(sc);
				System.out.println();
			}
		}
	}
	
	public void show() {
		
		System.out.println("=============");
		for(int i = 0 ; i<puzzle.length ; i++) {
			for (int j = 0 ; j<puzzle[i].length ; j++) {
				System.out.print(puzzle[i][j] + " " );
			}
			System.out.println();
		}
		System.out.println("=============");
	}
	
	int row = 0;
	int col = 0;
	
	public void findLoc() {
		for(int i = 0 ; i<puzzle.length ; i++) {
			for (int j = 0 ; j<puzzle[i].length ; j++) {
				if(puzzle[i][j]=="x") {
					row = i;
					col = j;
					break;
				}
			}
		}
	}
	
	public void move(String arr) {
		
		try {
			switch (arr) {
			case "w"://up
				findLoc();
				puzzle[row][col] = puzzle[row+1][col];
				puzzle[row+1][col] = "x";
				break;
			case "s"://down
				findLoc();
				puzzle[row][col] = puzzle[row-1][col];
				puzzle[row-1][col] = "x";
				break;
			case "a":
				findLoc();
				puzzle[row][col] = puzzle[row][col+1];
				puzzle[row][col+1] = "x";
				break;
			case "d":
				findLoc();
				puzzle[row][col] = puzzle[row][col-1];
				puzzle[row][col-1] = "x";
				break;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("xxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("xxxxxxxx이동불가xxxxxxxxx");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxx");
		}
	}
	
	public boolean answer() {
		
		int ans = 0;
		for(int i = 0 ; i<puzzle.length ; i++) {
			for (int j = 0 ; j<puzzle[i].length ; j++) {
				if(puzzle[i][j].equals(corr[i][j])) {
					ans++;
				}
				if(ans==9) {
					return true;
				}
			}
		}
		return false;
	}
}
