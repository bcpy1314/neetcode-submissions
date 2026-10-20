class Solution {
    public int leastInterval(char[] tasks, int n) {
        // task[A, A, B, B], 2
        // | A B -|A B -|
        // Step 1 record the freq
        // Step 2 check the number with maxFreq
        int[] freq = new int[26];
        int maxFreq = 0;
        for (int i = 0; i < tasks.length; i++){
            freq[tasks[i] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[tasks[i] -'A']);
        }
        
        int numberOfMaxFreq = 0;
        for (int i = 0; i < 26; i++){
            if (freq[i] == maxFreq){
                numberOfMaxFreq++;
            }
        }
        int time = (maxFreq - 1) * (n + 1) + numberOfMaxFreq;

        return Math.max(time, tasks.length);

        
    }
}
