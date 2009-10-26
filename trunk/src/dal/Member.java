package dal;

public class Member {

	protected int CustomerID;                     
	protected String Discount;                

	public Member (int CustomerID, String Discount)
	{
		this.CustomerID = CustomerID;
		this.Discount = Discount;
	}

	public Member(){
	 
 }

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public String getDiscount() {
		return Discount;
	}

	public void setDiscount(String discount) {
		Discount = discount;
	}

	
}
