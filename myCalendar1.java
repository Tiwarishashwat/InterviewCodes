class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {   
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prevVal = map.lowerKey(end);
        if(prevVal!=null && start <= map.get(prevVal)-1){
            return false;
        }
        map.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
