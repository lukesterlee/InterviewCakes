package nyc.c4q.lukesterlee;

import java.util.Stack;

public class Main {

    // answer from the website. soooo beautiful and elegant!
    public static int awesomeAnswer(int[] array) {
        if (array.length < 2) {
            return 0;
        }
        int min_price = array[0];
        int max_profit = array[1] - array[0];
        int potential_profit;
        for (int i = 1; i < array.length; i++) {
            potential_profit = array[i] - min_price;
            max_profit = Math.max(max_profit, potential_profit);
            min_price = Math.min(min_price, array[i]);
        }
        return max_profit;
    }

    // My answer for Interview Cake #1, very messy :(
    public static int get_max_profit(int[] array) {
        int maxIndex = 0;
        int minIndex = 0;
        int minimizeRiskIndex = 0;
        boolean hasExperiencedIncrease = false;

        if (array[0] > array[1])
            minimizeRiskIndex = 1;

        for (int i = 1; i < array.length - 1; i++) {

            if (hasExperiencedIncrease) {
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            } else {
                if (array[i] < array[i+1]) {
                    hasExperiencedIncrease = true;
                    minIndex = i;
                    maxIndex = i+1;
                }
            }
        }

        if (hasExperiencedIncrease)
            return array[maxIndex] - array[minIndex];
        else {
            return array[minimizeRiskIndex] - array[maxIndex];
        }
    }

    // Interview Cake #2
    // this is my best shot :(
    public static int[] get_products_of_all_ints_except_at_index(int[] array) {
        int[] answer = new int[array.length];

        int left = 1;
        for (int i = 0; i < array.length; i++) {

            if (i == 0)
                answer[i] = array[i] * right(array, i+1);
            else if (i == array.length - 1) {
                left *= array[i - 1];
                answer[i] = left;
            } else {
                left *= array[i-1];
                answer[i] = left * right(array, i+1);
            }
        }
        return answer;
    }

    public static int right(int[] array, int index) {
        if (index == array.length - 1)
            return array[index];
        else
            return array[index] * right(array, index + 1);
    }

    public static void main(String[] args) {
	// write your code here
//        int[] stock_prices_yesterday = new int[]{10, 8, 4, 7, 6, 5, 4, 3};
//        System.out.println(awesomeAnswer(stock_prices_yesterday));
//        System.out.println(get_max_profit(stock_prices_yesterday));

        int[] array = {1, 7, 2, 3};
        int[] array2 = get_products_of_all_ints_except_at_index(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array2[i] + " ");
        }
        //System.out.println(get_products_of_all_ints_except_at_index(array).toString());
    }
}
