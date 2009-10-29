package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dal.User;
import dalinterface.DALException;
import dalinterface.IUser;
import dbConnect.Connector;

public class UserDAO implements IUser{


	@Override
	public void createUser(User UserID, User Users) throws DALException {

		Connector.doUpdate(
				"INSERT INTO OOADUser (Name, CPR, Gender, Phone, Address, Password) VALUES ('" 
				+ Users.getName()+ "', '" + Users.getCPR() + "', '" + 
				Users.getGender() + "', '" + Users.getPhone() + "', '" + Users.getPassword() +"')"
			);


			Connector.doUpdate(
					"INSERT INTO OOADRank (UserID, Rank) VALUES((SELECT MAX(UserID) FROM OOADUser), '"+Users.getRank() + "')"
				);
	}

	@Override
	public User getUser(int UserID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM OOADUSer WHERE UserID = " + UserID);
	    try {
	    	if (!rs.first()) throw new DALException("Brugeren " + UserID + " findes ikke"); 
	    	return new User (rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6),
	    			rs.getString(7), rs.getString(8));
	    }
	    catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public ArrayList<User> getUserList() throws DALException, InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		ArrayList<User> list = new ArrayList<User>();
		ResultSet rs = Connector.getConnector().doQuery("SELECT * FROM OOADUser NATURAL JOIN OOADRank");
		try
		{
			while (rs.next()) 
			{
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6),
		    			rs.getString(7), rs.getString(8)));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void sletUser(int UserID) throws DALException {
		Connector.doUpdate(
				"UPDATE OOADRank SET Rank = 'deaktiv' WHERE UserID = " +UserID
			);
		
	}

	@Override
	public void updateUser(int UserID, User Users) throws DALException {
		Connector.doUpdate(
				"UPDATE OOADUser SET Name = '" + Users.getName() + "', CPR =  '" + Users.getCPR() + 
				"', Gender = '" + Users.getGender() + "', Phone = '" + Users.getPhone() +"', Address = '" + Users.getAdresse()
				+"', Password = '" + Users.getPassword() + "' WHERE UserID = " + UserID
		);

		Connector.doUpdate(
				"UPDATE OOADRank SET Rank =  '" + Users.getRank()+ "' WHERE UserID = " + UserID
		);
		
	}
	
	@Override
	public boolean checkUsers(int UserID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM OOADUser NATURAL JOIN OOADRank WHERE UserID = " + UserID+"" +
				" AND Rank <> 'deaktiv'");
	    try {
	    	if (!rs.first()){ 
	    	return false;
	    
	    	}else 
	    		return true;
	    }catch (SQLException e) {throw new DALException(e); }
	}


}
