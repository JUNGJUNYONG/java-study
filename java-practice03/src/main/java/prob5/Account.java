package prob5;

public class Account {

	private String accountNo; // 계좌 번호
	private int balance; //계좌 잔고
	
	
	public Account(String accountNo)
	{
		this.accountNo = accountNo;
		System.out.println(this.accountNo + "계좌가 개설되었습니다.");
	}
	
	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public void save(int input) {
		this.balance += input;
		System.out.println(this.accountNo + "계좌에 " + input + "만원이 입금되었습니다.");
	}

	public void deposit(int output) {
		this.balance -= output;
		System.out.println(this.accountNo + "계좌에 " + output + "만원이 출금되었습니다.");
	}
	
	
	
}