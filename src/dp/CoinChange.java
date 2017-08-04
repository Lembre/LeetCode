package dp; /**

 You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 You may assume that you have an infinite number of each kind of coin.
 */

import java.util.Arrays;

/**
 * dp 三板斧
 * 1. 判断维数
 * 2. 递推公式（注意查看边界条件）
 * 3. 滚动数组（减少空间复杂性）
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int ans = solution2(coins, 11);
        System.out.println(ans);
    }

    public static int solution(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }

        int[][] arr = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            arr[i][0] = 0;
        }

        for (int i = 0; i < amount +1; i++) {
            arr[0][i] = i;
        }


        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i] <= j) {
                    arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - coins[i]] + 1);
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }

        return arr[coins.length -1 ][amount];
    }

    // 滚动数组
    public static int solution2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
