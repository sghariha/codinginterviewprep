import java.util.Arrays;
import java.util.Collections;

public class Knapsack {
  public static void main(String[] args) {
    int[] weights1 = { 1, 2, 4 };
    int[] values1 = { 2, 4, 5 };
    int maxWeight1 = 5;
    System.out.println(knapsack(weights1, values1, maxWeight1));
  }

  public static int knapsack(int[] weights, int[] values, int maxWeight) {
    int[][] maxValues = new int[weights.length + 1][maxWeight + 1];
    for (int i = 0; i < maxValues.length; i++) {
      for (int j = 0; j < maxValues[0].length; j++) {
        if (i == 0 || j == 0)
          maxValues[i][j] = 0;
        else {
          if (j < weights[i - 1])
            maxValues[i][j] = maxValues[i - 1][j];
          else {
            int prevMax = maxValues[i - 1][j];
            int potentialMax = maxValues[i - 1][j - weights[i - 1]] + values[i - 1];
            maxValues[i][j] = prevMax > potentialMax ? prevMax : potentialMax;
          }
        }
      }
    }
    return maxValues[maxValues.length - 1][maxValues[0].length - 1];
  }

}