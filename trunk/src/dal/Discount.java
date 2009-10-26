package dal;

public class Discount {

	protected int EventID;
	protected double Show;
	protected double Normal;
	
	
	public Discount(int EventID, double Show, double Normal){
		
		this.EventID = EventID;
		this.Show = Show;
		this.Normal = Normal;
		
	}
	public Discount(){
		
	}
	public int getEventID() {
		return EventID;
	}
	public void setEventID(int eventID) {
		EventID = eventID;
	}
	public double getShow() {
		return Show;
	}
	public void setShow(double show) {
		Show = show;
	}
	public double getNormal() {
		return Normal;
	}
	public void setNormal(double normal) {
		Normal = normal;
	}

	
}
