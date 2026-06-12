class Solution {
    public int[] productExceptSelf(int[] nums) {   

         int n = nums.length;
         // create 3 array, one prefix array, one suffix array, one res array
         int[] prefix = new int[n];
         int[] suffix = new int[n];
         int[] res = new int[n];
         prefix[0] = 1;
         suffix[n-1] = 1;

         for (int i = 1; i < n; i ++ ){
            prefix[i] = nums[i-1] * prefix[i-1];
         }

         for (int i = n-2; i >= 0; i--){
            suffix[i] = nums[ i + 1]*suffix[i + 1];
         }

         for (int i = 0; i < n; i++){
            res[i] = prefix[i] * suffix[i];
         }
         return res;
    }
}  
