//storing overlapped intervals
class MyCalendarTwo {
    List<int[]> bookings;
    TreeMap<Integer,Integer> overlappedMap;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlappedMap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        //if event is present in overlapped then return false
        Integer prevVal = overlappedMap.lowerKey(end);
        if(prevVal!=null && start <= overlappedMap.get(prevVal)-1){
            return false;
        }
        // insert into bookings and if it is overalapping with
        // any booking then insert into overlapped map
        for(int booking[] : bookings){
            // booking[0], start
            // booking[1], end
            int commStart = Math.max(booking[0],start);
            int commEnd = Math.min(booking[1],end);
            if(commStart<commEnd){
                overlappedMap.put(commStart,commEnd);
            }
        }
        bookings.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */



//sweep line algorithm
class MyCalendarTwo {

    private TreeMap<Integer, Integer> bookings;
    private int maxAllowed;

    public MyCalendarTwo() {
        bookings = new TreeMap<>();
        maxAllowed = 2;
    }

    public boolean book(int start, int end) {
        bookings.put(start, bookings.getOrDefault(start, 0) + 1);
        bookings.put(end, bookings.getOrDefault(end, 0) - 1);

        int overlapCount = 0;

        //prefix sum of bookings.
        for (Map.Entry<Integer, Integer> entry : bookings.entrySet()) {
            overlapCount += entry.getValue();
            if (overlapCount > maxAllowed) {
                bookings.put(start, bookings.get(start) - 1);
                bookings.put(end, bookings.get(end) + 1);
                if (bookings.get(start) == 0) {
                    bookings.remove(start);
                }
                if (bookings.get(end) == 0) {
                    bookings.remove(end);
                }
                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
