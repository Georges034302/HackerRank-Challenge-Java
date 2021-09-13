/*
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in the array.

Example


Queries are interpreted as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of  between the indices  and  inclusive:

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
The largest value is  after all operations are performed.

Function Description

Complete the function arrayManipulation in the editor below.

arrayManipulation has the following parameters:

int n - the number of elements in the array
int queries[q][3] - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
Returns

int - the maximum value in the resultant array
Input Format

The first line contains two space-separated integers  and , the size of the array and the number of operations.
Each of the next  lines contains three space-separated integers ,  and , the left index, right index and summand.

Constraints

Sample Input

5 3
1 2 100
2 5 100
3 4 100
Sample Output

200
Explanation

After the first update the list is 100 100 0 0 0.
After the second update list is 100 200 100 100 100.
After the third update list is 100 200 200 200 100.

The maximum value is .
 */
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayManipulation {

    public static int nextInt() {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        scanner.nextLine(); // read the "\n" as well
        return value;
    }

    public static void setValue(List<List<Integer>> list, int row, int column, int value) {
        list.get(row).set(column, list.get(row).get(column) + value);
    }

    public static void updateMatrix(List<List<Integer>> list) {
        System.out.print("a = ");
        int start = nextInt();  //start column
        System.out.print("b = ");
        int end = nextInt(); //end column
        System.out.print("k = ");
        int k = nextInt();  //value updated
        for (int col = start; col < end; col++) {
            setValue(list, 0, col, k);
        }
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        System.out.print("m = ");
        int m = nextInt(); //number of operations
        for (int i = 0; i < m; i++) {
            updateMatrix(queries);
            showList(queries);
        }
        return Collections.max(queries.get(0));
    }

    public static long arrayManipulation2(int n, List<List<Integer>> queries) {
              
        int[][] array = queries.stream()
                .map(list -> list.stream()
                .mapToInt(i -> i)
                .toArray())
                .toArray(int[][]::new);

        long outputArray[] = new long[n + 2];
        for (int i = 0; i < array.length; i++) {
            int a = array[i][0];
            int b = array[i][1];
            int k = array[i][2];
            outputArray[a] += k;
            outputArray[b + 1] -= k;                     
        }               
        return getMax(outputArray);
    }   
    
    private static long getMax(long[] inputArray) {
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            sum += inputArray[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void showList(List<List<Integer>> arr) {
        arr.stream().map(list -> {
            list.forEach(i -> {
                System.out.print(i + " ");
            });
            return list;
        }).forEachOrdered(_item -> {
            System.out.println();
        });
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        showList(arr);
        System.out.println("Max = " + arrayManipulation(4, arr));
    }
}
