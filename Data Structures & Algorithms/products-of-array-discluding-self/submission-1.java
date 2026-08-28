class Solution {
    public int[] productExceptSelf(int[] nums) {
      // create 3 int[]
      // first array to store prefix, product on nums[i] left
      // second array to store suffix, product on nums[i] right
      // third array to store suffix x prefix
      int n = nums.length;
      int[] prefix = new int[n];
      int[] suffix = new int[n];
      int[] res = new int[n];
      
      prefix[0] = 1;
      for (int i = 1; i < nums.length; i++){
         prefix[i] = nums[i-1] * prefix[i-1];
      }

      suffix[n - 1] = 1;
      for (int i = n - 2; i >= 0; i--){
         suffix[i] = nums[i + 1] * suffix[i + 1];
      }

      for (int i = 0; i < n; i++){
         res[i] = prefix[i] * suffix[i];
      }
      return res;
        
    }
}