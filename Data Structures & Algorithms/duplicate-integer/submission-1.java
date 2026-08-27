class Solution {
    public boolean hasDuplicate(int[] nums) {
        // brute force
        // build a hashmap, check if the map contains the number, 
        // if yes return true, if no return false
        if(nums.length <= 1){
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}