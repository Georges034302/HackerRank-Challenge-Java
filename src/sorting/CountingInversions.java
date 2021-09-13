/*
 In an array, , the elements at indices  and  (where ) form an inversion if . In other words, inverted elements  and  are considered to be "out of order". To correct an inversion, we can swap adjacent elements.

Example


To sort the array, we must perform the following two swaps to correct the inversions:

The sort has two inversions:  and .
Given an array , return the number of inversions to sort the array.

Function Description

Complete the function countInversions in the editor below.

countInversions has the following parameter(s):

int arr[n]: an array of integers to sort
Returns

int: the number of inversions
Input Format

The first line contains an integer, , the number of datasets.

Each of the next  pairs of lines is as follows:

The first line contains an integer, , the number of elements in .
The second line contains  space-separated integers, .
Constraints

Sample Input

STDIN       Function
-----       --------
2           d = 2
5           arr[] size n = 5 for the first dataset
1 1 1 2 2   arr = [1, 1, 1, 2, 2]
5           arr[] size n = 5 for the second dataset     
2 1 3 1 2   arr = [2, 1, 3, 1, 2]
Sample Output

0  
4   
Explanation

We sort the following  datasets:

 is already sorted, so there are no inversions for us to correct.
We performed a total of  swaps to correct inversions.
 */
package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author George
 */
public class CountingInversions {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static long mergeSort(int[] a, int start, int end) {
        if (start == end)
            return 0;

        int mid = (start + end) / 2;
        long inversions = mergeSort(a, start, mid) +
                          mergeSort(a, mid + 1, end) +
                          merge(a, start, end);
        return inversions;
    }

    public static long merge(int[] a, int start, int end) {
        int[] tmp = new int[end - start + 1];
        long inversions = 0;

        int mid = (start + end) / 2;

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (a[i] > a[j]) {
                tmp[k++] = a[j++];
                inversions += mid - i + 1;
            } else {
                tmp[k++] = a[i++];
            }
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= end) {
            tmp[k++] = a[j++];
        }
        System.arraycopy(tmp, 0, a, start, end - start + 1);
        return inversions;
    }

    public static long countInversions(List<Integer> arr) {        
        int[] a = arr.stream().mapToInt(Integer::intValue).toArray();
        return mergeSort(a,0,arr.size()-1);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList(Arrays.asList(2, 1, 3, 1, 2));
        System.out.println("Inversions = " + countInversions(arr));
    }
}
