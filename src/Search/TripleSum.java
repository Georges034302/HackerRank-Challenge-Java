/*
Given  arrays  of different sizes, find the number of distinct triplets  where  is an element of , written as , , and , satisfying the criteria: .

For example, given  and , we find four distinct triplets: .

Function Description

Complete the triplets function in the editor below. It must return the number of distinct triplets that can be formed from the given arrays.

triplets has the following parameter(s):

a, b, c: three arrays of integers .
Input Format

The first line contains  integers , the sizes of the three arrays.
The next  lines contain space-separated integers numbering  respectively.

Constraints



Output Format

Print an integer representing the number of distinct triplets.

Sample Input 0

3 2 3
1 3 5
2 3
1 2 3
Sample Output 0

8 
Explanation 0

The special triplets are  .

Sample Input 1

3 3 3
1 4 5
2 3 3
1 2 3
Sample Output 1

5 
Explanation 1

The special triplets are 

Sample Input 2

4 3 4
1 3 5 7
5 7 9
7 9 11 13
Sample Output 2

12
Explanation 2

The special triplets are .
 */
package Search;

import static Search.Pairs.pairs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class TripleSum {

    static int index(int[] arr, int number) {
        int index = Arrays.binarySearch(arr, number);
        if (index < 0) {
            index = -1 - index - 1;
        }
        return index + 1;
    }

    static long triplets(int[] a, int[] b, int[] c) {

        Set<Integer> set1 = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(b).boxed().collect(Collectors.toSet());
        Set<Integer> set3 = Arrays.stream(c).boxed().collect(Collectors.toSet());

        int[] uniqA = set1.stream().mapToInt(Integer::intValue).toArray();
        int[] uniqB = set2.stream().mapToInt(Integer::intValue).toArray();
        int[] uniqC = set3.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(uniqA);
        Arrays.sort(uniqB);
        Arrays.sort(uniqC);

        long count = 0;
        System.out.println("A: " + Arrays.toString(uniqA));
        System.out.println("B: " + Arrays.toString(uniqB));
        System.out.println("C: " + Arrays.toString(uniqC));
        for (int B : uniqB) {
            int BinA = index(uniqA, B);
            int BinC = index(uniqC, B);
            count += (long) BinA * BinC;
        }

        return count;
    }

    public static void main(String args[]) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 3};
        int[] arr3 = {1, 2, 3};

        System.out.format("%d \n", triplets(arr1, arr2, arr3));

//        int[] arr1 = {4, 3, 4};
//        int[] arr2 = {1, 3, 5,7};
//        int[] arr3 = {5,7,9};
//
//        System.out.format("%d \n", triplets(arr1,arr2,arr3));
    }
}
