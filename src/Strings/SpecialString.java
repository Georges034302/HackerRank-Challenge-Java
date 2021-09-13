/*
A string is said to be a special string if either of two conditions is met:

All of the characters are the same, e.g. aaa.
All characters except the middle one are the same, e.g. aadaa.
A special substring is any substring of a string which meets one of those criteria. Given a string, determine how many special substrings can be formed from it.

Example

s contains the following  special substrings: 

Function Description
Complete the substrCount function in the editor below.
substrCount has the following parameter(s):
int n: the length of string s
string s: a string
Returns
- int: the number of special substrings

Input Format
The first line contains an integer, , the length of .
The second line contains the string .

Constraints
Each character of the string is a lowercase English letter, .

Sample Input 0
5
asasd
Sample Output 0

7 
Explanation 0
The special palindromic substrings of  are 

Sample Input 1
7
abcbaba
Sample Output 1

10 
Explanation 1
The special palindromic substrings of  are 
Sample Input 2

4
aaaa
Sample Output 2
10
Explanation 2
The special palindromic substrings of  are 

 */
package Strings;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author George
 */
public class SpecialString {

    public static List<String> substringList(int n, String s) {
        List<String> set = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                set.add(s.substring(i, j));
            }
        }
        return set;
    }

    public static Map<String, Long> substringMap(int n, String str) {
        List<String> sublist = substringList(n, str);
        Map<String, Long> map = new LinkedHashMap<>(sublist.size());
        sublist.forEach(key -> {
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        });
        return map;
    }

    public static boolean middleMatch(String sub) {
        char first = sub.charAt(0);
        char mid = sub.charAt(sub.length() / 2);
        int count = 0;
        for (int i = 0; i < sub.length(); i++) {
            if (sub.charAt(i) == first && sub.charAt(i) != mid) {
                count++;
            } 
        }
        return count == sub.length()-1;
    }

    public static boolean isSame(String sub) {
        char first = sub.charAt(0);
        boolean all = sub.chars().allMatch(c -> c == first);
        return all;
    }

    public static long substrCount2(int n, String s) {
        Map<String, Long> map = substringMap(n, s);
        System.out.print(map);
        long result = map.keySet().stream().filter(key -> isSame(key) || middleMatch(key)).map(key -> map.get(key)).reduce(0L, (a, b) -> a + b);

        return result;
    }

    
    public static long substrCount(int n, String str) {
        long result = 0;
        long[] sameChar = new long[n];
        
        int i = 0;
        while (i < n) {
            long count = 1;
            int j = i + 1;
            while (j < n && str.charAt(i) == str.charAt(j)) {
                count++;
                j++;
            }

            result += (count * (count + 1) / 2);
            sameChar[i] = count;
            i = j;
        }

        for (int j = 1; j < n; j++) {

            if (str.charAt(j) == str.charAt(j - 1)) {
                sameChar[j] = sameChar[j - 1];
            }

            if (j > 0 && j < (n - 1)  && (str.charAt(j - 1) == str.charAt(j + 1) && str.charAt(j) != str.charAt(j - 1))) {
                result += Math.min(sameChar[j - 1], sameChar[j + 1]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s1 = "asasd";
        String s2 = "abcbaba";
        String s3 = "aaaa";

        System.out.println(" s1 - Result = " + substrCount(5, s1)); //7
        System.out.println(" s2 - Result = " + substrCount(7, s2)); //10
        System.out.println(" s3 - Result = " + substrCount(4, s3)); //10
    }
}
