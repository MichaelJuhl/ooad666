package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.Customer;
import dal.Event;
import dalinterface.DALException;
import dalinterface.ICustomer;
import dbConnect.Connector;

public class CustomerDAO implements ICustomer {


	@Override
	public void createCustomer(Customer CustomerID ,Customer Customer) throws DALException {
		String sql=" INSERT INTO OOADCustomer (Name, Birth, Gender, Phone, Address) VALUES("
	+ CustomerID
	+ ", " + Customer.getName()
	+ ", " + Customer.getBirth()
	+ ", " + Customer.getGender()
	+ ", " + Customer.getPhone()
	+ ", " + Customer.getAdresse() + ")";
		String sql2 = "INSERT INTO OOADDiscount (CustomerID, Discount) VALUES((SELECT MAX(CustomerID) FROM OOADCustomer), '"+Customer.getDiscount() + "')";

		Connector.doUpdate(sql);
		Connector.doUpdate(sql2);
		
		
	}

	@Override
	public Customer getCustomer(int CustomerID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM OOADCustomer NATURAL JOIN OOADDiscount WHERE CustomerID = " + CustomerID);
	    try {
	    	if (!rs.first()) throw new DALException("Kunden " + CustomerID + " findes ikke"); 
	    	return new Customer (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}
	

	@Override
	public ArrayList<Customer> getCustomerList() throws DALException, InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		
		ArrayList<Customer> list = new ArrayList<Customer>();
		ResultSet rs = Connector.getConnector().doQuery("SELECT * FROM OOADCustomer");
		try {
			while (rs.next()) {
				list.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)
		    			,rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		}
		return list;
	}


	@Override
	public void sletCustomer(int CustomerID) throws DALException {
		Connector.doUpdate(
				"DELETE FROM OOADCustomer WHERE CustomerID = "+ CustomerID
			);
		
	}

	@Override
	public void updateCustomers(int CustomerID, Customer Customers)
			throws DALException {
		Connector.doUpdate(
				"UPDATE OOADCustomer SET Name = '" + Customers.getName() + "', Birth =  '" + Customers.getBirth() + 
				"', Gender = '" + Customers.getGender() + "', Phone = '" + Customers.getPhone() + "', Address =  '"
				+ Customers.getAdresse() + "' WHERE CustomerID = " + CustomerID
				);
		Connector.doUpdate(
				"UPDATE OOADDiscount SET Discount =  '" + Customers.getDiscount() + "' WHERE CustomerID = " + CustomerID
		);
		
	}

}
