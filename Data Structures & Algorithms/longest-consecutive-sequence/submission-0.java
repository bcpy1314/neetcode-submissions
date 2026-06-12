class Solution {
    public int longestConsecutive(int[] nums) {
        // create a set of the number
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add (num);
        }
        int longest = 0;
        for (int num: set){
            // if !set.constains(num -1) that means the num is the starting point
            if (!set.contains(num-1)){
                int length = 1;
                // if set contains num + length, keep increasing length
                while (set.contains(num + length)){
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
