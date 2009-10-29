package GUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public abstract class TableSearcher implements TableModel{
	UserDataModel userDataModel;
	ArrayList rowToModelIndex;

	
	private void clearSearchingState(){
		String searchString = null;
		rowToModelIndex.clear();
		for (int t=0; t<userDataModel.getRowCount(); t++){
			rowToModelIndex.add(new Integer(t));
		}
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int column) {
		
		return userDataModel.getColumnClass(column);
	}
	
		
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return (userDataModel.userList == null) ? 0 : userDataModel.getColumnCount(); 
	}

	@Override
	public String getColumnName(int column) {
		
		// TODO Auto-generated method stub
		return userDataModel.getColumnName(column);
	}

	@Override
	public int getRowCount() {
		 return (userDataModel == null) ? 0 : rowToModelIndex.size();
	}
	public boolean isCellEditable(int row, int column) {

		return userDataModel.isCellEditable(getModelRow(row), column);
	}

	public Object getValueAt(int row, int column) {
		return userDataModel.getValueAt(getModelRow(row), column);
	}

	public void setValueAt(Object aValue, int row, int column) {
		userDataModel.setValueAt(aValue, getModelRow(row), column);
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	

	

}
