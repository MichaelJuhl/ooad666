package MainController;

import dal.User;
import GUI.LoginDialog;
import GUI.PortalManagerMainFrame;

public class MainController {

	public LoginDialog loginDialog;
	public User currentUser;
	
	public MainController() {
    	showLoginDialog();
	}
	
	private void showLoginDialog() {
		// Run Login Dialog
		final MainController mainController = this;
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	loginDialog = new LoginDialog(new java.awt.Frame(), true, mainController);
                loginDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                loginDialog.setVisible(true);
            }
        });
		(new LoginDialogDBChecker(this)).start();
	}
	
	// when user is logged in, start the main window
	public void userLoggedIn(User user) {
		this.currentUser = user;
		new PortalManagerMainFrame(this);
	}
	
	public void userLoggedOut() {
		this.currentUser = null;
		showLoginDialog();
	}
	
	public void setLoginDBStatus(long connectTime) {
		loginDialog.setDBOnline(connectTime);
	}
	
    public static void main(String[] args) {
    	new MainController();
    }

}
