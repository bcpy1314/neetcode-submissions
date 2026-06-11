class Solution {
    public int[] twoSum(int[] nums, int target) {
        // corner case check
        if (nums.length <= 1){
            return new int[]{};
        }

        // use harshmap to store the value with key as target-nums[i], value as index
        Map< Integer, Integer> map = new HashMap<>();
        // first check if the map contains the target - nums[i]
        // if yes, return i and map.get(target - nums[i])
        // if no, add the key and value to map
        for (Integer i = 0; i < nums.length; i++){
        
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{};
        
    }
}
