/*
A group of friends want to buy a bouquet of flowers. The florist wants to maximize his number of new customers and the money he makes. To do this, he decides he'll multiply the price of each flower by the number of that customer's previously purchased flowers plus . The first flower will be original price, , the next will be  and so on.

Given the size of the group of friends, the number of flowers they want to purchase and the original prices of the flowers, determine the minimum cost to purchase all of the flowers. The number of flowers they want equals the length of the  array.

Example


The length of , so they want to buy  flowers total. Each will buy one of the flowers priced  at the original price. Having each purchased  flower, the first flower in the list, , will now cost . The total cost is .

Function Description

Complete the getMinimumCost function in the editor below.

getMinimumCost has the following parameter(s):

int c[n]: the original price of each flower
int k: the number of friends
Returns
- int: the minimum cost to purchase all flowers

Input Format

The first line contains two space-separated integers  and , the number of flowers and the number of friends.
The second line contains  space-separated positive integers , the original price of each flower.

Constraints

Sample Input 0

3 3
2 5 6
Sample Output 0

13
Explanation 0

There are  flowers with costs  and  people in the group. If each person buys one flower, the total cost of prices paid is  dollars. Thus, we print  as our answer.

Sample Input 1

3 2
2 5 6
Sample Output 1

15
Explanation 1

There are  flowers with costs  and  people in the group. We can minimize the total purchase cost like so:

The first person purchases  flowers in order of decreasing price; this means they buy the more expensive flower () first at price  dollars and the less expensive flower () second at price  dollars.
The second person buys the most expensive flower at price  dollars.
We then print the sum of these purchases, which is , as our answer.

Sample Input 2

5 3
1 3 5 7 9
Sample Output 2

29
Explanation 2

The friends buy flowers for ,  and ,  and  for a cost of 
 */
package GreedyAlgorithm;
import java.util.Arrays;
/**
 *
 * @author George
 */
public class GreedyFlorist {
    //New Price = original(number of previous customers + 1)
    public static int getMinimumCost(int k, int[] c) {
        int cost = 0;
        int count = 1;
        Arrays.sort(c);
        for(int i = c.length-1; i >=0 ; count++)
            for(int j = 0; j < k && i >= 0; j++, i--)
                cost += c[i] * count;                
        return cost;
    }
    
    public static void main(String[] args) {        
        int[] arr1 = {2,5,6};
        int k = 3;
        System.out.format("%-20s k = %d --> Min:  %d \n", Arrays.toString(arr1), k,getMinimumCost(k,arr1));
        int[] arr2 = {1,3,5,7,9};
        k = 3;
        System.out.format("%-20s k = %d --> Min:  %d \n", Arrays.toString(arr2), k,getMinimumCost(k,arr2));
        int[] arr3 = {2,5,6};
        k = 2;
        System.out.format("%-20s k = %d --> Min:  %d \n", Arrays.toString(arr3), k,getMinimumCost(k,arr3));
    }
}
