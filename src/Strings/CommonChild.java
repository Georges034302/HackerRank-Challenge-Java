/*
 A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string. Letters cannot be rearranged. Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both?

Example



These strings have two children with maximum length 3, ABC and ABD. They can be formed by eliminating either the D or C from both strings. Return .

Function Description

Complete the commonChild function in the editor below.

commonChild has the following parameter(s):

string s1: a string
string s2: another string
Returns

int: the length of the longest string which is a common child of the input strings
Input Format

There are two lines, each with a string,  and .

Constraints

 where  means "the length of "
All characters are upper case in the range ascii[A-Z].
Sample Input

HARRY
SALLY
Sample Output

 2
Explanation

The longest string that can be formed by deleting zero or more characters from  and  is , whose length is 2.

Sample Input 1

AA
BB
Sample Output 1

0
Explanation 1

 and  have no characters in common and hence the output is 0.

Sample Input 2

SHINCHAN
NOHARAAA
Sample Output 2

3
Explanation 2

The longest string that can be formed between  and  while maintaining the order is .

Sample Input 3

ABCDEF
FBDAMN
Sample Output 3

2
Explanation 3
 is the longest child of the given strings.

Language
Java 8

More
123456789101112131415161718192021222324252627282930313233343536
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'commonChild' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1

Line: 14 Col: 1

Submit Code

Run Code

Upload Code as File

Test against custom input

 */
package Strings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class CommonChild {

    public static List<Character> set(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    public static int score(List<Character> set1, List<Character> set2) {
        int[][] score = new int[set1.size() + 1][set2.size() + 1];
        for (int r = 1; r <= set1.size(); r++) {
            for (int c = 1; c <= set2.size(); c++) {
                if (set1.get(r - 1).equals(set2.get(c - 1))) {
                    score[r][c] = score[r - 1][c - 1] + 1;
                } else {
                    score[r][c] = Math.max(score[r - 1][c], score[r][c - 1]);
                }
            }
        }
        return score[set1.size()][set2.size()];
    }

    public static int commonChild(String s1, String s2) {
        List<Character> set1 = set(s1);
        List<Character> set2 = set(s2);
        List<Character> matches = new LinkedList<>(set1);
        matches.retainAll(set2);
        set1.stream().filter(matches::contains).collect(Collectors.toList());
        set2.stream().filter(matches::contains).collect(Collectors.toList());

        System.out.format("SET1: %-25s", set1);
        System.out.format("SET2: %-25s", set2);
        System.out.format("Matches: %-20s", matches);

        return score(set1,set2);
    }

    public static void main(String[] args) {
        String s1 = "HARRY";
        String s2 = "SALLY";
        String s3 = "AA";
        String s4 = "BB";
        String s5 = "ABCDEF";
        String s6 = "FBDAMN";
        System.out.println(" s1 - Result = " + commonChild(s1, s2));
        System.out.println(" s1 - Result = " + commonChild(s3, s4));
        System.out.println(" s1 - Result = " + commonChild(s5, s6));

    }
}
