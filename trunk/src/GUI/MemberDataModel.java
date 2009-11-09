package GUI;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import dal.Customer;
import dalinterface.DALException;
import dao.CustomerDAO;



public class MemberDataModel extends AbstractTableModel{
	
	protected ArrayList<Customer> customerList;
	
	MemberDataModel() throws ParseException, DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		customerList = new CustomerDAO().getCustomerList();
	}

	public TableModel getTableModel() {
		return (TableModel)this;
	}

	public int getRowCount(){
		return customerList.size();
	}
	
	public int getColumnCount(){
		return 6; // returnere 
	}

	public String getColumnName(int columnIndex){
		String[] columnNames = new String[]{
			"Navn", "Født", "Køn", "Telefon", "Addresse", "Medlem"	
		};
		return columnNames[columnIndex];
	}

	public Object getValueAt (int rowIndex, int columnIndex){
        final int NAME = 0;
        final int BIRTH = 1;
        final int GENDER = 2;
        final int PHONE = 3;
        final int ADDRESS = 4;
        final int DISCOUNT = 5;
	
        switch(columnIndex){
        case NAME:
        	return customerList.get(rowIndex).getName();
        case BIRTH:
        	return customerList.get(rowIndex).getBirth();
        case GENDER:
        	return customerList.get(rowIndex).getGender();
        case PHONE:
        	return customerList.get(rowIndex).getPhone();
        case ADDRESS:
        	return customerList.get(rowIndex).getAdresse();
        case DISCOUNT:
        	return customerList.get(rowIndex).getDiscount();
        default:
            return "";
        }
	
	}

	public ArrayList<Customer> getCustomerList(){
		return (ArrayList<Customer>)customerList;
	}
	public void updateFromDatabase() throws ParseException{
		try {
			customerList = new CustomerDAO().getCustomerList() ;
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
