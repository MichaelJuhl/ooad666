package GUI;

import javax.swing.JTable;
import dal.Member;
import dal.Event;
import dalinterface.DALException;
import dao.MemberDAO;
import dao.EventDAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.NumberFormatException;

public class MemberNewDialog extends javax.swing.JDialog {

	MemberList memberTable;

	public MemberNewDialog(java.awt.Frame parent, boolean modal, MemberList memberList){
		super(parent, modal);
		this.memberTable = memberList;
		initComponents();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void initComponents(){
		nameLabel = new javax.swing.JLabel();
		birthTimeInputField = new javax.swing.JTextField();
		phoneInputField = new javax.swing.JTextField();
		addressInputField = new javax.swing.JTextField();
		nameInputField = new javax.swing.JTextField();
		birthLabel = new javax.swing.JLabel();
		genderLabel = new javax.swing.JLabel();
		genderInputCombBox = new javax.swing.JComboBox();
		addressLabel = new javax.swing.JLabel();
		phoneLabel = new javax.swing.JLabel();
		errorLabel = new javax.swing.JLabel();
		discardButton = new javax.swing.JButton();
		saveButton = new javax.swing.JButton();
		birthYearComboBox = new javax.swing.JComboBox();
		birthMonthComboBox = new javax.swing.JComboBox();
		birthDateComboBox = new javax.swing.JComboBox();
		clubLabel = new javax.swing.JLabel();
		clubComboBox = new javax.swing.JComboBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		nameLabel.setText("Navn");

		nameInputField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				customerNavnInputFieldActionPerformed(evt);
			}
		});
		birthLabel.setText("Født");

		genderLabel.setText("Køn");
		genderInputCombBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mand", "Kvinde" }));


		phoneLabel.setText("Telefon");

		addressLabel.setText("Addresse");

		birthYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeYearArray()));
		birthYearComboBox.setSelectedItem(new Integer(Calendar.getInstance().get(Calendar.YEAR)-30).toString());

		birthMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeMonthArray()));
		birthMonthComboBox.setSelectedItem(String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1));

		birthDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeDayArray()));
		birthDateComboBox.setSelectedItem(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));

		clubLabel.setText("Klub:");
		
		clubComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Portalis", "Show-Portalis" }));

		errorLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); 
		errorLabel.setForeground(new java.awt.Color(255, 0, 0));
		errorLabel.setText(" ");

		discardButton.setText("Annuller");
		discardButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				eventDiscardButtonActionPerformed(evt);
			}
		});

		saveButton.setText("Gem");
		saveButton.addActionListener(new java.awt.event.ActionListener() {
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
																	.addComponent(nameLabel))
																	.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																			.addComponent(nameInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
																			.addGroup(layout.createSequentialGroup()
																					.addComponent(genderLabel)
																					.addGap(18, 18, 18)
																					.addComponent(genderInputCombBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
																					.addGroup(layout.createSequentialGroup()
																							.addComponent(phoneLabel)
																							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																							.addComponent(phoneInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
																							.addGroup(layout.createSequentialGroup()
																									.addComponent(addressLabel)
																									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																									.addComponent(addressInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
																									.addGroup(layout.createSequentialGroup()
																											.addComponent(birthLabel)
																											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(birthYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(birthMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(birthDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
																											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(clubLabel)
																											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(clubComboBox)
																											.addContainerGap())

																											.addGroup(layout.createSequentialGroup()
																													.addComponent(errorLabel)
																													.addContainerGap(387, Short.MAX_VALUE))
																													.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																															.addComponent(saveButton)
																															.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																															.addComponent(discardButton)
																															.addContainerGap())))))
			)); // usikker med parenteserne :D, men lad os nu se sagde den blinde til den døve ;)

	layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							.addComponent(nameLabel)
							.addComponent(nameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(genderLabel)
									.addComponent(genderInputCombBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(phoneLabel)
											.addComponent(phoneInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)  
											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
													.addComponent(addressLabel)
													.addComponent(addressInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)                
													.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
															.addComponent(birthLabel)
															.addComponent(birthMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
															.addComponent(birthDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
															.addComponent(birthYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
															.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
															.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																	.addComponent(clubLabel)
																	.addComponent(clubComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																	.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																	.addComponent(errorLabel)
																	.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																			.addComponent(discardButton)
																			.addComponent(saveButton))
																			.addContainerGap(16, Short.MAX_VALUE))
	); 

	pack();
}                

private String[] makeYearArray() {
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	
	String[] years = new String[151];
	int y = 0;
	for(int i=currentYear-150; i<=currentYear; i++) {
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
	if (nameInputField.getText().equals("")) {
		errorLabel.setText("Fejl: Navn kan ikke vaere tom");
		return;
	}
	
	//check Phone
	if (phoneInputField.getText().equals("")) {
		errorLabel.setText("Fejl: Telefon-nr kan ikke være tom");
		return;
	}
	
	//check Address
	if (addressInputField.getText().equals("")) {
		errorLabel.setText("Fejl: Adresse kan ikke være tom");
		return;
	}

	//Validation passed, make new customer
	MemberDAO customerDAO = new MemberDAO();

	try {
		customerDAO.createMember(new Member(nameInputField.getText(), getBirthDate(), (String)genderInputCombBox.getSelectedItem()
				, Integer.valueOf(phoneInputField.getText()),addressInputField.getText(), (String)clubComboBox.getSelectedItem()));
	} catch(NumberFormatException e) {
		e.printStackTrace();
	} catch (DALException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	memberTable.updateTable();
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
	int startTimeYear = Integer.valueOf((String)birthYearComboBox.getSelectedItem());
	int startTimeMonth = Integer.valueOf((String)birthMonthComboBox.getSelectedItem());
	int startTimeDate = Integer.valueOf((String)birthDateComboBox.getSelectedItem());
	
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

private Calendar getBirthDate() {
	int startTimeYear = Integer.valueOf((String)birthYearComboBox.getSelectedItem());
	int startTimeMonth = Integer.valueOf((String)birthMonthComboBox.getSelectedItem());
	int startTimeDate = Integer.valueOf((String)birthDateComboBox.getSelectedItem());
	int startTimeHour = 0;
	int startTimeMinute = 0;
	
	Calendar startTime = GregorianCalendar.getInstance();
	startTime.clear();
	startTime.set(startTimeYear, startTimeMonth, startTimeDate, startTimeHour, startTimeMinute, 0);
	
	return startTime;
}


// Variables declaration - do not modify 


private javax.swing.JTextField nameInputField;
private javax.swing.JTextField customerBirthInputField;
private javax.swing.JTextField customerGenderInputField;
private javax.swing.JTextField phoneInputField;
private javax.swing.JTextField addressInputField;
private javax.swing.JLabel nameLabel;
private javax.swing.JLabel genderLabel;
private javax.swing.JLabel birthLabel;
private javax.swing.JComboBox genderInputCombBox;
private javax.swing.JLabel clubLabel;
private javax.swing.JComboBox clubComboBox;
private javax.swing.JComboBox birthYearComboBox;
private javax.swing.JComboBox birthMonthComboBox;
private javax.swing.JComboBox birthDateComboBox;
private javax.swing.JTextField birthTimeInputField;
private javax.swing.JLabel addressLabel;
private javax.swing.JLabel phoneLabel;
private javax.swing.JButton saveButton;
private javax.swing.JButton discardButton;
private javax.swing.JLabel errorLabel;
// End of variables declaration  
}
