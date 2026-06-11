class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create a map with numbers and its frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // create a MinHeap of int[] with frequency and number
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        int i = 0;
        int[] result = new int[k];
        // offer the first k elements to the queue, if size is greater than K, then pop
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            minheap.offer (new int[]{entry.getValue(), entry.getKey()});
            if (minheap.size() > k){
                minheap.poll();
            }
        }
        // traverse the minheap to pop the number that with higher frequency
        for( int j = 0; j< k; j++){
            result[j] = minheap.poll()[1];
        }
        return result;

    }
}
