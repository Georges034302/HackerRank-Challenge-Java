/*
 The absolute difference is the positive difference between two values  and , is written  or  and they are equal. If  and , . Given an array of integers, find the minimum absolute difference between any two elements in the array.

Example. 

There are  pairs of numbers:  and . The absolute differences for these pairs are ,  and . The minimum absolute difference is .

Function Description

Complete the minimumAbsoluteDifference function in the editor below. It should return an integer that represents the minimum absolute difference between any pair of elements.

minimumAbsoluteDifference has the following parameter(s):

int arr[n]: an array of integers
Returns

int: the minimum absolute difference found
Input Format

The first line contains a single integer , the size of .
The second line contains  space-separated integers, .

Constraints

Sample Input 0

3
3 -7 0
Sample Output 0

3
Explanation 0

The first line of input is the number of array elements. The array,  There are three pairs to test: , , and . The absolute differences are:

Remember that the order of values in the subtraction does not influence the result. The smallest of these absolute differences is .

Sample Input 1

10
-59 -36 -13 1 -53 -92 -2 -96 -54 75
Sample Output 1

1
Explanation 1

The smallest absolute difference is .

Sample Input 2

5
1 -3 71 68 17
Sample Output 2

3
Explanation 2

The minimum absolute difference is .
 */
package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class MinABSDiff {

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < sorted.size()-1; i++){
            int currentMin = Math.abs(sorted.get(i)-sorted.get(i+1));
            min = Math.min(min, currentMin);
        }
        return min;
    }

    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList(Arrays.asList(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75));
        List<Integer> arr2 = new ArrayList(Arrays.asList(1, -3, 71, 68, -17));
        List<Integer> arr3 = new ArrayList(Arrays.asList(3, -7, 0));
        System.out.format("Array 1 :  %-50s ", arr1);
        System.out.format("  Min:  %-30s \n", minimumAbsoluteDifference(arr1));
        System.out.format("Array 2 :  %-50s ", arr2);
        System.out.format("  Min:  %-30s \n", minimumAbsoluteDifference(arr2));
        System.out.format("Array 3 :  %-50s ", arr3);
        System.out.format("  Min:  %-30s \n", minimumAbsoluteDifference(arr3));
    }
}
