class Solution {
    public String reorganizeString(String s) {
        // first store the freq of each char
        // then use priority queue to store int[] with freq and it's index
        // set a prev and cur, when poll, reduce the freq and push to the
        // PQ again
        // one corner case
        // if the maxFreq is more than half, it will return ""

        // tranverse s and store freq
        int[] freq = new int[26];
        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
            maxFreq = Math.max(freq[c - 'a'], maxFreq);
        }

        if (maxFreq > ((s.length() + 1) / 2)) {
            return "";
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{freq[i], i});
            }
        }

        int[] prev = null;
        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            res.append((char) (cur[1] + 'a'));
            cur[0]--;
            if (prev != null && prev[0] > 0) {
                maxHeap.offer(prev);
            }
            prev = cur;
        }

        return res.toString();
    }
}