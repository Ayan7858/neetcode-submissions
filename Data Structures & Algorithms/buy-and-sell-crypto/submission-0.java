class Solution {
    public int maxProfit(int[] prices) {
       if(prices.length <= 1) return 0;
       int res = 0;
       int curr = 0;
       int sell = 1;


       while(sell < prices.length){
        if(prices[curr] >= prices[sell]){
            curr++;
            sell = curr + 1;
        }
        else{
            res = Math.max(res, prices[sell] - prices[curr]);
            sell++;
        }
       }
       return res;
    }
}
