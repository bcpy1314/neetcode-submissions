class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1){
            return new int[]{};
        }

        int[] result = new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int sum = target - nums[i];
            if (map.containsKey(sum)){
                return new int[]{map.get(sum), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
        
    }
}
