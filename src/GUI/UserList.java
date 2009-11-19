package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;

import dal.Event;
import dalinterface.DALException;
import dao.EventDAO;
import dao.UserDAO;

public class UserList extends JPanel{
	
	JFrame parent;
	PortalManagerMainFrame mainFrame;
	UserDataModel userDataModel;
	
	UserList(JFrame parent, PortalManagerMainFrame mainFrame) {
		this.parent = parent;
		
		try {
			userDataModel = new UserDataModel();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		initComponents();
	}
	
	private void initComponents() {
		userScrollPane = new JScrollPane();
		userTable = new JTable();
		buttonNewUser = new JButton();
		buttonEditUser = new JButton();
		buttonDeleteUser = new JButton();
		
		userTable.setModel(userDataModel.getTableModel());
		userTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
		userTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		userTable.getModel().addTableModelListener(userTable);
		userTable.setAutoCreateRowSorter(true);
		userTable.setMinimumSize(new Dimension(1200, 200));
		userScrollPane.setViewportView(userTable);
		userScrollPane.setPreferredSize(new Dimension(600, 200));
		
		buttonNewUser.setText("Opret");
		buttonNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonNewUserActionPerformed(evt);
			}
		});

		buttonEditUser.setText("Rediger");
		buttonEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonEditUserActionPerformed(evt);
			}
		});

		buttonDeleteUser.setText("Deaktiver");
		buttonDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonDeleteUserActionPerformed(evt);
			}
		});
		
		javax.swing.GroupLayout EventsPanelLayout = new javax.swing.GroupLayout(this);
		setLayout(EventsPanelLayout);
		EventsPanelLayout.setHorizontalGroup(
				EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(userScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
				.addGroup(EventsPanelLayout.createSequentialGroup()
						.addComponent(buttonNewUser)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(buttonEditUser)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(buttonDeleteUser))
		);
		EventsPanelLayout.setVerticalGroup(
				EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(EventsPanelLayout.createSequentialGroup()
						.addComponent(userScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buttonNewUser)
								.addComponent(buttonEditUser)
								.addComponent(buttonDeleteUser))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
		);
		
	}
	
	private void buttonNewUserActionPerformed(ActionEvent evt) {                                               
		new DialogNewUser(parent, true, this);
	}                                              

	private void buttonEditUserActionPerformed(ActionEvent evt) {                                                
		if (userTable.getSelectedRow() != -1) {
			new DialogEditUser(parent, this, true, userDataModel.getUserList().get(userTable.convertRowIndexToModel(userTable.getSelectedRow())));
		}
	}
	
	private void buttonDeleteUserActionPerformed(ActionEvent evt) {
		if (userTable.getSelectedRow() != -1) {
			if (DialogDeleteYN2.userAcceptsDelete(userDataModel.getUserList().get(userTable.convertRowIndexToModel(userTable.getSelectedRow())).getName())) {
				UserDAO userDAO = new UserDAO();
				try {
					userDAO.deleteUser(userDataModel.getUserList().get(userTable.convertRowIndexToModel(userTable.getSelectedRow())).getUserID());
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.updateTable();
			}
		}
		
	}
	
	public void tableChanged(TableModelEvent e) {

	}
	
	public void updateTable() {
		userDataModel.updateFromDatabase();
		userDataModel.fireTableDataChanged();
	}
	
	// Variables declaration - do not modify                     
	private JScrollPane userScrollPane;
	private JTable userTable;
	private JButton buttonNewUser;
	private JButton buttonEditUser;
	private JButton buttonDeleteUser;
	// End of variables declaration

}
