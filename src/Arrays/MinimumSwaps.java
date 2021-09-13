/*
 *You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending order.

Example


Perform the following steps:

i   arr                         swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
It took  swaps to sort the array.

Function Description

Complete the function minimumSwaps in the editor below.

minimumSwaps has the following parameter(s):

int arr[n]: an unordered array of integers
Returns

int: the minimum number of swaps to sort the array
Input Format

The first line contains an integer, , the size of .
The second line contains  space-separated integers .

Constraints

Sample Input 0

4
4 3 1 2
Sample Output 0

3
Explanation 0

Given array 
After swapping  we get 
After swapping  we get 
After swapping  we get 
So, we need a minimum of  swaps to sort the array in ascending order.

Sample Input 1

5
2 3 4 1 5
Sample Output 1

3
Explanation 1

Given array 
After swapping  we get 
After swapping  we get 
After swapping  we get 
So, we need a minimum of  swaps to sort the array in ascending order.

Sample Input 2

7
1 3 5 2 4 6 7
Sample Output 2

3
Explanation 2

Given array 
After swapping  we get 
After swapping  we get 
After swapping  we get 
So, we need a minimum of  swaps to sort the array in ascending order.
 */
package Arrays;

import java.util.Arrays;

public class MinimumSwaps {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static int bubbleSort3(int[] arr) {
        int count = 0;
        int rightmostSwap = arr.length - 1;
        System.out.println(Arrays.toString(arr));
        while (rightmostSwap > 0) {
            int right = rightmostSwap;
            rightmostSwap = 0;

            for (int i = 0; i < right; ++i) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    count++;
                    rightmostSwap = i;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
        return count;
    }

    public static int bubbleSort2(int[] arr) {
        int count = 0;
        boolean elementsSwitched = true;
        int right = arr.length - 1;
        System.out.println(Arrays.toString(arr));
        while (elementsSwitched == true & right > 0) {
            elementsSwitched = false;

            for (int i = 0; i < right; ++i) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    elementsSwitched = true;
                    count++;
                    System.out.println(Arrays.toString(arr));
                }
            }
            --right;
        }
        return count;
    }

    public static int bubbleSort1(int[] arr) {
        int count = 0;
        System.out.println(Arrays.toString(arr));
        for (int right = arr.length - 1; right > 0; right--) {
            for (int i = 0; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    count++;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
        return count;
    }

    public static int minPos(int[] y, int first, int last) {
        int minPosSoFar = first;

        for (int i = first + 1; i <= last; i++) {
            if (y[i] < y[minPosSoFar]) {
                minPosSoFar = i;
            }
        }
        return minPosSoFar;
    }

    public static int selectionSort(int[] arr) {
        int chosen;
        int count = 0;
        for (int leftmost = 0; leftmost < arr.length - 1; leftmost++) {
            chosen = minPos(arr, leftmost, arr.length - 1);
            swap(arr, leftmost, chosen);
            count++;
        }
        return count;
    }

    public static int insertionSort(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int j = i - 1;
                int temp = arr[i];

                while ((j >= 0) && (arr[j] > temp)) {
                    arr[j + 1] = arr[j];
                    count++;
                    j--;
                }
                arr[j + 1] = temp;

            }
        }
        return count;
    }

    public static int shuffleSort(int[] arr) {
        int count = 0;
        if (arr.length == 1) 
            return 0;        

        int pos;
        for (int i = 1; i <= arr.length; i++) {
            if (i != arr[i - 1]) {
                pos = arr[i - 1];
                arr[i - 1] = arr[pos - 1];
                arr[pos - 1] = pos;                
                count++;
                i--;
            }
        }
        return count;
    }

    public static int minimumSwaps(int[] arr) {

        return shuffleSort(arr);
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2};

        System.out.println("Mininum swaps = " + minimumSwaps(arr));
    }
}
