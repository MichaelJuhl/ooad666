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


public class UserTableSearcher extends AbstractTableModel{
	
	protected User getUser;
	int userID;
    
	UserTableSearcher() throws ParseException, DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	        
	    	getUser = new UserDAO().getUser(Integer.parseInt(UsersGUI.jTextField1.getText()));
	    	
	    		 
	}
	
	
	
	public int getColumnCount() {
		
		return 8;
	}

	@Override
	public int getRowCount() {
		
		return 1;
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
                return getUser.getUserID();
            case NAME:
                return getUser.getName();
            case CPR:
                return getUser.getCPR();
            case GENDER:
                return getUser.getGender();
            case PHONE:
                return getUser.getPhone();
            case ADDRESS:
                return getUser.getAdresse();
            case PASSWORD:
                return getUser.getPassword();
            case RANK:
                return getUser.getRank();  
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
