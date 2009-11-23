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

import MainController.MainController;

import dal.Event;
import dalinterface.DALException;
import dao.EventDAO;

/**
 *
 * @author User
 */
public class PortalManagerMainFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private MainController mainController;
	
	

	/** Creates new form PortalManagerMainFrame 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws DALException 
	 * @throws ParseException */
	public PortalManagerMainFrame(MainController mainController) {
		this.mainController = mainController;
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
		statusBar = new javax.swing.JTextField();
		mainMenuBar = new javax.swing.JMenuBar();
		menuFiler = new javax.swing.JMenu();
		logoutMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		menuHelp = new javax.swing.JMenu();
		showLogMenuItem = new javax.swing.JMenuItem();
		aboutMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("PortalManager");
		setMinimumSize(new Dimension(750, 350));
		
		int rank = mainController.currentUser.getRankAsInt(); 
		if (rank > 0) {
			mainTabbedPane.addTab("Arrangementer", new EventList(this, rank));
			mainTabbedPane.addTab("Medlemmer", new MemberList(this, rank));
		}
		if (rank > 2)
			mainTabbedPane.addTab("Brugere", new UserList(this, this, rank));
		
		statusBar.setEditable(false);
		statusBar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

		menuFiler.setText("Filer");

		logoutMenuItem.setText("Log ud");
		logoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logoutMenuItemActionPerformed(evt);
			}
		});
		
		menuFiler.add(logoutMenuItem);

		exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
		exitMenuItem.setText("Luk");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		menuFiler.add(exitMenuItem);

		mainMenuBar.add(menuFiler);

		menuHelp.setText("Hjælp");

		showLogMenuItem.setText("Vis Log");
		//menuHelp.add(showLogMenuItem);

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
		setVisible(true);
	}

	private void logoutMenuItemActionPerformed(ActionEvent evt) {
		mainController.userLoggedOut();
		this.dispose();
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

	// Variables declaration - do not modify
	private javax.swing.JMenuItem aboutMenuItem;
	private javax.swing.JMenuItem logoutMenuItem;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenuBar mainMenuBar;
	private javax.swing.JTabbedPane mainTabbedPane;
	private javax.swing.JMenu menuFiler;
	private javax.swing.JMenu menuHelp;
	private javax.swing.JMenuItem showLogMenuItem;
	private javax.swing.JTextField statusBar;
	// End of variables declaration



}