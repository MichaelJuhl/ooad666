package dalinterface;

import java.sql.SQLException;
import java.util.ArrayList;

import dal.User;

public interface IUser {
	
	User getUser(int UserID) throws DALException;
	ArrayList<User> getUserList() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	void createUser(User UserID,User Users) throws DALException;
	void updateUser(int UserID, User Users) throws DALException;
	void sletUser(int UserID) throws DALException;
	public boolean checkUsers(int UseriD) throws DALException;

}
