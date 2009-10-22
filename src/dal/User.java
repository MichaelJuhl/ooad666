package dal;

public class User {
	
	protected int UserID;                     
	protected String Name;                
	protected double CPR;                 
	protected String Gender;                 
	protected int Phone;
	protected String Adresse;
	protected String Password;
	protected String Rank;
	
	
	public User(int UserID, String Name, double CPR, String Gender, int Phone, String Address, String Password, String Rank){
		this.UserID = UserID;
		this.Name = Name;
		this.CPR = CPR;
		this.Gender = Gender;
		this.Phone = Phone;
		this.Adresse = Address;
		this.Password = Password;
		this.Rank	= Rank;
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

	public double getCPR() {
		return CPR;
	}

	public void setCPR(double cpr) {
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

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRank() {
		return Rank;
	}

	public void setRank(String rank) {
		Rank = rank;
	}

}