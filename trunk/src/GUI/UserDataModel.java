package GUI;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


import dal.User;
import dalinterface.DALException;

import dao.UserDAO;;


public class UserDataModel extends AbstractTableModel{
	
	protected ArrayList<User> userList;
	
    
	UserDataModel() throws ParseException, DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	        
	    	userList = new UserDAO().getUserList();
	    	
	    		 //Test
		//userList = new ArrayList<User>();
		//userList.add(new User(1,"Peter",999999, "Male", 43434343, "Vej 2", "1234", "4"));
		//userList.add(new User(2,"Peter",999999, "Male", 43434343, "Vej 2", "1234", "4"));
		//userList.add(new User(3,"Peter",999999, "Male", 43434343, "Vej 2", "1234", "4"));
		//System.out.println(userList);
		//Test
	}
	
	
	
	public int getColumnCount() {
		
		return 3;
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
                "ID", "Medlems navn", "CPR" ,"Tlf.", "Kon", "Adresse", "Password", "Rank"
        };
    	return columnNames[columnIndex];
    }
	
	

	public TableModel getTabelModel(){
		return (TableModel)this;
	}
	
	
	 
	

}
