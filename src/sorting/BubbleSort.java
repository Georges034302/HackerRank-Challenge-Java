package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author George
 */
public class BubbleSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void countSwaps(List<Integer> a) {
        int count = 0;
        int [] arr = a.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {                
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                    count++;
                }
            }
        }
        System.out.println("Array is sorted in "+count+" swaps.");
        System.out.println("First Element: "+arr[0]);
        System.out.println("Last Element: "+arr[arr.length-1]);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList(Arrays.asList(6,4,1));
        List<Integer> arr2 = new ArrayList(Arrays.asList(3,2,1));
        List<Integer> arr3 = new ArrayList(Arrays.asList(1,2,3));

        countSwaps(arr1);
        countSwaps(arr2);
        countSwaps(arr3);
    }
}
