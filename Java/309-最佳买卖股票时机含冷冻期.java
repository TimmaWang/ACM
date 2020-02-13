class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        if(prices.length <= 2) {
            return prices[1] -prices[0] > 0 ? prices[1] -prices[0] : 0;
        }

        int[][] dp = new int[prices.length][2];
        int result = 0;
        dp[0][0] = 0;
        dp[0][1] = 0-prices[0];
        dp[1][0] = Math.max(dp[0][1] + prices[1], dp[0][0]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
        for(int i = 2; i < prices.length; i++) {

           dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
           dp[i][1] = Math.max(dp[i-2][0]-prices[i], dp[i-1][1]);
            
        }

        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1] );
    }
}