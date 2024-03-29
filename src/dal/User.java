package dal;

public class User {
	
	protected int userID;                     
	protected String name;                
	protected int cpr;                 
	protected String gender;                 
	protected int phone;
	protected String address;
	protected String password;
	protected String rank;
	
	
	public User(int userID, String name, int cpr, String gender, int phone, String address, String password, String rank){
		this.userID = userID;
		this.name = name;
		this.cpr = cpr;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.password = password;
		this.rank = rank;
	}
	
	//for GUI to DB -auto userid, and for wrong login
	public User() {
		// all fields == null
	}



	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCPR() {
		return cpr;
	}

	public void setCPR(int cpr) {
		this.cpr = cpr;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAdresse() {
		return address;
	}

	public void setAdresse(String adresse) {
		this.address = adresse;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRank() {
		return rank;
	}
	
	public int getRankAsInt() {
		if (rank.equals("Billetsælger"))
			return 1;
		else if (rank.equals("Kontormedarbejder"))
				return 2;
		else if (rank.equals("Admin"))
				return 3;
		else
			return -1;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}
