class CustomStack {
    int stack[];
    int operations[];
    int capacity;
    int size;
    int index;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        operations = new int[maxSize];
        capacity = maxSize;
        size=0;
        index = -1;
    }
    
    public void push(int x) {
        if(isFull()){
            return;
        }
        index++;
        size++;
        stack[index] = x;
    }
    
    public int pop() {
        if(isEmpty()){
            return -1;
        }
        int val = stack[index];
        val += operations[index];
        if(index>0){
            operations[index-1] += operations[index];
        }
        operations[index] = 0;
        index--;
        size--;
        return val;
    }
    
    public void increment(int k, int val) {
        if(isEmpty()){
            return;
        }
        int num = Math.min(size,k);
        operations[num-1] += val;
    }

    private boolean isFull(){
        return (size == capacity);
    }

    private boolean isEmpty(){
        return (size == 0);
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
