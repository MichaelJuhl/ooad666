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
import dal.Member;
import dalinterface.DALException;
import dao.EventDAO;
import dao.MemberDAO;

public class MemberList extends JPanel{
	
	JFrame parent;
	MemberDataModel dataModel;
	
	MemberList(JFrame parent) {
		this.parent = parent;
		
		try {
			dataModel = new MemberDataModel();
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
		memberScrollPane = new JScrollPane();
		memberTable = new JTable();
		buttonNewMember = new JButton();
		buttonEditMember = new JButton();
		buttonDeleteMember = new JButton();
		
		memberTable.setModel(dataModel.getTableModel());
		memberTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
		memberTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		memberTable.getModel().addTableModelListener(memberTable);
		memberTable.setAutoCreateRowSorter(true);
		memberTable.setMinimumSize(new Dimension(1200, 200));
		memberScrollPane.setViewportView(memberTable);
		memberScrollPane.setPreferredSize(new Dimension(600, 200));
		
		buttonNewMember.setText("Opret");
		buttonNewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonNewMemberActionPerformed(evt);
			}
		});

		buttonEditMember.setText("Rediger");
		buttonEditMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonEditMemberActionPerformed(evt);
			}
		});

		buttonDeleteMember.setText("Degrader til Gæst");
		buttonDeleteMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonDeleteMemberActionPerformed(evt);
			}
		});
		
		javax.swing.GroupLayout EventsPanelLayout = new javax.swing.GroupLayout(this);
		setLayout(EventsPanelLayout);
		EventsPanelLayout.setHorizontalGroup(
				EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(memberScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
				.addGroup(EventsPanelLayout.createSequentialGroup()
						.addComponent(buttonNewMember)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(buttonEditMember)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(buttonDeleteMember))
		);
		EventsPanelLayout.setVerticalGroup(
				EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(EventsPanelLayout.createSequentialGroup()
						.addComponent(memberScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buttonNewMember)
								.addComponent(buttonEditMember)
								.addComponent(buttonDeleteMember))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
		);
		
	}
	
	private void buttonNewMemberActionPerformed(ActionEvent evt) {                                               
		new MemberNewDialog(parent, true, this);
	}                                              

	private void buttonEditMemberActionPerformed(ActionEvent evt) {                                                
		new MemberEditDialog(parent, this, true, dataModel.getMemberList().get(memberTable.convertRowIndexToModel(memberTable.getSelectedRow())));
		
	}  
	
	private void buttonDeleteMemberActionPerformed(ActionEvent evt) {
		if (memberTable.getSelectedRow() != -1) {
			Member selectedMember = dataModel.getMemberList().get(memberTable.convertRowIndexToModel(memberTable.getSelectedRow()));
			if (DeleteDialogYN2.userAcceptsDelete(selectedMember.getName())) {
				try {
					new MemberDAO().deleteMember(selectedMember.getMemberID());
				} catch (DALException e) {
					JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke slette medlem", "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				updateTable();
			}
		}
	}
	
	public void tableChanged(TableModelEvent e) {

	}
	
	public void updateTable() {
		try {
			dataModel.updateFromDatabase();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataModel.fireTableDataChanged();
	}
	
	// Variables declaration - do not modify                     
	private JScrollPane memberScrollPane;
	private JTable memberTable;
	private JButton buttonNewMember;
	private JButton buttonEditMember;
	private JButton buttonDeleteMember;
	// End of variables declaration

}
