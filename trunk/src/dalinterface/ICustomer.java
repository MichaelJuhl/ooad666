package dalinterface;

import java.sql.SQLException;
import java.util.ArrayList;

import dal.Member;


public interface ICustomer {
	
	Member getCustomer(int CustomerID) throws DALException;
	ArrayList<Member> getCustomerList() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	void createCustomer(Member Customer) throws DALException;
	void updateCustomers(int CustomerID, Member Customers) throws DALException;
	void deleteCustomer(int Customer) throws DALException;


}
