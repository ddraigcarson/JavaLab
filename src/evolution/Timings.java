package evolution;

import java.util.ArrayList;
import java.util.List;

public class Timings {

	private static Timings instance = null;
	
	public static Timings getInstance() {
		if (instance == null) {
			instance = new Timings();
		}
		return instance;
	}	
	
	private List<TimingEvent> events = new ArrayList<TimingEvent>();
	private List<Long> times = new ArrayList<Long>();  
	private boolean recordEvents = true;
	
	public void addEvent(TimingEvent event) {
		if (recordEvents) {
			events.add(event);
			times.add(System.currentTimeMillis());
		}
	}
	
	public void printTimings(int durationMinimum){		
		int startTimeEventIndex = events.indexOf(TimingEvent.START);
		long startTime = times.get(startTimeEventIndex);
				
		System.out.println("\n-----< TIMINGS >-----");
		System.out.println("Timestamp\tDuration\tEvent");
		System.out.println("-----------------------------------------------");
		for (int i=0 ; i<events.size() ; i++) {
			long timeStamp = times.get(i) - startTime;
			long duration;
			
			TimingEvent event = events.get(i);
			TimingEvent triggeringEventType = event.getTriggeringEvent();
			
			if (triggeringEventType != null) {
				List<TimingEvent> eventsSoFar = events.subList(0, i);
				int triggeringEventIndex = eventsSoFar.lastIndexOf(triggeringEventType);
				long triggeringEventTimeStamp = times.get(triggeringEventIndex);
				duration = times.get(i) - triggeringEventTimeStamp;
			} else {
				duration = 0; // Triggering event
			}
			
			if (duration >= durationMinimum) {
				System.out.println(timeStamp + " ms\t\t" + duration + " ms\t\t" + event);	
			}
		}
	}
	
}
