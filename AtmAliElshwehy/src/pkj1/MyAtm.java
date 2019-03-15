package pkj1;
interface ATM {
	//Returnsthe current balance
	public String getCurrentBalance();
	//withdraws from current balance and update
	public void withdraw(String amount);
	//adds to the current balance and update
	public void deposit (String amount);
	//returns the prevtransaction
	public String prev();
	//returns the next transaction
	public String next();
	// checks the valdiation of the card
	public int Check(String no);
}
public class MyAtm implements ATM {
Transition T = new Transition();
	
	public String getCurrentBalance() {
		
		return "Your current Balance is: "+Double.toString(T.getBalance());
	}

	
	public void withdraw(String amount) {
		if (amount.length()<=0){
			T.setBalance(0);
			}
		else
			T.setBalance(Double.parseDouble(amount)*-1);	
	
	}

	
	public void deposit(String amount) {
		
		if (amount.length()<=0){
			T.setBalance(0);
			}
		else
		T.setBalance(Double.parseDouble(amount));		
	}

	@Override
	public String prev() {
		
			return T.history(2);
		
	
		}
	

	@Override
	public String next() {
	return T.history(1);
	}

	@Override
	public int Check(String no) {
		String card = T.getCardNo();
		
		if (card.equals(no)==true){
		return 1;
	}
		else {
		return 0;
	}
		}
}
