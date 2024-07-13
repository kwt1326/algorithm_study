package ko.me;

// Greedy
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
public class _MEDIUM_122_Best_Time_to_Buy_and_Sell_Stock_II {

    // 여러 번 사고 팔수 있고, 다음 지수를 미리 알수 있기 때문에 오르면 바로 사고 팔기 (다음 값으로 현재 값을 빼서 취함)
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] < prices[i + 1]) {
                profit += (prices[i + 1] - prices[i]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        assert maxProfit(prices) == 7;
    }
}
