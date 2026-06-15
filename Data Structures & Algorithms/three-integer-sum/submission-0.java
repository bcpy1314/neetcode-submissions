class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the array and then use binary search 
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length -1;
            while (left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if (sum > 0){
                    right --;
                } else if (sum < 0){
                    left ++;
                } else{
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left ++;
                    right --;
                    while ( left < right && nums[left] == nums[left -1]){
                        left++;
                    }
                }
            }

        }
        return res;
    }
}
