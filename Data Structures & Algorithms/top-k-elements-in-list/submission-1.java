class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // build a frequency map with num as key and frequency as value
        // build a priority queue to get top k elements
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        for (Map.Entry<Integer, Integer> entry: freq.entrySet()){
            minHeap.offer (new int[]{entry.getValue(), entry.getKey()});
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = minHeap.poll()[1];
        }
        return res;
        
    }
}