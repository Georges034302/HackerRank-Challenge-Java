/*
You are planning production for an order. You have a number of machines that each have a fixed number of days to produce an item. Given that all the machines operate simultaneously, determine the minimum number of days to produce the required order.

For example, you have to produce  items. You have three machines that take  days to produce an item. The following is a schedule of items produced:

Day Production  Count
2   2               2
3   1               3
4   2               5
6   3               8
8   2              10
It takes  days to produce  items using these machines.

Function Description

Complete the minimumTime function in the editor below. It should return an integer representing the minimum number of days required to complete the order.

minimumTime has the following parameter(s):

machines: an array of integers representing days to produce one item per machine
goal: an integer, the number of items required to complete the order
Input Format

The first line consist of two integers  and , the size of  and the target production.
The next line contains  space-separated integers, .

Constraints

Output Format

Return the minimum time required to produce  items considering all machines work simultaneously.

Sample Input 0

2 5
2 3
Sample Output 0

6
Explanation 0

In  days  can produce  items and  can produce  items. This totals up to .

Sample Input 1

3 10
1 3 4
Sample Output 1

7
Explanation 1

In  minutes,  can produce  items,  can produce  items and  can produce  item, which totals up to .

Sample Input 2

3 12
4 5 6
Sample Output 2

20
Explanation 2

In  days  can produce  items,  can produce , and  can produce .

Language
Java 8

More
123456789101112131415161718192021222324252627282930313233343536
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

Line: 48 Col: 1

Submit Code

Run Code

Upload Code as File

Test against custom input

 */
package Search;

import java.util.Arrays;

/**
 *
 * @author George
 */
public class MinimumTime {

    static long items(long[] machines, long days) {
        long items = 0;
        for (long machine : machines) {
            items += days / machine;
            if (items > Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }

        }
        return items;
    }

    static long items2(long[] machines, long days, int i, int last) {
        return (i < last) ? days / machines[last - 1 - i] + items2(machines, days, i + 1, last) : 0L;
    }

    static long minTime2(long[] machines, long goal) {
        long result = -1;
        long first = 0;
        long last = Long.MAX_VALUE;
        while (first <= last) {
            long middle = (first + last) / 2;
            if (items(machines, middle) >= goal) {
                result = middle;
                last = middle - 1;
            } else {
                first = middle + 1;
            }
        }
        return result;
    }

    static long minTime3(long[] machines, long goal) {
        long time = 0;

        while (true) {
            int items = 0;
            for (long machine : machines) 
                items += (time /machine);            

            if (items >= goal) 
                return time;            

            time++;
        }
    }
    
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long max = machines[machines.length - 1];
        long minDays = 0;
        long maxDays = max*goal;
        long result = -1;
        while (minDays < maxDays) {
            long mid = (minDays + maxDays) / 2;
            long unit = 0;
            for (long machine : machines) {
                unit += mid / machine;
            }
            if (unit < goal) {
                minDays = mid+1;
            } else {
                result = mid;
                maxDays = mid;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        long[] arr1 = {1, 3, 4};
        long goal = 10;
        System.out.format("%d \n", minTime(arr1, goal));

        long[] arr2 = {4, 5, 6};
        goal = 12;
        System.out.format("%d \n", minTime(arr2, goal));
    }
}
