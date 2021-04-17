import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class IPTracker {
	
	private Map<String, Integer> requestCount;

	public IPTracker() {
		requestCount = new HashMap<>();
	}

	public void requestHandled(String ipAddress) {
		requestCount.put(ipAddress, requestCount.getOrDefault(ipAddress, 0) + 1);
	}
	
	public List<String> top100() {
		PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>((a, b) -> a.getValue() - b.getValue());
		for (Map.Entry<String, Integer> entry : requestCount.entrySet()) {
			pq.offer(entry);
			if (pq.size() > 100)
				pq.poll();
		}
		
		List<String> list = new ArrayList<>();
		while (!pq.isEmpty())
			list.add(pq.poll().getKey());
		Collections.reverse(list);
		
		return list;
	}
	
	public void clear() {
		requestCount.clear();
	}
}
