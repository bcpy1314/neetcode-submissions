class HitCounter {
    // create array hold the timestamp within 300s
    private int[] times = new int[300];
    // create array hold the hits count at the timestamp
    private int[] hits = new int[300];
    

    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        int diff = timestamp%300;
        if (times[diff] != timestamp){
            times[diff] = timestamp;
            hits[diff] = 1;
        } else {
            hits[diff]++;
        }
    
    }
    
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++){
            if (timestamp - times[i] < 300){
                total += hits[i];
            }
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
