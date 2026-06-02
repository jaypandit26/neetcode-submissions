class Solution {
    public int maxProfit(int[] prices) {
        int low = 0;
        int high = 1;
        int maxPro = 0;
        //two pointer method
        while(high < prices.length){
            if(prices[low] < prices[high]){
                int profit = prices[high] - prices[low];

                maxPro = Math.max(maxPro, profit);
            }
            else{
                low = high;
            }
            high++;
        }
        return maxPro;
    }
}
