class Solution {
    public int maxProfit(int[] prices) {

        //dp method
        int maxProfit = 0;
        int minBuy = prices[0];

        for(int sell : prices){
            maxProfit = Math.max(maxProfit, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return maxProfit;


        // int low = 0;
        // int high = 1;
        // int maxPro = 0;
        // //two pointer method
        // while(high < prices.length){
        //     if(prices[low] < prices[high]){
        //         int profit = prices[high] - prices[low];

        //         maxPro = Math.max(maxPro, profit);
        //     }
        //     else{
        //         low = high;
        //     }
        //     high++;
        // }
        // return maxPro;
    }
}
