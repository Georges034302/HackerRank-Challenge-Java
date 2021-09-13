/*
You will be given a list of integers, , and a single integer . You must create an array of length  from elements of  such that its unfairness is minimized. Call that array . Unfairness of an array is calculated as

Where:
- max denotes the largest integer in 
- min denotes the smallest integer in 

Example



Pick any two elements, say .

Testing for all pairs, the solution  provides the minimum unfairness.

Note: Integers in  may not be unique.

Function Description

Complete the maxMin function in the editor below.
maxMin has the following parameter(s):

int k: the number of elements to select
int arr[n]:: an array of integers
Returns

int: the minimum possible unfairness
Input Format

The first line contains an integer , the number of elements in array .
The second line contains an integer .
Each of the next  lines contains an integer  where .

Constraints




Sample Input 0

7
3
10
100
300
200
1000
20
30
Sample Output 0

20
Explanation 0

Here ; selecting the  integers , unfairness equals

max(10,20,30) - min(10,20,30) = 30 - 10 = 20
Sample Input 1

10
4
1
2
3
4
10
20
30
40
100
200
Sample Output 1

3
Explanation 1

Here ; selecting the  integers , unfairness equals

max(1,2,3,4) - min(1,2,3,4) = 4 - 1 = 3
Sample Input 2

5
2
1
2
1
2
1
Sample Output 2

0
Explanation 2

Here .  or  give the minimum unfairness of .
 */
package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class MaxMin {

    public static int maxMin(int k, List<Integer> arr) {
        int result = Integer.MAX_VALUE;
        List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());

        for(int i = 0; i < sorted.size()-k+1; i++)
            result = Integer.min(sorted.get(i+k-1)-sorted.get(i),result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList(Arrays.asList(5, 2, 1, 2, 1, 2, 1));
        List<Integer> arr2 = new ArrayList(Arrays.asList(7, 3, 10, 100, 300, 200, 1000, 20, 30));
        List<Integer> arr3 = new ArrayList(Arrays.asList(10, 4, 1, 2, 3, 4, 10, 20, 30, 40, 100, 200));
        int k = 2;
        System.out.format("Array 1 :  %-50s ", arr1);
        System.out.format("\n >> Min-Max:  %-30s \n", maxMin(k, arr1));
        System.out.format("Array 2 :  %-50s ", arr2);
        k = 3;
        System.out.format("\n >> Min-Max:  %-30s \n", maxMin(k, arr2));
        System.out.format("Array 3 :  %-50s ", arr3);
        k = 4;
        System.out.format("\n >> Min-Max:  %-30s \n", maxMin(k, arr3));
    }
}
