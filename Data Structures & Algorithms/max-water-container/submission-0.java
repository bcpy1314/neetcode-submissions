class Solution {
    public int maxArea(int[] heights) {
        // maintain a maxheight and a maxWater amount`
        int maxAmount = 0;
        int i = 0;
        int j = heights.length -1;
        while (i < j){
            maxAmount = Math.max(maxAmount, Math.min(heights[i], heights[j]) * (j - i));
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxAmount;
    }
}