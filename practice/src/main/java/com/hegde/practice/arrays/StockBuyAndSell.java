package com.hegde.practice.arrays;

public class StockBuyAndSell {

    public int maxProfitFromBuyAndSellingStock(int[] stockPrices){
        int maxProfit = 0;
        int minPriceEncountered = stockPrices[0];
        for(int i = 1; i < stockPrices.length; i++){
            int price = stockPrices[i];
            minPriceEncountered = Math.min(price, minPriceEncountered);
            maxProfit = Math.max(maxProfit, price - minPriceEncountered);
        }
        return maxProfit;
    }
}
