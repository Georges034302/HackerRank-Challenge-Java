package DictHash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author George
 */
public class CountTriplets {

    public static boolean isGeo(List<Long> arr, int i, int j, int k, long r) {
        return arr.get(i) * Math.pow(r, 2) == arr.get(j) * r && arr.get(j) * r == arr.get(k);
    }

    public static long countTriplets2(List<Long> arr, long r) {
        HashMap<List<Integer>, Integer> set = new HashMap<>();

        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = i + 1; j < arr.size() - 1; j++) {
                for (int k = j + 1; k < arr.size(); k++) {
                    if (isGeo(arr, i, j, k, r)) {
                        set.put(Arrays.asList(i, j, k), 1);
                    }
                }
            }
        }
        //set.forEach((key, value) -> System.out.println(key + " " + value));
        return set.entrySet().stream().mapToInt(x -> x.getValue()).sum();
    }

    public static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> left = new HashMap<>();
        Map<Long, Long> right = new HashMap<>();

        arr.forEach(item -> { right.put(item, right.getOrDefault(item, 0L) + 1); });

        long count = 0;

        for (int i = 0; i < arr.size(); i++) {
            long mid = arr.get(i);
            long c1 = 0, c3 = 0;

            right.put(mid, right.getOrDefault(mid, 0L) - 1);

            if (left.containsKey(mid / r) && mid % r == 0) {
                c1 = left.get(mid / r);
            }

            if (right.containsKey(mid * r)) {
                c3 = right.get(mid * r);
            }

            count += c1 * c3;

            left.put(mid, left.getOrDefault(mid, 0L) + 1);

        }
        return count;
    }

    public static void main(String[] args) {
        List<Long> arr1 = new ArrayList((Arrays.asList(1L, 2L, 2L, 4L)));
        List<Long> arr2 = new ArrayList((Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L)));
        List<Long> arr3 = new ArrayList((Arrays.asList(1L, 5L, 5L, 25L, 125L)));
        System.out.println("ratio: " + 2 + " \t\thas N = " + countTriplets(arr1, 2) + " Triplets");
        System.out.println("ratio: " + 3 + " \t\thas N = " + countTriplets(arr2, 3) + " Triplets");
        System.out.println("ratio: " + 5 + " \t\thas N = " + countTriplets(arr3, 5) + " Triplets");
    }
}
