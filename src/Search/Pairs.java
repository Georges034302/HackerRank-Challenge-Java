/*
Given an array of integers and a target value, determine the number of pairs of array elements that have a difference equal to the target value.

Example


There are three values that differ by : , , and . Return .

Function Description

Complete the pairs function below.

pairs has the following parameter(s):

int k: an integer, the target difference
int arr[n]: an array of integers
Returns

int: the number of pairs that satisfy the criterion
Input Format

The first line contains two space-separated integers  and , the size of  and the target value.
The second line contains  space-separated integers of the array .

Constraints

each integer  will be unique
Sample Input

STDIN       Function
-----       --------
5 2         arr[] size n = 5, k =2
1 5 3 4 2   arr = [1, 5, 3, 4, 2]
Sample Output

3
Explanation

There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1]. .
 */
package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 *
 * @author George
 */
public class Pairs {

    public static HashMap<Integer, Integer> mapPairs3(int k, List<Integer> arr) {
        Collections.sort(arr);
        System.out.println(arr);
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.size() - 1; i++) {
            int j = i + 1;
            while (j < arr.size()) {
                int current = arr.get(i);
                int other = arr.get(j);

                int key = other - current;
                if (key == k) {
                    map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
                }
                j++;
            }
        }

        return map;
    }

    @SuppressWarnings("empty-statement")
    public static int pairs3(int k, List<Integer> arr) {
        HashMap<Integer, Integer> map = mapPairs3(k, arr);

        return map.values().stream().reduce(0, Integer::sum);
    }

    public static int pairs2(int k, List<Integer> arr) {
        Collections.sort(arr);
        List<Integer> ids = new ArrayList();
        int count = 0;
        IntStream.range(0, arr.size() - 1)
                .forEach(i -> {
                    IntStream.range(1, arr.size()).forEach(j -> {
                        if (arr.get(j) - arr.get(i) == k) {
                            ids.add(1);
                        }
                    });
                });
        return ids.stream().mapToInt(Integer::intValue).sum();
    }

    public static int pairs(int k, List<Integer> arr) {
        Collections.sort(arr);

        int count = 0;
        for (int i = 0, j = 1; i < arr.size() && j < arr.size();) {
            int key = arr.get(j) - arr.get(i);
            if (key == k) { 
                count++;
                i++;
                j++;
            } else if (key < k) { 
                j++;
            } else { 
                i++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        List<Integer> arr1 = new ArrayList(Arrays.asList(1, 5, 3, 4, 2));
        int k = 2;
        System.out.format("%d \n", pairs(k, arr1));

//        List<Integer> arr2 = new ArrayList(Arrays.asList(2, 2, 4, 3));
//        k = 4;
//        System.out.format("%d \n", pairs(k,arr2));
    }
}
