package project2.ver02;

public class HighCreditAccount extends Account{
	
	private int interest;
	private String creditRate;
	
	public HighCreditAccount(String aN, String na, int bal, int interest, String cr) {
		super(aN, na, bal);
		this.interest = interest;
		this.creditRate = cr;
	}
	
	public getCrInterest() {
		
		
	}
	
	
	@Override
	public void showAccInfo() {
		// TODO Auto-generated method stub
		super.showAccInfo();
		System.out.println("기본이자: " + interest);
		System.out.println("신용등급: " + creditRate);
		
	}
	
	
	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public String getCreditRate() {
		return creditRate;
	}

	public void setCreditRate(String creditrate) {
		this.creditRate = creditrate;
	}


	
	
	
}