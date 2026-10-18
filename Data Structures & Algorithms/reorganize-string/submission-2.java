class Solution {
    public String reorganizeString(String s) {
        // step 1: store freq in array
        // step 2: find maxFreq, check if there is a res
        // step 3: create a PriorityQueue to store freq and indes(maxHeap)
        // step 4: offer the elements that freq is not zero
        // step 5: poll the max freq elements, compare with the prev, and the offer the element

        // step 1: store freq
        int[] freq = new int[26];
        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            freq[c-'a']++;
            maxFreq = Math.max(freq[c-'a'], maxFreq);
        }

        // step 2: check if there is a res
        if( maxFreq > ((s.length()+ 1)/2)){
            return "";
        }
        // step 3: create a PriorityQueue
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        StringBuilder res = new StringBuilder();
        int[] prev = null;
        for (int i = 0; i < 26; i++){
            if (freq[i] > 0){
                maxHeap.offer(new int[]{freq[i], i});
            }
        }
        // step 4: process PriorityQueue
        while (!maxHeap.isEmpty()){
            int[] cur = maxHeap.poll();
            res.append((char) (cur[1] + 'a'));
            if (prev != null && prev[0] > 0 ){
                maxHeap.offer(prev);
            }
            cur[0]--;
            prev = cur;
        }
        return res.toString();
        
    }
}