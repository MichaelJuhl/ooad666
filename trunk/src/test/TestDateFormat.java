package test;

import dal.Event;

public class TestDateFormat {
	public TestDateFormat() throws Exception {
		Event event = new Event(3,"Rock","Gul","Bamse","2010-09-22 12:49:00","2010-09-22 12:00:00","Bamse spiller",154,200);
		System.out.println(event.getDateStart());
		System.out.println(event.getDateFinish());
	}
	
}
