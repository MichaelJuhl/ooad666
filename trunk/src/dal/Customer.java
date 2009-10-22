package dal;

public class Customer {

	protected int CustomerID;                     
	protected String Name;                
	protected String Date;                 
	protected String Gender;                 
	protected int Phone;
	protected String Adresse;	
	
	
	public Customer (int CustomerID, String Name, String Date, String Gender,int Phone, String Adresse)
	{
		this.CustomerID = CustomerID;
		this.Name = Name;
		this.Date = Date;
		this.Gender = Gender;
		this.Phone = Phone;
		this.Adresse = Adresse;
	}
}
