package MainController;

import dbConnect.Constant;

import java.io.*;
import java.net.*;

public class LoginDialogDBChecker extends Thread {

	MainController controller;
	Boolean loggedIn;

	public LoginDialogDBChecker(MainController loginDialog) {
		this.controller = loginDialog;
		loggedIn = false;

	}

	public void run() {
		try {
			this.sleep(1500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		long start = -1; //default check value
		long end = -1; //default check value
		long total = -1; // default for bad connection
		int timeoutMs = 1500;
		while(!loggedIn) {
			//make an unbound socket
			Socket theSock = new Socket();

			try {
				SocketAddress sockaddr = new InetSocketAddress(Constant.server, Constant.port);

				//Create the socket with a timeout
				//when a timeout occurs, we will get timout exception.
				start = System.currentTimeMillis();
				theSock.connect(sockaddr, timeoutMs);
				end = System.currentTimeMillis();
			} catch (UnknownHostException e) {
				start = -1;
				end = -1;
			} catch (SocketTimeoutException e) {
				start = -1;
				end = -1;
			} catch (IOException e) {
				start = -1;
				end = -1;
			} finally {
				if (theSock != null) {
					try {
						theSock.close();
					} catch (IOException e) {
					}
				}

				if ((start != -1) && (end != -1)) {
					total = end - start;
					controller.setLoginDBStatus(total);
					try {
						this.sleep(1500);
					} catch (InterruptedException e1) {}
				} else {
					controller.setLoginDBStatus(-1);
				}
			}
		}
	}
	
	public void stopMe() {
		loggedIn = true;
	}
}