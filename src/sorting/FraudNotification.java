/*
HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity. If the amount spent by a client on a particular day is greater than or equal to  the client's median spending for a trailing number of days, they send the client a notification about potential fraud. The bank doesn't send the client any notifications until they have at least that trailing number of prior days' transaction data.

Given the number of trailing days  and a client's total daily expenditures for a period of  days, determine the number of times the client will receive a notification over all  days.

Example


On the first three days, they just collect spending data. At day , trailing expenditures are . The median is  and the day's expenditure is . Because , there will be a notice. The next day, trailing expenditures are  and the expenditures are . This is less than  so no notice will be sent. Over the period, there was one notice sent.

Note: The median of a list of numbers can be found by first sorting the numbers ascending. If there is an odd number of values, the middle one is picked. If there is an even number of values, the median is then defined to be the average of the two middle values. (Wikipedia)

Function Description

Complete the function activityNotifications in the editor below.

activityNotifications has the following parameter(s):

int expenditure[n]: daily expenditures
int d: the lookback days for median spending
Returns

int: the number of notices sent
Input Format

The first line contains two space-separated integers  and , the number of days of transaction data, and the number of trailing days' data used to calculate median spending respectively.
The second line contains  space-separated non-negative integers where each integer  denotes .

Constraints

Output Format

Sample Input 0

STDIN               Function
-----               --------
9 5                 expenditure[] size n =9, d = 5
2 3 4 2 3 6 8 4 5   expenditure = [2, 3, 4, 2, 3, 6, 8, 4, 5]
Sample Output 0

2
Explanation 0

Determine the total number of  the client receives over a period of  days. For the first five days, the customer receives no notifications because the bank has insufficient transaction data: .

On the sixth day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which triggers a notification because : .

On the seventh day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which triggers a notification because : .

On the eighth day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which does not trigger a notification because : .

On the ninth day, the bank has  days of prior transaction data, , and a transaction median of  dollars. The client spends  dollars, which does not trigger a notification because : .

Sample Input 1

5 4
1 2 3 4 4
Sample Output 1

0
There are  days of data required so the first day a notice might go out is day . Our trailing expenditures are  with a median of  The client spends  which is less than  so no notification is sent.
 */
package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author George
 */
public class FraudNotification {

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int j = i - 1;
                int temp = arr[i];

                while ((j >= 0) && (arr[j] > temp)) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = temp;
            }
        }
        return arr;
    }

    public static int[] shuffleSort(int[] arr) {
        int pos;
        for (int i = 1; i <= arr.length; i++) {
            if (i != arr[i - 1]) {
                pos = arr[i - 1];
                arr[i - 1] = arr[pos - 1];
                arr[pos - 1] = pos;
                i--;
            }
        }
        return arr;
    }

    public static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    public static int[] trail(int[] arr, int i, int d) {
        int[] trail = new int[d];
        int k = 0;
        for (int j = i - d; j < i; j++) {
            trail[k++] = arr[j];
        }
        return trail;
    }

    public static double median2(int[] trail) {
        int l = trail.length;
        return (l % 2 != 0) ? trail[(l - 1) / 2] : (double) (trail[(l - 1) / 2] + trail[(l - 1) / 2 + 1]) / 2;
    }

    public static int minIndex(Queue<Integer> list, int sortIndex) {
        int min_index = -1;
        int min_value = Integer.MAX_VALUE;
        int s = list.size();
        for (int i = 0; i < s; i++) {
            int current = list.peek();
            list.poll();
            if (current <= min_value && i <= sortIndex) {
                min_index = i;
                min_value = current;
            }
            list.add(current);
        }
        return min_index;
    }

    public static void insertMinToRear(Queue<Integer> list, int min_index) {
        int min_value = 0;
        int s = list.size();
        for (int i = 0; i < s; i++) {
            int current = list.peek();
            list.poll();
            if (i != min_index) {
                list.add(current);
            } else {
                min_value = current;
            }
        }
        list.add(min_value);
    }

    public static void sortQueue(Queue<Integer> list) {
        for (int i = 1; i <= list.size(); i++) {
            int min_index = minIndex(list, list.size() - i);
            insertMinToRear(list, min_index);
        }
    }

    public static double median(Queue<Integer> queue) {
        int[] trail = queue.stream().mapToInt(Integer::intValue).toArray();
        int l = trail.length;
        return (l % 2 != 0) ? trail[(l - 1) / 2] : (double) (trail[(l - 1) / 2] + trail[(l - 1) / 2 + 1]) / 2;
    }

    public static Queue<Integer> queue(List<Integer> expenditure, int d) {
        Queue<Integer> temp = new LinkedList<>();
        for (int i = 0; i < d; i++) {
            temp.add(expenditure.get(i));
        }
        return temp;
    }

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int count = 0;
        Queue<Integer> temp = queue(expenditure, d);
        sortQueue(temp);
        for (int i = d; i < expenditure.size(); i++) {
            if (expenditure.get(i) >= 2 * median(temp)) {
                count++;
                System.out.format("%5s %-2d %-20s  ", "i =", i, "--> " + temp);
            }
            temp.poll();
            temp.add(expenditure.get(i));
            sortQueue(temp);
            System.out.format("%5s %-2d %-20s  ", "i =", i, "--> " + temp);
        }
        return count;
    }

    public static int activityNotifications2(List<Integer> expenditure, int d) {
        int count = 0;
        int[] arr = expenditure.stream().mapToInt(Integer::intValue).toArray();
        System.out.format("Array--> %-30s ", Arrays.toString(arr));
        for (int i = d; i < arr.length; i++) {
            int[] trail = trail(arr, i, d);
            quickSort(trail, 0, trail.length - 1);
            if (arr[i] >= 2 * median2(trail)) {
                System.out.format("%5s %-2d %-20s  ", "i =", i, "--> " + Arrays.toString(trail(arr, i, d)));
                count++;
            }
        }
        return count;
    }

    public static int activityNotifications3(List<Integer> expenditure, int d) {
        int[] arr = expenditure.stream().mapToInt(Integer::intValue).toArray();
        int[] counts = new int[201];
        for (int i = 0; i < d; i++) {
            counts[arr[i]]++;
        }

        int result = 0;
        for (int i = d; i < arr.length; i++) {
            int lower = 0;
            int leftNum = 0;
            while ((leftNum + counts[lower]) * 2 <= d) {
                leftNum += counts[lower];
                lower++;
            }

            int upper = counts.length - 1;
            int rightNum = 0;
            while ((rightNum + counts[upper]) * 2 <= d) {
                rightNum += counts[upper];
                upper--;
            }

            if (arr[i] >= lower + upper) {
                result++;
            }

            counts[arr[i - d]]--;
            counts[arr[i]]++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList(Arrays.asList(10, 20, 30, 40, 50));
        List<Integer> arr2 = new ArrayList(Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5));
        List<Integer> arr3 = new ArrayList(Arrays.asList(1, 2, 3, 4, 4));

        System.out.format("%s %d\n", "has N = ", activityNotifications3(arr1, 3));
        System.out.format("%s %d\n", "has N = ", activityNotifications3(arr2, 5));
        System.out.format("%s %d\n", "has N = ", activityNotifications3(arr3, 4));
    }

}
