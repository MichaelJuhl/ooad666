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
	public void createMember(Member Customer) throws DALException {
		String sql=" INSERT INTO OOADCustomer (Name, Birth, Gender, Phone, Address) VALUES("
	
	+ ", " + Customer.getName()
	+ ", " + Customer.getBirth()
	+ ", " + Customer.getGender()
	+ ", " + Customer.getPhone()
	+ ", " + Customer.getAdresse() + ")";
		
		String sql2 = "INSERT INTO OOADMember (CustomerID, Discount) VALUES((SELECT MAX(CustomerID) FROM OOADCustomer), '"+Customer.getClub() + "')";

		Connector.doUpdate(sql);
		Connector.doUpdate(sql2);
		
		
	}

	@Override
	public Member getMember(int CustomerID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM OOADCustomer NATURAL JOIN OOADMember WHERE CustomerID = " + CustomerID);
	    try {
	    	if (!rs.first()) throw new DALException("Kunden " + CustomerID + " findes ikke"); 
	    	return new Member (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}
	

	@Override
	public ArrayList<Member> getMemberList() throws DALException, InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		
		ArrayList<Member> list = new ArrayList<Member>();
		ResultSet rs = Connector.getConnector().doQuery("SELECT * FROM OOADCustomer NATURAL JOIN OOADMember");
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
	public void deleteMember(int CustomerID) throws DALException {
		Connector.doUpdate(
				"DELETE FROM OOADCustomer WHERE CustomerID = "+ CustomerID
			);
		
	}

	@Override
	public void updateMember(int CustomerID, Member Customers)
			throws DALException {
		Connector.doUpdate(
				"UPDATE OOADCustomer SET Name = '" + Customers.getName() + "', Birth =  '" + Customers.getBirth() + 
				"', Gender = '" + Customers.getGender() + "', Phone = '" + Customers.getPhone() + "', Address =  '"
				+ Customers.getAdresse() + "' WHERE CustomerID = " + CustomerID
				);
		Connector.doUpdate(
				"UPDATE OOADMember SET Discount =  '" + Customers.getClub() + "' WHERE CustomerID = " + CustomerID
		);
		
	}

}
