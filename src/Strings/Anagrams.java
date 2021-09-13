/*
A student is taking a cryptography class and has found anagrams to be very useful. Two strings are anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency. For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

The student decides on an encryption scheme that involves two large strings. The encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Determine this number.

Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.

Example

Delete  from  and  from  so that the remaining strings are  and  which are anagrams. This takes  character deletions.

Function Description

Complete the makeAnagram function in the editor below.

makeAnagram has the following parameter(s):

string a: a string
string b: another string
Returns

int: the minimum total characters that must be deleted
Input Format

The first line contains a single string, .
The second line contains a single string, .

Constraints

The strings  and  consist of lowercase English alphabetic letters, ascii[a-z].
Sample Input

cde
abc
Sample Output

4
Explanation

Delete the following characters from the strings make them anagrams:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
It takes  deletions to make both strings anagrams.
 */
package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Anagrams {

    public static String reversed(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static boolean isAnagram(String s) {
        return reversed(s).equals(s);
    }

    public static String sorted(String s) {
        return s.chars().sorted().mapToObj(letter -> String.valueOf((char) letter)).collect(Collectors.joining());
    }

    public static List<Character> set(String s) {
        List<Character> set = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }

    @SuppressWarnings("empty-statement")
    public static int makeAnagram(String a, String b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        a.chars().forEach(c -> map.put(c, map.getOrDefault(c, 0) + 1));
        b.chars().forEach(c -> map.put(c, map.getOrDefault(c, 0) - 1));
        return map.values().stream().reduce(0, (subtotal, value) -> subtotal + Math.abs(value));
    }

    public static void main(String[] args) {
        String s1 = "fcrxzwscanmligyxyvym";
        String s2 = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        //String s1 = "cde";
        //String s2 = "abc";

        System.out.println("Anagrams N = " + makeAnagram(s1, s2));
    }

}
