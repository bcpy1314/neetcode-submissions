class Solution {
    public int findMin(int[] nums) {
        // bruteforce
        if (nums.length == 1){
            return nums[0];
        }
        int min = nums[0];
        for (int i = 1; i < nums.length; i++ ){
            min = Math.min(nums[i], min);
        }
        return min;
        
    }
}
