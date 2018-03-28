import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import evolution.TimingEvent;
import evolution.Timings;


public class Performance {

	public Performance() {
		
	}

	public void execute(){
		byte[] t1 = new byte[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 0};
		byte[][] t2 = new byte[2][];
		byte[] t3 = new byte[]{1,1,1,1,1,1,2,1};
		
		Timings timings = Timings.getInstance();
		timings.addEvent(TimingEvent.START);
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<byte[]> list = new ArrayList<byte[]>();
		
		
		int limit = 100;
		timings.addEvent(TimingEvent.MAP_CREATE_START);
		for (int i=0 ; i<limit ; i++) {
			map.put(Integer.toString(i*1111), 1);
		}
		timings.addEvent(TimingEvent.MAP_CREATE_END);
		
		System.out.println("MAP CREATED");
		
		timings.addEvent(TimingEvent.LIST_CREATE_START);
		for (int i=0 ; i<limit ; i++) {
			list.add(new byte[]{1,1,1,1,1,1,1,1});
		}
		list.add(new byte[]{1,1,1,1,1,1,2,1});
		timings.addEvent(TimingEvent.LIST_CREATE_END);
		
		timings.addEvent(TimingEvent.MAP_FETCH_START);
		int value = map.get(Integer.toString(18*1111));
		System.out.println(value);
		timings.addEvent(TimingEvent.MAP_FETCH_START);
		
		timings.addEvent(TimingEvent.LIST_FETCH_START);
		int index = 0;
		for (int i=0 ; i<list.size() ; i++) {
			if (Arrays.equals(list.get(i), t3)) {
				index = i;
				break;
			}
		}
		System.out.println(index);
		timings.addEvent(TimingEvent.LIST_FETCH_END);
		
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		for (int i=0 ; i<limit ; i++) {
			map2.put(Integer.toString(i*1111), 1);
		}
		timings.addEvent(TimingEvent.MAP_CREATE_START);
		map2.clear();
		map2.putAll(map);		
		timings.addEvent(TimingEvent.MAP_CREATE_END);
		
		timings.addEvent(TimingEvent.END);
		timings.printTimings(0);
	}
	
}
