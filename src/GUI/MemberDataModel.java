package GUI;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import dal.Member;
import dalinterface.DALException;
import dao.MemberDAO;



public class MemberDataModel extends AbstractTableModel{
	
	protected ArrayList<Member> customerList;
	
	MemberDataModel() throws ParseException, DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		customerList = new MemberDAO().getMemberList();
	}

	public TableModel getTableModel() {
		return (TableModel)this;
	}

	public int getRowCount(){
		return customerList.size();
	}
	
	public int getColumnCount(){
		return 7; // returnere 
	}

	public String getColumnName(int columnIndex){
		String[] columnNames = new String[]{
			"ID", "Navn", "Født", "Køn", "Telefon", "Addresse", "Medlem"	
		};
		return columnNames[columnIndex];
	}

	public Object getValueAt (int rowIndex, int columnIndex){
        final int ID = 0;
		final int NAME = 1;
        final int BIRTH = 2;
        final int GENDER = 3;
        final int PHONE = 4;
        final int ADDRESS = 5;
        final int CLUB = 6;
	
        switch(columnIndex){
        case ID:
        	return customerList.get(rowIndex).getMemberID();
        case NAME:
        	return customerList.get(rowIndex).getName();
        case BIRTH:
        	return customerList.get(rowIndex).getBirthString();
        case GENDER:
        	return customerList.get(rowIndex).getGender();
        case PHONE:
        	return customerList.get(rowIndex).getPhoneString();
        case ADDRESS:
        	return customerList.get(rowIndex).getAdresse();
        case CLUB:
        	return customerList.get(rowIndex).getClub();
        default:
            return "";
        }
	
	}

	public ArrayList<Member> getCustomerList(){
		return (ArrayList<Member>)customerList;
	}
	public void updateFromDatabase() throws ParseException{
		try {
			customerList = new MemberDAO().getMemberList() ;
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
