/*
We define the following:

A subarray of array  of length  is a contiguous segment from  through  where .
The sum of an array is the sum of its elements.
Given an  element array of integers, , and an integer, , determine the maximum value of the sum of any of its subarrays modulo .

Example


The following table lists all subarrays and their moduli:

		sum	%2
[1]		1	1
[2]		2	0
[3]		3	1
[1,2]		3	1
[2,3]		5	1
[1,2,3]		6	0
The maximum modulus is .

Function Description

Complete the maximumSum function in the editor below.

maximumSum has the following parameter(s):

long a[n]: the array to analyze
long m: the modulo divisor
Returns
- long: the maximum (subarray sum modulo )

Input Format

The first line contains an integer , the number of queries to perform.

The next  pairs of lines are as follows:

The first line contains two space-separated integers  and (long), the length of  and the modulo divisor.
The second line contains  space-separated long integers .
Constraints

 the sum of  over all test cases 
Sample Input

STDIN       Function
-----       --------
1           q = 1
5 7         a[] size n = 5, m = 7
3 3 9 9 5
Sample Output

6
Explanation

The subarrays of array  and their respective sums modulo  are ranked in order of length and sum in the following list:
The maximum value for  for any subarray is .
 */
package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class MaxSubarraySum {

    public static List<List<Long>> subList(List<Long> a) {
        List<List<Long>> temp = new ArrayList();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i; j < a.size() + 1; j++) {
                if (!a.subList(i, j).isEmpty()) {
                    temp.add(a.subList(i, j));
                }
            }
        }
        return temp;
    }

    public static long maximumSum2(List<Long> a, long m) {
        List<List<Long>> lists = subList(a);
        HashMap<Long, Long> map = new HashMap();
        lists.forEach(list -> {
            long key = list.stream().mapToLong(Long::longValue).sum();
            map.put(key, key % m);
        });
        long max = map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        return max;
    }

    static long maximumSum(List<Long> a, long m) {
        long[] sums = buildSums(a.stream().mapToLong(l -> l).toArray(), m);

        long result = Arrays.stream(sums).max().getAsLong();
        NavigableSet<Long> sortedSums = new TreeSet<>();
        for (long sum : sums) {
            Long higher = sortedSums.higher(sum);
            if (higher != null) {
                result = Math.max(result, addMod(sum, -higher, m));
            }

            sortedSums.add(sum);
        }
        return result;
    }

    static long[] buildSums(long[] a, long m) {
        long[] sums = new long[a.length];
        long sum = 0;
        for (int i = 0; i < sums.length; i++) {
            sum = addMod(sum, a[i], m);
            sums[i] = sum;
        }
        return sums;
    }

    static long addMod(long x, long y, long modulus) {
        return ((x + y) % modulus + modulus) % modulus;
    }

    static long maximumSum3(List<Long> a, long m) {
        long prefix = 0;
        long maxim = 0;
        Set<Long> S = new HashSet();
        S.add(0L);
        for (int i = 0; i < a.size(); i++) {
            prefix = (prefix + a.get(i)) % m;
            maxim = Math.max(maxim, prefix);

            long smallest = 0;

            for (long e : S) {
                if (e >= prefix + 1) {
                    smallest = e;
                }
            }
            if (smallest != 0) {
                maxim = Math.max(maxim, prefix - smallest + m);
            }
            S.add(prefix);
        }
        return maxim;
    }

    public static void main(String args[]) {
        List<Long> arr1 = new ArrayList(Arrays.asList(3L, 3L, 9L, 9L, 5L));
        long m = 7;
        System.out.format("%d \n", maximumSum(arr1, m));

        List<Long> arr2 = new ArrayList(Arrays.asList(1L, 5L, 9L));
        m = 5;
        System.out.format("%d \n", maximumSum(arr2, m));
    }
}
