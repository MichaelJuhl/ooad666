package dalinterface;

import java.sql.SQLException;
import java.util.ArrayList;

import dal.Customer;


public interface ICustomer {
	
	Customer getCustomer(int CustomerID) throws DALException;
	ArrayList<Customer> getCustomerList() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	void createCustomer(Customer Customer) throws DALException;
	void updateCustomers(int CustomerID, Customer Customers) throws DALException;
	void sletCustomer(int Customer) throws DALException;


}
