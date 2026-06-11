class Solution {
    public boolean hasDuplicate(int[] nums) {
        // corner case
        if (nums.length <= 1){
            return false;
        }

        // build a map and traverse the array
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}