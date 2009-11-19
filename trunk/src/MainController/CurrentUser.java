package MainController;

public class CurrentUser {
	private String username;
	private String password;
	private int rank;
	
	CurrentUser(String username, String password, String rank) {
		this.username = username;
		this.password = password;
		
		if (rank.equals("Billetsælger")) {
			this.rank = 1;
		} else if (rank.equals("Kontormedarbejder")) {
			this.rank = 2;
		} else if (rank.equals("Admin")) {
			this.rank = 3;
		} else {
			this.rank = -1;
		}
		
		System.out.println(toString());
	
	}
	
	public String toString() {
		return username + " - " + password + " - " + rank;
	}
}
