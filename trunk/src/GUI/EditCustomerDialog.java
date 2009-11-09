package GUI;

import dal.Customer;
import dal.Event;

public class EditCustomerDialog extends javax.swing.JDialog {

	private Customer customer;
	private PortalManagerMainFrame mainFrame;

	public EditCustomerDialog(java.awt.Frame parent, boolean modal, Event event, PortalManagerMainFrame mainFrame) {
		super(parent, modal);
		this.mainFrame = mainFrame;
		this.customer = customer;
		initComponents();

	customerNavnInputField.setText(customer.getName());
	
	
	
	private void initComponents() {
		
		customerNavnInputField = new javax.swing.JTextField();

	}
	
	
	
	
	
	
	
	
	private javax.swing.JTextField customerNavnInputField;

	
	}
