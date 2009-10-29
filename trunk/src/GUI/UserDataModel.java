package GUI;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


import dal.User;
import dalinterface.DALException;

import dao.UserDAO;;


public class UserDataModel extends AbstractTableModel{

	
	@Override
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
        final int USERNAME = 1;
        final int RANK = 2;
        

        switch(columnIndex) {
            case USERID:
                return userList.get(rowIndex).getUserID();
            case USERNAME:
                return userList.get(rowIndex).getName();
            case RANK:
                return userList.get(rowIndex).getRank();
            default:
                return "";
        }
		
		
	}
	
	public String getColumnName(int columnIndex) {
    	String[] columnNames = new String [] {
                "ID", "Medlems navn", "Rettigheder"
        };
    	return columnNames[columnIndex];
    }
	
	
	
	protected List<User> userList;
	
	    
	    UserDataModel() throws ParseException, DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	        
	    	userList = new UserDAO().getUserList();
	    		    
	    }
	public TableModel getTabelModel(){
		return (TableModel)this;
	}
	
	
	 
	

}
