package warmup;


/**
 * Return the frequency of 'a' in a repeated string 's' n-times. For Example: s
 * = "abcac" and n=10 ---> frequency(a) = 4 The string is repeated as:
 * "abcacabcac"
 */
public class RepeatedString {

    public static long repeatedString(String s, long n) {
        
        long count;
        if(s.length() == 0)
            return 0L;
        else if( s.length() == n)
            return s.charAt(0)=='a'? 1:0;
        else if( s.length() == 1)
            return s.charAt(0)=='a'? n:0;
        else {            
            long steps = n / s.length();
            long sub = n%s.length();
            String remain = s.substring(0, (int)sub);
            long subcount = remain.chars().filter(c -> c == 'a').count();
            count = s.chars().filter(c -> c == 'a').count()*steps + subcount;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("abc", 1000000000000L));
    }
}
