package project2.ver02;

public class NormalAccount extends Account{
	
	private int interest;
	public NormalAccount(String aN, String na, int bal, int ir) {
		super(aN, na, bal);
		this.interest = ir;
	}
	
	@Override
	public void showAccInfo() {
		// TODO Auto-generated method stub
		super.showAccInfo();
		System.out.println("기본이자 :" + interest);
		
	}
	
	
	
	
	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}
	
	
	
	

	
}
