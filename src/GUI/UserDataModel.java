package GUI;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import dal.User;
import dao.UserDAO;
import daoInterface.DALException;

public class UserDataModel extends AbstractTableModel{
	
	protected ArrayList<User> userList;
	
    
	UserDataModel() throws ParseException, DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		userList = new UserDAO().getUserList();    		    		
	}
		
	public ArrayList<User> getUserList() {
        return userList;
    }
	
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		
		return userList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		final int USERID = 0;
        final int NAME = 1;
        final int CPR = 2;
        final int GENDER = 3;
        final int PHONE = 4;
        final int ADDRESS = 5;
        final int PASSWORD = 6;
        final int RANK = 7;
       
        switch(columnIndex) {
            case USERID:
                return userList.get(rowIndex).getUserID();
            case NAME:
                return userList.get(rowIndex).getName();
            case CPR:
                return userList.get(rowIndex).getCPR();
            case GENDER:
                return userList.get(rowIndex).getGender();
            case PHONE:
                return userList.get(rowIndex).getPhone();
            case ADDRESS:
                return userList.get(rowIndex).getAdresse();
            case PASSWORD:
                return userList.get(rowIndex).getPassword();
            case RANK:
                return userList.get(rowIndex).getRank();  
            default:
                return "";
        }
		
		
	}
	
	public String getColumnName(int columnIndex) {
    	String[] columnNames = new String [] {
                "ID", "Medlems navn", "CPR" ,"Køn", "Tlf.Nr.", "Adresse", "Password", "Rang"
        };
    	return columnNames[columnIndex];
    }
	
	

	public TableModel getTableModel(){
		return (TableModel)this;
	}
	
	public void updateFromDatabase() {
		try {
			userList = new UserDAO().getUserList();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 
	

}
