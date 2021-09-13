package DictHash;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author George
 */
public class TwoStrings {

    public static Set<Character> charSet(String s){
        Set<Character> set = new HashSet<>();
        for(int i=0; i< s.length(); i++)
            set.add(s.charAt(i));
        return set;
    }    
       
    public static String twoStrings(String s1, String s2) {    
        Set<Character> set1 = charSet(s1);
        Set<Character> set2 = charSet(s2);
        set1.retainAll(set2);
        return (set1.size() > 0)?"YES":"NO";
    }
    
    
    
    public static void main(String[] args){
        String s1 = "hello";
        String s2 = "world";
        System.out.println(twoStrings(s1,s2));
    }
}
