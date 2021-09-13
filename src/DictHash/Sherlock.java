package DictHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Sherlock {

    public static String reversed(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static boolean isAnagram(String s) {
        return reversed(s).equals(s);
    }

    public static List<String> substringList(String s) {
        List<String> set = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                set.add(s.substring(i, j));
            }
        }
        return set;
    }    
    
    public static String generateKey(String str) {
        return str.chars().sorted().mapToObj(letter -> String.valueOf((char) letter)).collect(Collectors.joining());
    }

    public static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> sherlockMap = new HashMap<>();
        List<String> original = substringList(s);
        Iterator<String> iterator = original.iterator();
        while (iterator.hasNext()) {
            String key = generateKey(iterator.next());
            if (!sherlockMap.containsKey(key)) {
                sherlockMap.put(key, 0);
            }
            sherlockMap.put(key, sherlockMap.get(key) + 1);
        }

        return sherlockMap.values().stream().mapToInt(count -> count * (count - 1) / 2).sum();
    }

    public static void main(String[] args) {
        String s1 = "abba";
        String s2 = "kkkk";
        String s3 = "ifailuhkqq";
        System.out.println("s1: " + s1 + " \t\treversed = " + reversed(s1) + "\t\t\thas N = " + sherlockAndAnagrams(s1));
        System.out.println("s2: " + s2 + " \t\treversed = " + reversed(s2) + "\t\t\thas N = " + sherlockAndAnagrams(s2));
        System.out.println("s3: " + s3 + " \t\treversed = " + reversed(s3) + "\t\thas N = " + sherlockAndAnagrams(s3));
    }
}
