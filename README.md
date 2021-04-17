# IP-Tracker

## How does your code work?
- The method `requestHandled(String ipAddress)` accepts an IP address and stores in a `HashMap` this IP address and its request count.
- The method `top100()` returns a list of top 100 IP addresses with the greatest request count, displayed in decreasing order of request count, implemented using a `PriorityQueue`.
- The method `clear()` clears all IP addresses and tallies in the `HashMap`

## Why did you choose this approach?
- A `HashMap` provides O(1) find and insert operations and is suited for storing and tracking the request count.
- A `PriorityQueue` provides efficient O(log (n)) time insertion and removal in an ordered collection.

## What other approaches did you decide not to pursue?
I also considered storing the IP request counts in a list and sorting it before returning the top 100, however this would be less efficient than using a `PriorityQueue` given the time complexity would be O(n*\log(n)) where n is the number of total IP addresses seen.

## What is the runtime complexity of each function?
- `requestHandled(String ipAddress)`: O(1)
- `top100()`: O(n\*log(100))
- `clear()`: O(n)
where n is the number of total IP addresses seen

## How would you test this?
We can test this program by providing sample IP addresses and have the program print out the list of top IP addresses. An example is shown below:
	
	public static void main(String[] args) {
		IPTracker tracker = new IPTracker();
		tracker.requestHandled("1.1.1.1");
		tracker.requestHandled("2.2.2.2");
		tracker.requestHandled("2.2.2.2");
		tracker.requestHandled("3.3.3.3");
		tracker.requestHandled("3.3.3.3");
		tracker.requestHandled("3.3.3.3");
		tracker.requestHandled("4.4.4.4");
		tracker.requestHandled("4.4.4.4");
		tracker.requestHandled("4.4.4.4");
		tracker.requestHandled("ip4");
		System.out.println(tracker.top100().toString());
	}
  `//[4.4.4.4, 3.3.3.3, 2.2.2.2, 1.1.1.1]`
