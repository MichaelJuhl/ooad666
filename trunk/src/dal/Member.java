package dal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Member {

	protected int memberID;                     
	protected String name;                
	protected Calendar birth = new GregorianCalendar(new Locale("da","DK"));;                 
	protected String gender;                 
	protected int phone;
	protected String adresse;
	protected String club;
	protected DateFormat dateFormat;
	
	
	public Member (int memberID, String name, String birth, String gender, int phone, String adresse, String club) {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.memberID = memberID;
		this.name = name;
		if (birth == null) {
			this.birth = null;
		} else {
			try {
				this.birth.setTime(dateFormat.parse(birth));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		this.gender = gender;
		this.phone = phone;
		this.adresse = adresse;
		this.club = club;
	}
	
	public Member(String name, Calendar birth, String gender, int phone, String adresse, String club) {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.memberID = -1;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.adresse = adresse;
		this.club = club;
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
	
	public Calendar getBirth() {
		return birth;
	}
	
	public void setBirth(Calendar birth) {
		this.birth = birth;
	}
	
	public String getBirthString() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (birth == null) {
			return "";
		} else {
			return format.format(birth.getTime());
		}
	}
	
	public String getBirthStringForDB() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if (birth == null) {
			return "";
		} else {
			return format.format(birth.getTime());
		}
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPhoneString() {
		if (phone == 0) {
			return "";
		} else {
			return new Integer(phone).toString();	
		}
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
	
	public String getClub() {
		return club;
	}
	
	public void setClub(String club) {
		this.club = club;
	}	
}
