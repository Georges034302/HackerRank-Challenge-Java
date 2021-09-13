/*
Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.

Example

This is a valid string because frequencies are .


This is a valid string because we can remove one  and have  of each character in the remaining string.


This string is not valid as we can only remove  occurrence of . That leaves character frequencies of .

Function Description

Complete the isValid function in the editor below.

isValid has the following parameter(s):

string s: a string
Returns

string: either YES or NO
Input Format

A single string .

Constraints

Each character 
Sample Input 0

aabbcd
Sample Output 0

NO
Explanation 0

Given , we would need to remove two characters, both c and d  aabb or a and b  abcd, to make it valid. We are limited to removing only one character, so  is invalid.

Sample Input 1

aabbccddeefghi
Sample Output 1

NO
Explanation 1

Frequency counts for the letters are as follows:

{'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}

There are two ways to make the valid string:

Remove  characters with a frequency of : .
Remove  characters of frequency : .
Neither of these is an option.

Sample Input 2

abcdefghhgfedecba
Sample Output 2

YES
Explanation 2

All characters occur twice except for  which occurs  times. We can delete one instance of  to have a valid string.
 */
package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author George
 */
public class ValidString {

    public static Set<Character> set(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }

    public static String sorted(String str) {
        return str.chars().sorted().mapToObj(letter -> String.valueOf((char) letter)).collect(Collectors.joining());
    }

    public static String[] chars2(String s) {
        String[] temp = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            temp[i] = "" + s.charAt(i);
        }
        return temp;
    }

    public static Map<Character, Long> chars(String str) {
        String s = build(str);
        Map<Character, Long> map = new LinkedHashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }
        return map;
    }

    public static long count(Map<Character, Long> map, long value) {
        return map.entrySet().stream()
                .filter(e -> e.getValue() == value)
                .count();
    }

    public static String isValid2(String s) {
        Map<Character, Long> map = chars(s);

        long max = Collections.max(map.values());
        long min = Collections.min(map.values());

        long maxCount = count(map, max);
        long minCount = count(map, min);

        if (minCount == map.size() || maxCount == map.size()) {
            return "YES";
        } else if (minCount == 1 && maxCount == map.size() - 1 && Math.abs(max - min) == 1) {
            return "YES";
        } else if (maxCount == 1 && minCount == map.size() - 1 && Math.abs(max - min) == 1) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static String build(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static int[] keyArray(String s) {
        String str = build(s);
        int a[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            a[index]++;
        }
        return a;
    }

    public static Map<Integer, Integer> mapKeys(int[] a) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 26; i++) {
            if (a[i] != 0) {
                if (map.containsKey(a[i])) {
                    map.put(a[i], map.get(a[i]) + 1);
                } else {
                    map.put(a[i], 1);
                }
            }
        }
        return map;
    }

    public static String isValid(String s) {
        Map<Integer, Integer> map = mapKeys(keyArray(s));

        if (map.size() == 1) {
            return "YES";
        }
        if (map.size() == 2) {
            Set<Entry<Integer, Integer>> entrySet = map.entrySet();
            Iterator it = entrySet.iterator();
            Entry<Integer, Integer> e1 = (Entry<Integer, Integer>) it.next();
            int key1 = e1.getKey();
            int value1 = e1.getValue();
            Entry<Integer, Integer> e2 = (Entry<Integer, Integer>) it.next();
            int key2 = e2.getKey();
            int value2 = e2.getValue();
            if (value1 == 1 || value2 == 1 && Math.abs(key1 - key2) == 1) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        String s1 = "aabbcccddd";
        String s2 = "aabbccddeefghi";
        String s3 = "abcdefghhgfedecba";
        String s4 = "aaaaabc";
        String s5 = "aaaabbcc";

        System.out.println(" s1 - Result = " + isValid(s1));
        System.out.println(" s2 - Result = " + isValid(s2));
        System.out.println(" s3 - Result = " + isValid(s3));
        System.out.println(" s4 - Result = " + isValid(s4));
        System.out.println(" s5 - Result = " + isValid(s5));
    }
}
