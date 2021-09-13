/*
Given a string, , we define some operations on the string as follows:

a.  denotes the string obtained by reversing string . Example: 


b.  denotes any string that's a permutation of string . Example: 


c.  denotes any string that's obtained by interspersing the two strings  & , maintaining the order of characters in both. For example,  & , one possible result of  could be , another could be , another could be  and so on.

Given a string  such that  for some string , find the lexicographically smallest .

For example, . We can split it into two strings of . The reverse is  and we need to find a string to shuffle in to get . The middle two characters match our reverse string, leaving the  and  at the ends. Our shuffle string needs to be . Lexicographically , so our answer is .

Function Description

Complete the reverseShuffleMerge function in the editor below. It must return the lexicographically smallest string fitting the criteria.

reverseShuffleMerge has the following parameter(s):

s: a string
Input Format

A single line containing the string .

Constraints

 contains only lower-case English letters, ascii[a-z]
Output Format

Find and return the string which is the lexicographically smallest valid .

Sample Input 0

eggegg
Sample Output 0

egg
Explanation 0

Split "eggegg" into strings of like character counts: "egg", "egg"
reverse("egg") = "gge"
shuffle("egg") can be "egg"
"eggegg" belongs to the merge of ("gge", "egg")

The merge is: gge.

'egg' < 'gge'

Sample Input 1

abcdefgabcdefg
Sample Output 1

agfedcb
Explanation 1

Split the string into two strings with like characters:  and .
Reverse  = 
Shuffle  can be 
Merge to bcdefga

Sample Input 2

aeiouuoiea
Sample Output 2

aeiou
Explanation 2

Split the string into groups of like characters: 
Reverse  = 
These merge to uoiea

Language
Java 8

More
123456789101112131415161718192021222324252627282930313233343536

    public static String reverseShuffleMerge(String s) {
    // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

Line: 22 Col: 1

Submit Code

Run Code

Upload Code as File

Test against custom input

 */
package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author George
 */
public class ReverseShuffleMerge {

    public static String reversed(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    public static String shuffle(String s){
        Collections.shuffle(Arrays.asList(s.split("")));
        return s;
    }
    
    public static String merge(String s){  
        String left    = s.substring(0,s.length()/2);
        String right   = s.substring(s.length()/2,s.length());
        String reverse = reversed(left);
        String shuffle = shuffle(left);
        String merge   = left+right;
        String remain  = merge.replace(reverse, "");
        return remain.equals(shuffle) && remain.compareTo(reverse) < 0 ? remain : null;
    }    
    
    
    static String reverseShuffleMerge(String s) {
        int[] addCnt  = new int[26];
        int[] skipCnt = new int[26];
        
        Stack<Character> st = new Stack<>();
        String rslt   = "";

        char[] ss = s.toCharArray();

        for(int i=0; i<ss.length; i++){
            addCnt[ss[i] - 'a']++;
        }

        for(int i=0; i<addCnt.length; i++){
            addCnt[i] /= 2;
        }

        skipCnt = addCnt.clone();

        for(int i=ss.length-1; i>=0; i--){
            while(!st.empty() && st.peek() > ss[i] && addCnt[ss[i] - 'a'] > 0 && skipCnt[st.peek() - 'a'] > 0){
                char c = st.pop();
                addCnt[c - 'a']++;
                skipCnt[c - 'a']--;
            }

            if(addCnt[ss[i] - 'a'] > 0){
                st.push(ss[i]);
                addCnt[ss[i] - 'a']--;
            }else{
                skipCnt[ss[i] - 'a']--;
            }
        }

        while(!st.empty()){
            rslt = st.pop() + rslt;
        }
        return rslt;
    }
    
    public static void main(String[] args) {
        String s1 = "eggegg";
        String s2 = "abcdefgabcdefg";
        String s3 = "aeiouuoiea";

        System.out.format("s1: %-20s - RSM = %-10s\n",s1,reverseShuffleMerge(s1));
        System.out.format("s2: %-20s - RSM = %-10s\n",s2,reverseShuffleMerge(s2));
        System.out.format("s3: %-20s - RSM = %-10s\n",s3,reverseShuffleMerge(s3));
    }
}
