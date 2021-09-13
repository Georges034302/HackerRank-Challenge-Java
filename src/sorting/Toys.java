/*
 * Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some. There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money. Given a list of toy prices and an amount to spend, determine the maximum number of gifts he can buy.

Note Each toy can be purchased only once.

Example


The budget is  units of currency. He can buy items that cost  for , or  for  units. The maximum is  items.

Function Description

Complete the function maximumToys in the editor below.

maximumToys has the following parameter(s):

int prices[n]: the toy prices
int k: Mark's budget
Returns

int: the maximum number of toys
Input Format

The first line contains two integers,  and , the number of priced toys and the amount Mark has to spend.
The next line contains  space-separated integers 

Constraints




A toy can't be bought multiple times.

Sample Input

7 50
1 12 5 111 200 1000 10
Sample Output

4
Explanation

He can buy only  toys at most. These toys have the following prices: .
 */
package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author George
 */
public class Toys {

    public static int[] insertionSort(int[] arr) {        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int j = i - 1;
                int temp = arr[i];

                while ((j >= 0) && (arr[j] > temp)) {
                    arr[j + 1] = arr[j];                    
                    j--;
                }
                arr[j + 1] = temp;
            }
        }
        return arr;
    }
    
    public static boolean canBuy(int[] arr, int i, int k){
        return k > arr[i];
    }
    
    public static int maximumToys(List<Integer> prices, int k) {
        int count = 0;
        int [] arr = insertionSort(prices.stream().mapToInt(Integer::intValue).toArray());
        for(int i = 0; i < arr.length; i++){
            if(canBuy(arr,i,k)){
                count++;
                k -= arr[i];
            }
        }
        return count;
    }
    
     public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList(Arrays.asList(1, 12, 5, 111, 200, 1000, 10));
        List<Integer> arr2 = new ArrayList(Arrays.asList(1,2,3,4));

        System.out.println("Max toys = "+maximumToys(arr1,50));
        System.out.println("Max toys = "+maximumToys(arr2,7));
    }
}
