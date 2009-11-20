package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import dal.User;
import dalinterface.DALException;
import dbConnect.Connector;

public class LoginDAO {
	public User getUser(String name, String password) throws DALException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ResultSet rs = Connector.getConnector().doQuery("SELECT * from OOADUser NATURAL JOIN OOADRank WHERE Name = '" + name + "' AND Password = '" + password + "'");
	    try {
	    	if (!rs.first()) {
	    		return new User();
	    	} else
	    		return (new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),rs.getString(6), rs.getString(7), rs.getString(8)));
	    	}
	    catch (SQLException e) {throw new DALException(e); }
		
	}
}
