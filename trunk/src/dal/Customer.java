package dal;

public class Customer {

	protected int CustomerID;                     
	protected String Name;                
	protected String Birth;                 
	protected String Gender;                 
	protected int Phone;
	protected String Adresse;
	protected String Discount;
	
	
	public Customer (int CustomerID, String Name, String Birth, String Gender,int Phone, String Adresse, String Discount)
	{
		this.CustomerID = CustomerID;
		this.Name = Name;
		this.Birth = Birth;
		this.Gender = Gender;
		this.Phone = Phone;
		this.Adresse = Adresse;
		this.Discount = Discount;
	}
	public Customer(){
	
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getDiscount() {
		return Discount;
	}
	public void setDiscount(String discount) {
		Discount = discount;
	}
	
	
	
}
