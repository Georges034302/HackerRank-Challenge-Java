/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author George
 */
public class MaxArraySum {
    public static List<int[]> subList(int[] a, int indexes[]) {          
        List<int[]> temp = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length + 1; j++) {                
                   temp.add(Arrays.copyOfRange(a, i, j));
            }
        }
        return temp;
    }

    public static long maxSubsetSum(int[] a) {
        
        List<int[]> lists = subList(a,new int[0]);
        HashMap<Long, Long> map = new HashMap();
        lists.forEach(list -> {
            long key = Arrays.stream(a).sum();
            map.put(key, key);
        });
        long max = map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        return max;
    }
    
    public static void main(String args[]) {
        int[] arr1 = {3, 7, 4, 6, 5};

        System.out.format("%d \n", maxSubsetSum(arr1));

        int[] arr2 = {2, 1, 5, 8, 4};
        System.out.format("%d \n", maxSubsetSum(arr2));
        
        int[] arr3 = {3, 5, -7, 8, 5};
        System.out.format("%d \n", maxSubsetSum(arr3));
    }
}
