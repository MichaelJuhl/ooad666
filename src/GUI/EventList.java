package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.TableModelEvent;
import dal.Event;
import dalinterface.DALException;
import dao.EventDAO;

public class EventList extends JPanel{
	
	PortalManagerMainFrame mainFrame;
	
	EventList(PortalManagerMainFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		try {
			eventDataModel = new EventDataModel();
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
		
		eventScrollPane = new javax.swing.JScrollPane();
		eventTable = new javax.swing.JTable();
		buttonNewEvent = new javax.swing.JButton();
		buttonEditEvent = new javax.swing.JButton();
		buttonDeleteEvent = new javax.swing.JButton();
		buttonBuyTicket = new javax.swing.JButton();
		
		eventTable.setModel(eventDataModel.getTableModel());
		eventTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
		eventTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		eventTable.getModel().addTableModelListener(eventTable);
		eventTable.setAutoCreateRowSorter(true);
		eventTable.setMinimumSize(new Dimension(1200, 200));
		eventScrollPane.setViewportView(eventTable);
		eventScrollPane.setPreferredSize(new Dimension(600, 200));

		buttonNewEvent.setText("Opret");
		buttonNewEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonNewEventActionPerformed(evt);
			}
		});

		buttonEditEvent.setText("Rediger");
		buttonEditEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonEditEventActionPerformed(evt);
			}
		});

		buttonDeleteEvent.setText("Slet");
		buttonDeleteEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonDeleteEventActionPerformed(evt);
			}
		});
		
		buttonBuyTicket.setText("Koeb Billet");
		buttonBuyTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonBuyTicketActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout EventsPanelLayout = new javax.swing.GroupLayout(this);
		setLayout(EventsPanelLayout);
		EventsPanelLayout.setHorizontalGroup(
				EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(eventScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
				.addGroup(EventsPanelLayout.createSequentialGroup()
						.addComponent(buttonNewEvent)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(buttonEditEvent)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(buttonDeleteEvent)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(buttonBuyTicket))
		);
		EventsPanelLayout.setVerticalGroup(
				EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(EventsPanelLayout.createSequentialGroup()
						.addComponent(eventScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buttonNewEvent)
								.addComponent(buttonEditEvent)
								.addComponent(buttonDeleteEvent)
								.addComponent(buttonBuyTicket))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
		);		
	}
	
	private void buttonNewEventActionPerformed(ActionEvent evt) {                                               
		EventNewDialog dialog = new EventNewDialog(mainFrame, true, this);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}                                              

	private void buttonEditEventActionPerformed(ActionEvent evt) {                                                
		if (eventTable.getSelectedRow() != -1) {
			
			EventEditDialog dialog = new EventEditDialog(mainFrame, true, eventDataModel.getEventList().get(eventTable.convertRowIndexToModel(eventTable.getSelectedRow())), this);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		}
	}  
	
	private void buttonDeleteEventActionPerformed(ActionEvent evt) {
		if (eventTable.getSelectedRow() != -1) {
			Event selectedEvent = eventDataModel.getEventList().get(eventTable.convertRowIndexToModel(eventTable.getSelectedRow()));
			if (DeleteDialogYN2.userAcceptsDelete(selectedEvent.getTitel())) {
				try {
					new EventDAO().deleteEvent(selectedEvent.getEventID());
				} catch (DALException e) {
					JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke slette arrangement", "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				updateTable();
			}
		}
	}
	
	private void buttonBuyTicketActionPerformed(ActionEvent evt) {
		if (eventTable.getSelectedRow() != -1) {
			TicketBuyDialog dialog1 = new TicketBuyDialog(mainFrame, true, eventDataModel.getEventList().get(eventTable.convertRowIndexToModel(eventTable.getSelectedRow())),this);
			
			dialog1.setLocationRelativeTo(null);
			dialog1.setVisible(true);
		}
		
	}
	
	public void tableChanged(TableModelEvent e) {

	}

	public void updateTable() {
		eventDataModel.updateFromDatabase();
		eventDataModel.fireTableDataChanged();
	}
	
	private javax.swing.JScrollPane eventScrollPane;
	private javax.swing.JTable eventTable;
	private javax.swing.JButton buttonDeleteEvent;
	private javax.swing.JButton buttonEditEvent;
	private javax.swing.JButton buttonNewEvent;
	private javax.swing.JButton buttonBuyTicket;
	private EventDataModel eventDataModel;
}
