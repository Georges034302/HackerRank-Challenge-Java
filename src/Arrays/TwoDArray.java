package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Calculate the Max Sum of hourGlass in 2D-array.
 *
 */
public class TwoDArray {

   public static int[][] block(List<List<Integer>> arr, int fromRow, int toRow, int fromColumn, int toColumn) {
        int[][] array = arr.stream()
                .map(list -> list.stream()
                .mapToInt(i -> i)
                .toArray())
                .toArray(int[][]::new);
        int[][] box = new int[toColumn - fromColumn][];

        for (int i = fromColumn; i < toColumn; i++) {
            box[i - fromColumn] = Arrays.copyOfRange(array[i], fromRow, toRow);
        }

        return box;
    }

    public static int sum(int[][] arr) {
        int sum = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)
                .sum();
        return (sum - arr[1][0] - arr[1][2]);
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        List<Integer> sums = new ArrayList();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                showArray(block(arr, row, row+3, col, col+3));
                sums.add(sum(block(arr, row, row+3, col, col+3)));
            }
        }
        System.out.println(sums);

        return Collections.max(sums);
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

    public static void showArray(int[][] array) {
        System.out.println(Arrays.deepToString(array));
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 1, 0, 0, 0, 0));
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 0, 2, 4, 4, 0));
        arr.add(Arrays.asList(0, 0, 0, 2, 0, 0));
        arr.add(Arrays.asList(0, 0, 1, 2, 4, 0));
        showList(arr);
        System.out.println("Max Sum = " + hourglassSum(arr));
    }
}
