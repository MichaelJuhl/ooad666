/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PortalManagerMainFrame.java
 *
 * Created on 22-10-2009, 09:27:50
 */

package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.event.*;

import dal.Event;
import dalinterface.DALException;
import dao.EventDAO;

/**
 *
 * @author User
 */
public class PortalManagerMainFrame extends javax.swing.JFrame implements TableModelListener {
	private static final long serialVersionUID = 1L;
	
	EventDataModel eventDataModel;

	/** Creates new form PortalManagerMainFrame 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws DALException 
	 * @throws ParseException */
	public PortalManagerMainFrame() throws ParseException, DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		eventDataModel = new EventDataModel();
		initComponents();
		centreWindow(this);
	}
	public static void centreWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

	private void initComponents() {

		mainTabbedPane = new javax.swing.JTabbedPane();
		EventsPanel = new javax.swing.JPanel();
		eventScrollPane = new javax.swing.JScrollPane();
		eventTable = new javax.swing.JTable();
		buttonNewEvent = new javax.swing.JButton();
		buttonEditEvent = new javax.swing.JButton();
		buttonDeleteEvent = new javax.swing.JButton();
		buttonBuyTicket = new javax.swing.JButton();
		statusBar = new javax.swing.JTextField();
		mainMenuBar = new javax.swing.JMenuBar();
		menuFiler = new javax.swing.JMenu();
		connectDBMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		menuHelp = new javax.swing.JMenu();
		showLogMenuItem = new javax.swing.JMenuItem();
		aboutMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Portal Manager");
		setMinimumSize(new Dimension(750, 350));

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

		javax.swing.GroupLayout EventsPanelLayout = new javax.swing.GroupLayout(EventsPanel);
		EventsPanel.setLayout(EventsPanelLayout);
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

		mainTabbedPane.addTab("Arrangementer", EventsPanel);

		statusBar.setEditable(false);
		statusBar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

		menuFiler.setText("Filer");

		connectDBMenuItem.setText("Forbind til DB");
		menuFiler.add(connectDBMenuItem);

		exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
		exitMenuItem.setText("Luk");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		menuFiler.add(exitMenuItem);

		mainMenuBar.add(menuFiler);

		menuHelp.setText("Hjaelp");

		showLogMenuItem.setText("Vis Log");
		menuHelp.add(showLogMenuItem);

		aboutMenuItem.setText("Om Portal Manager");
		aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				aboutMenuItemActionPerformed(evt);
			}
		});
		menuHelp.add(aboutMenuItem);

		mainMenuBar.add(menuHelp);

		setJMenuBar(mainMenuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(455, Short.MAX_VALUE)
						.addComponent(statusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addComponent(mainTabbedPane)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(statusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		);

		pack();
	}

	private void exitMenuItemActionPerformed(ActionEvent evt) {
		setVisible(false);
		System.exit(0);
	}

	private void aboutMenuItemActionPerformed(ActionEvent evt) {                                              
		PortalManagerAboutDialog dialog = new PortalManagerAboutDialog(this, rootPaneCheckingEnabled);
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
	}                                             

	private void buttonNewEventActionPerformed(ActionEvent evt) {                                               
		newEventDialog dialog = new newEventDialog(this, rootPaneCheckingEnabled, this);
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
	}                                              

	private void buttonEditEventActionPerformed(ActionEvent evt) {                                                
		if (eventTable.getSelectedRow() != -1) {
			
			editEventDialog dialog = new editEventDialog(this, rootPaneCheckingEnabled, eventDataModel.getEventList().get(eventTable.convertRowIndexToModel(eventTable.getSelectedRow())), this);
			dialog.setLocationRelativeTo(this);
			dialog.setVisible(true);
		}
	}  
	
	private void buttonDeleteEventActionPerformed(ActionEvent evt) {
		Event selectedEvent = eventDataModel.getEventList().get(eventTable.convertRowIndexToModel(eventTable.getSelectedRow()));
		if (DialogDeleteYN2.userAcceptsDelete(selectedEvent.getTitel())) {
			try {
				new EventDAO().deleteEvent(selectedEvent.getEventID());
			} catch (DALException e) {
				JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke slette arrangement", "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			updateTable();
		}
	}
	
	private void buttonBuyTicketActionPerformed(ActionEvent evt) {
		
	}

	// Variables declaration - do not modify                     
	private javax.swing.JPanel EventsPanel;
	private javax.swing.JMenuItem aboutMenuItem;
	private javax.swing.JButton buttonDeleteEvent;
	private javax.swing.JButton buttonEditEvent;
	private javax.swing.JButton buttonNewEvent;
	private javax.swing.JButton buttonBuyTicket;
	private javax.swing.JMenuItem connectDBMenuItem;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JScrollPane eventScrollPane;
	private javax.swing.JTable eventTable;
	private javax.swing.JMenuBar mainMenuBar;
	private javax.swing.JTabbedPane mainTabbedPane;
	private javax.swing.JMenu menuFiler;
	private javax.swing.JMenu menuHelp;
	private javax.swing.JMenuItem showLogMenuItem;
	private javax.swing.JTextField statusBar;
	// End of variables declaration

	public void tableChanged(TableModelEvent e) {
		/*
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);

        // Do something with the data...
		 */

	}

	public void updateTable() {
		eventDataModel.updateFromDatabase();
		eventDataModel.fireTableDataChanged();
	}

}