package dal;

import java.util.Calendar;

public class Member {

	protected int memberID;                     
	protected String name;                
	protected String birth;                 
	protected String gender;                 
	protected int phone;
	protected String adresse;
	protected String discount;
	
	
	public Member (int CustomerID, String Name, String Birth, String Gender,int Phone, String Adresse, String Discount)
	{
		this.memberID = CustomerID;
		this.name = Name;
		this.birth = Birth;
		this.gender = Gender;
		this.phone = Phone;
		this.adresse = Adresse;
		this.discount = Discount;
	}
	public Member(){
	
	}
	public Member(String text, Calendar birthTime, String selectedItem,
			Integer valueOf, String text2) {
		// TODO Auto-generated constructor stub
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
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
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	
	
}
