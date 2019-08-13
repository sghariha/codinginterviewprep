public class CoinChange {

  public static void main(String[] args) {
    int[] coinList1 = { 1, 2, 5 };
    int coinList1Output = coinChange(coinList1, 5);
    System.out.println("Coin list 1: " + coinList1Output);

    int[] coinList2 = { 1, 2, 3, 4, 5 };
    int coinList2Output = coinChange(coinList2, 5);
    System.out.println("Coin list 2: " + coinList2Output);
  }

  public static int coinChange(int[] coins, int total) {
    int[] combinations = new int[total + 1];
    // Base case
    combinations[0] = 1;
    // Memoize solution for n based on n - coin
    for (int coin : coins) {
      for (int x = 1; x <= total; x++) {
        if (x >= coin) {
          combinations[x] += combinations[x - coin];
        }
      }
    }
    return combinations[total];
  }
}