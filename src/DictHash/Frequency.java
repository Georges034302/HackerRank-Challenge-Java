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
public class Frequency {

    
    public static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> frqs = new HashMap<>();
        int[] qts = new int[queries.size() + 1];
        List<Integer> rslt = new ArrayList<>();
        int frq, cmd, v;

        for (List<Integer> query : queries) {
            cmd = query.get(0);
            v = query.get(1);
            if(cmd == 1){
                frq = frqs.getOrDefault(v, 0);
                frqs.put(v, frq+1);
                qts[frq]--;
                qts[frq+1]++;
            }else if(cmd == 2){
                frq = frqs.getOrDefault(v, 0);
                if(frq > 0){
                    frqs.put(v, frq-1);
                    qts[frq]--;
                    qts[frq-1]++;
                }
            }else if(cmd == 3){
                if(v > qts.length) rslt.add(0);
                else rslt.add(qts[v] > 0 ? 1 : 0);
            }
        }
        return rslt;
    }

    public static void main(String[] args) {
        List<List<Integer>> arr1 = Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(2, 2),
                Arrays.asList(3, 2),
                Arrays.asList(1, 1),
                Arrays.asList(1, 1),
                Arrays.asList(2, 1),
                Arrays.asList(3, 1)
        );
        List<List<Integer>> arr2 = Arrays.asList(
                Arrays.asList(1, 5),
                Arrays.asList(1, 6),
                Arrays.asList(3, 2),
                Arrays.asList(1, 10),
                Arrays.asList(1, 10),
                Arrays.asList(1, 6),
                Arrays.asList(2, 5),
                Arrays.asList(3, 2)
        );
        List<List<Integer>> arr3 = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(3, 2),
                Arrays.asList(1, 4),
                Arrays.asList(1, 5),
                Arrays.asList(1, 5),
                Arrays.asList(1, 4),
                Arrays.asList(3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 2)
        );
        System.out.println(freqQuery(arr1));
        System.out.println(freqQuery(arr2));
        System.out.println(freqQuery(arr3));
    }
}
