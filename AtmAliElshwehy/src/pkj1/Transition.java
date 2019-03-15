package pkj1;

public class Transition {
private double balance = 0.0; private int count = -1; final private String cardNo = "5304";
private int index = 0 ;
private short flage2 = 0;
short check;
private short flage;
private double history [][]= new double [5][3];
public double getBalance(){
	if(this.count<0)
		this.index=this.count+1;
	else 
		this.index=this.count;
	return balance;
}
public int getCount() {
	return count;
}

public void setBalance(double balance) {
	
	if((balance+this.balance)>0)
	{	if(this.count>=4)
			{
				this.count =0;
				flage2 =1;
				
			}
	else{
		this.count++;
		
		}
	if (balance < 0 )
		flage = 1;
	else 
		flage = 2;
		
	
	history[this.count][2]=balance;
	this.balance = balance+this.balance;
	history[this.count][0]=this.balance;history[this.count][1]=flage;
	this.index = this.count   ;
	check =1;
}
	else 
		check = -1;
	
	}
public String getCardNo() {
	
	return cardNo;
}
public String history(int x){
	if (x==1){//next
		this.index++;
		if(this.count==-1)
			return "There is no Transactions yet";
			if(flage2 == 0){
				if(this.index>this.count/*||this.index<0*/){
					this.index=0;
					}
}
		else{
			if(this.index>4/*||this.index<0*/){
				this.index=0;
				}
		}
		if(history[this.index][1]==1)
			return "You have withdraw Transaction  "+Double.toString(history[this.index][2]*-1);
		else 
			return  "You have deposit Transaction  "+Double.toString(history[this.index][2]);
	}
	
	else if (x==2){//prev
		this.index--;
		if(this.count==-1)
			return "There is no Transactions yet";
			if(flage2==0){
				if(this.index<0){
					if(this.count<0)
						this.index=this.count+1;
					else 
						this.index=this.count;
					}
		}
		else{
			if(this.index<0){
				this.index=4;
				}
		}
		if(history[this.index][1]==1)
			return "You have withdraw Transaction  "+Double.toString(history[this.index][2]*-1);
		else 
			return  "You have deposit Transaction  "+Double.toString(history[this.index][2]);
	
	}
	else 
		return null;
		
	}
}


