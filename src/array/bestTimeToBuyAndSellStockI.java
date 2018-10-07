package array;

public class bestTimeToBuyAndSellStockI {
    // peak and velly
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int profit = Integer.MIN_VALUE;
        int lowest = prices[0];

        // Bug ! i< prices.length -1? Are you kidding? 这么低级的错误
        for(int i = 1 ; i < prices.length; i++){
            if(prices[i]<lowest){
                lowest = prices[i];
            }else{
                profit = Math.max(profit,prices[i]-lowest);
            }
        }

        return profit <= 0 ? 0 : profit;
    }
}
