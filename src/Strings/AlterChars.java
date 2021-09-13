/*
You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.

Example

Remove an  at positions  and  to make  in  deletions.

Function Description

Complete the alternatingCharacters function in the editor below.

alternatingCharacters has the following parameter(s):

string s: a string
Returns

int: the minimum number of deletions required
Input Format

The first line contains an integer , the number of queries.
The next  lines each contain a string  to analyze.

Constraints

Each string  will consist only of characters  and .
Sample Input

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Sample Output

3
4
0
0
4
Explanation

The characters marked red are the ones that can be deleted so that the string does not have matching adjacent characters.
 */
package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author George
 */
public class AlterChars {

    public static int alternatingCharacters(String s) {        
        List<Character> set = new ArrayList<>();
        int i = 0;
        set.add(s.charAt(i));
        for (i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                set.add(s.charAt(i));
            }
        }    
        System.out.format("%-25s",set);
        return s.length()-set.size();
    }

    public static void main(String[] args) {
        String s1 = "AAAA";
        String s2 = "BBBBB";
        String s3 = "ABABABAB";
        String s4 = "BABABA";
        String s5 = "AAABBB";
        System.out.println(" - N = " + alternatingCharacters(s1));
        System.out.println(" - N = " + alternatingCharacters(s2));
        System.out.println(" - N = " + alternatingCharacters(s3));
        System.out.println(" - N = " + alternatingCharacters(s4));
        System.out.println(" - N = " + alternatingCharacters(s5));
    }
}
