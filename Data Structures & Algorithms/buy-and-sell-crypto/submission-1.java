class Solution {
    public int maxProfit(int[] prices) {
        // strategy is to maintain the min buy price and max profit
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i]-minPrice);
        }
        return profit;
    }
}
