class HitCounter {
    int total = 0;
    Deque<int[]> queue = new ArrayDeque<>();

    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        if ( !queue.isEmpty() && queue.peekLast()[0] == timestamp){
            queue.peekLast()[1]++;
        } else {
            queue.offerLast(new int[]{timestamp, 1});
        }
        total ++;
    }
    
    public int getHits(int timestamp) {
        while (! queue.isEmpty() && timestamp - queue.peekFirst()[0] >= 300){
            total -= queue.pollFirst()[1];
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
