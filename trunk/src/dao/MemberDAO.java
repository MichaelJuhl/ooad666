package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.Member;
import dalinterface.DALException;
import dalinterface.IMember;
import dbConnect.Connector;

public class MemberDAO implements IMember {


	@Override
	public void createMember(Member member) throws DALException {
		String sql="INSERT INTO OOADMember (Name, Birth, Gender, Phone, Address) VALUES('"
	
	+ member.getName()
	+ "', '" + member.getBirthStringForDB()
	+ "', '" + member.getGender()
	+ "', " + member.getPhone()
	+ ", '" + member.getAdresse() + "')";
		
		String sql2 = "INSERT INTO OOADMemberClub (MemberID, Discount) VALUES((SELECT MAX(MemberID) FROM OOADMember), '"+member.getClub() + "')";

		Connector.doUpdate(sql);
		Connector.doUpdate(sql2);
		
		
	}

	@Override
	public Member getMember(int memberID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM OOADMember NATURAL JOIN OOADMemberClub WHERE MemberID = " + memberID);
	    try {
	    	if (!rs.first()) throw new DALException("Kunden " + memberID + " findes ikke"); 
	    	return new Member (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}
	

	@Override
	public ArrayList<Member> getMemberList() throws DALException, InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		
		ArrayList<Member> list = new ArrayList<Member>();
		ResultSet rs = Connector.getConnector().doQuery("SELECT * FROM OOADMember NATURAL JOIN OOADMemberClub");
		try {
			while (rs.next()) {
				list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)
		    			,rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		}
		return list;
	}


	@Override
	public void deleteMember(int memberID) throws DALException {
		Connector.doUpdate(
				"UPDATE OOADMemberClub SET Discount =  'Gæst' WHERE MemberID = " + memberID
			);
		
	}

	@Override
	public void updateMember(int memberID, Member member)
			throws DALException {
		Connector.doUpdate(
				"UPDATE OOADMember SET Name = '" + member.getName() + "', Birth =  '" + member.getBirthString() + 
				"', Gender = '" + member.getGender() + "', Phone = '" + member.getPhone() + "', Address =  '"
				+ member.getAdresse() + "' WHERE MemberID = " + memberID
				);
		Connector.doUpdate(
				"UPDATE OOADMemberClub SET Discount =  '" + member.getClub() + "' WHERE MemberID = " + memberID
		);
		
	}

}
