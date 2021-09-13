package warmup;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 *  Count the number of duplicate pair in a list
 *  For Example: (1, 1, 3, 1, 2, 1, 3, 3, 3, 3) has 4 duplicate pairs as:
 *  (1,1) 2 times and (3,3) 2 times
 */
/**
 *
 * @author George
 */
public class DuplicatePair {

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here       
        Map<Integer, Long> freq = ar.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        int pair = 0;
        for (Long e : freq.values()) 
            pair+= e/2;        
            
        return pair;
    }

    public static void main(String[] args) {
        List<Integer> temp = new ArrayList(Arrays.asList(1, 1, 3, 1, 2, 1, 3, 3, 3, 3));
        System.out.println("Pair = " + sockMerchant(temp.size(), temp));
    }

}
