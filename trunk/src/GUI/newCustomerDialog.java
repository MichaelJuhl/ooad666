package GUI;

import javax.swing.JTable;
import dal.Customer;
import dal.Event;
import dalinterface.DALException;
import dao.CustomerDAO;
import dao.EventDAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.NumberFormatException;

public class newCustomerDialog extends javax.swing.JDialog {

	PortalManagerMainFrame mainFrame;

	public newCustomerDialog(java.awt.Frame parent, boolean modal, PortalManagerMainFrame mainFrame){
		super(parent, modal);
		this.mainFrame = mainFrame;
		initComponents();
	}

	public void initComponents(){
		customerNavnLabel = new javax.swing.JLabel();
		customerNavnInputField = new javax.swing.JTextField();
		customerBirthLabel = new javax.swing.JLabel();
		customerGenderLabel = new javax.swing.JLabel();
		customerGenderInputCombBox = new javax.swing.JComboBox();
		customerAddressLabel = new javax.swing.JLabel();
		customerPhoneLabel = new javax.swing.JLabel();
		customerErrorLabel = new javax.swing.JLabel();
		customerDiscardButton = new javax.swing.JButton();
		customerSaveButton = new javax.swing.JButton();
		customerBirthYearComboBox = new javax.swing.JComboBox();
		customerBirthMonthComboBox = new javax.swing.JComboBox();
		customerBirthDateComboBox = new javax.swing.JComboBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		customerNavnLabel.setText("Navn");

		customerNavnInputField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				customerNavnInputFieldActionPerformed(evt);
			}
		});
		customerBirthLabel.setText("Født");

		customerGenderLabel.setText("Køn");
		customerGenderInputCombBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mand", "Kvinde" }));


		customerPhoneLabel.setText("Telefon");

		customerAddressLabel.setText("Addresse");

		customerBirthYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeYearArray()));

		customerBirthMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeMonthArray()));
		customerBirthMonthComboBox.setSelectedItem(String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1));

		customerBirthDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeDayArray()));
		customerBirthDateComboBox.setSelectedItem(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));

		customerBirthTimeField.setText(getCurrentTime());


		customerErrorLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); 
		customerErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
		customerErrorLabel.setText(" ");

		customerDiscardButton.setText("Annuller");
		customerDiscardButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				eventDiscardButtonActionPerformed(evt);
			}
		});

		customerSaveButton.setText("Gem");
		customerSaveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				customerSaveButtonActionPerformed(evt);
			}
		});


	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	getContentPane().setLayout(layout);
	layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(layout.createSequentialGroup()
											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
													.addGroup(layout.createSequentialGroup()
															.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																	.addComponent(customerNavnLabel))
																	.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																			.addComponent(customerNavnInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
																			.addGroup(layout.createSequentialGroup()
																					.addComponent(customerGenderLabel)
																					.addGap(18, 18, 18)
																					.addComponent(customerGenderInputCombBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
																					.addGroup(layout.createSequentialGroup()
																							.addComponent(customerPhoneLabel)
																							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																							.addComponent(customerPhoneInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
																							.addGroup(layout.createSequentialGroup()
																									.addComponent(customerAddressLabel)
																									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																									.addComponent(customerAddressInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
																									.addGroup(layout.createSequentialGroup()
																											.addComponent(customerBirthLabel)
																											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(customerBirthYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(customerBirthMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(customerBirthDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
																											.addContainerGap())

																											.addGroup(layout.createSequentialGroup()
																													.addComponent(customerErrorLabel)
																													.addContainerGap(387, Short.MAX_VALUE))
																													.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																															.addComponent(customerSaveButton)
																															.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																															.addComponent(customerDiscardButton)
																															.addContainerGap())))))
			)); // usikker med parenteserne :D, men lad os nu se sagde den blinde til den døve ;)

	layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							.addComponent(customerNavnLabel)
							.addComponent(customerNavnInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(customerGenderLabel)
									.addComponent(customerGenderInputCombBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(customerPhoneLabel)
											.addComponent(customerPhoneInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)  
											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
													.addComponent(customerAddressLabel)
													.addComponent(customerAddressInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)                
													.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
															.addComponent(customerBirthLabel)
															.addComponent(customerBirthMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
															.addComponent(customerBirthDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
															.addComponent(customerBirthYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
															.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
															.addComponent(customerErrorLabel)
															.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
															.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																	.addComponent(customerDiscardButton)
																	.addComponent(customerSaveButton))
																	.addContainerGap(16, Short.MAX_VALUE))
	); 

	pack();
}                

private String[] makeYearArray() {
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	String[] years = new String[51];
	int y = 0;
	for(int i=currentYear; i<=currentYear+50; i++) {
		years[y] = String.valueOf(i);
		y++;
	}
	return years;
}

private String[] makeMonthArray() {
	String[] months = new String[12];
	for(int i=1; i<=12; i++) {
		months[i-1]=String.valueOf(i);
	}
	return months;
}

private String[] makeDayArray() {
	String[] days = new String[31];
	for(int i=1; i<=31; i++) {
		days[i-1]=String.valueOf(i);
	}
	return days;
}

private void customerNavnInputFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                     
	// TODO add your handling code here:
}                                                    

private void eventDiscardButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
	this.dispose();
}                                                  

private void customerSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
	//Validate input
	//check Navn
	if (customerNavnInputField.getText().equals("")) {
		customerErrorLabel.setText("Fejl: Navn kan ikke vaere tom");
		return;
	}
	//check Birth
	if (!timeValidate(customerBirthInputField.getText())) {
		customerErrorLabel.setText("Fejl: Ugyldigt starttidspunkt");
		return;
	} else if(customerBirthInputField.getText().length()==4) {
		customerBirthInputField.setText("0" + customerBirthInputField.getText());
	}

	//check Gender
	if (customerGenderInputField.getText().equals("")) {
		customerErrorLabel.setText("Fejl: Køn kan ikke vaere tom");
		return;
	}
	//check Phone
	if (customerPhoneInputField.getText().equals("")) {
		customerErrorLabel.setText("Fejl: Telefon-nr kan ikke være tom");
		return;
	}


	//check Address
	if (customerAddressInputField.getText().equals("")) {
		customerErrorLabel.setText("Fejl: Adresse kan ikke være tom");
		return;
	}


	//Validation passed, make new customer
	CustomerDAO customerDAO = new CustomerDAO();

	try {
		customerDAO.createCustomer(new Customer(customerNavnInputField.getText(), getBirthTime(), (String)customerGenderInputCombBox.getSelectedItem()
				, Integer.valueOf(customerPhoneInputField.getText()),customerAddressInputField.getText()));
	} catch(NumberFormatException e) {
		e.printStackTrace();
	} catch (DALException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	mainFrame.updateTable();
	this.dispose();
}                 

private boolean timeValidate(String text) {
	try{
		Pattern timePattern = Pattern.compile("^(20|21|22|23|[01]\\d|\\d)(([:][0-5]\\d){1,2})$");
		Matcher timeMatcher = timePattern.matcher(text);
		if (timeMatcher.matches()) {
			if (text.length()==4)
				text = "0"+text;
			return true;
		}
		else
			return false;

	} catch(java.util.regex.PatternSyntaxException e){
		System.out.println("Invalid regex pattern when matching time");
		e.printStackTrace();
		return false;
	}
}

private Calendar getBirthTime() {
	int startTimeYear = Integer.valueOf((String)customerBirthYearComboBox.getSelectedItem());
	int startTimeMonth = Integer.valueOf((String)customerBirthMonthComboBox.getSelectedItem());
	int startTimeDate = Integer.valueOf((String)customerBirthDateComboBox.getSelectedItem());


	Calendar startTime = GregorianCalendar.getInstance();
	startTime.clear();
	startTime.set(startTimeYear, startTimeMonth, startTimeDate);

	return startTime;
}

private String getCurrentTime() {
	// returns the current time in the format HH:mm - fx 13:25 or 02:07
	String currentHour;
	String currentMinute;

	currentHour = String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
	if (currentHour.length()<2)
		currentHour = "0" + currentHour;
	currentMinute = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
	if (currentMinute.length()<2) 
		currentMinute = "0" + currentMinute;

	return currentHour + ":" + currentMinute;
}


// Variables declaration - do not modify 


private javax.swing.JTextField customerNavnInputField;
private javax.swing.JTextField customerBirthInputField;
private javax.swing.JTextField customerGenderInputField;
private javax.swing.JTextField customerPhoneInputField;
private javax.swing.JTextField customerAddressInputField;
private javax.swing.JLabel customerNavnLabel;
private javax.swing.JLabel customerGenderLabel;
private javax.swing.JLabel customerBirthLabel;
private javax.swing.JComboBox customerGenderInputCombBox;

private javax.swing.JComboBox customerBirthYearComboBox;
private javax.swing.JComboBox customerBirthMonthComboBox;
private javax.swing.JComboBox customerBirthDateComboBox;
private javax.swing.JTextField customerBirthTimeField;
private javax.swing.JLabel customerAddressLabel;
private javax.swing.JLabel customerPhoneLabel;
private javax.swing.JButton customerSaveButton;
private javax.swing.JButton customerDiscardButton;
private javax.swing.JLabel customerErrorLabel;
// End of variables declaration  
}
