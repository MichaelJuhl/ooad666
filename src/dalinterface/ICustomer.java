package dalinterface;

import java.sql.SQLException;
import java.util.List;

import dal.Customer;
import dao.CustomerDAO;

public interface ICustomer {
	
	Customer getCustomer(int CustomerID) throws DALException;
	List<Customer> getCustomerList() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	void createCustomer(Customer CustomerID ,Customer Customer) throws DALException;
	void updateCustomers(int CustomerID, Customer Customers) throws DALException;
	void sletCustomer(int Customer) throws DALException;


}
