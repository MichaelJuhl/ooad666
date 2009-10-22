package dal;

public class User {
	
	protected int UserID;                     
	protected String Name;                
	protected String CPR;                 
	protected String Gender;                 
	protected int Phone;
	protected String Adresse;	
	
	
	public User(int UserID, String Name, String CPR, String Gender, int Phone, String Address){
		this.UserID = UserID;
		this.Name = Name;
		this.CPR = CPR;
		this.Gender = Gender;
		this.Phone = Phone;
		this.Adresse = Address;
	}
	
	public User(){
		
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCPR() {
		return CPR;
	}

	public void setCPR(String cpr) {
		CPR = cpr;
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

}
