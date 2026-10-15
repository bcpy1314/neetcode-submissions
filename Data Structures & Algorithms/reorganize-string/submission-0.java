class Solution {
    public String reorganizeString(String s) {
        // first check the frequency of each char
        // if the most frequent char is over 1/2 lenghth
        // then return ""
        // if not, first put the most frequent 
        // then put the second first frequent

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++){
            freq[s.charAt(i) -'a']++;
        }
        int mostFreq = freq[0];
        for (int i = 0; i < 26; i++){
            mostFreq = Math.max(mostFreq, freq[i]);
        }
        if (mostFreq > (s.length()+1)/2){
            return "";
        }
        // create a priority queue with int[]
        // where int[] stores freq[i] and i
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++){
            if (freq[i] > 0){
                maxHeap.offer(new int[]{freq[i], i});
            }
        }

        StringBuilder res = new StringBuilder();
        int[] prev = null;
        while (!maxHeap.isEmpty() || prev != null){
            if (prev != null && maxHeap.isEmpty()){
                return "";
            }
            int[] curr = maxHeap.poll();
            res.append((char) (curr[1] + 'a'));
            curr[0]--;
            if (prev != null){
                maxHeap.offer(prev);
                prev = null;
            }
            if(curr[0] > 0){
                prev = curr;
            }
        }
        return res.toString();

    }
}