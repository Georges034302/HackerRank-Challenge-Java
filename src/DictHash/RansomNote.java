package DictHash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author George
 */
public class RansomNote {

    static boolean match(String word, String note) {
        return word.equals(note);
    }

    static boolean match(List<String> magazine, String note) {
        return magazine.stream().anyMatch(word -> (match(word, note)));
    }

    static boolean match(List<String> magazine, List<String> note) {
        List<String> words = new ArrayList(magazine);
        int count = 0;
        for (String item : note) {
            if (words.contains(item)) {
                words.remove(words.indexOf(item));
                count++;
            } else {
                break;
            }
        }
        return (count == note.size());
    }

    public static void checkMagazine(List<String> magazine, List<String> note) {
        HashMap<String, Integer> usableWords = makeMap(magazine);
        for (int i = 0; i < note.size(); i++) {
            if (usableWords.containsKey(note.get(i)) && usableWords.get(note.get(i)) > 0) {
                usableWords.merge(note.get(i), -1, Integer::sum); 
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
    
    private static HashMap<String, Integer> makeMap(List<String> words) {
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < words.size(); i++) {
            map.merge(words.get(i), 1, Integer::sum);
        }
        return map;
    }
/*
    public static void checkMagazine(List<String> magazine, List<String> note) {
        List<String> words = new ArrayList(magazine);
        int count = 0;
        for (String item : note) {
            if (words.contains(item)) {
                words.remove(words.indexOf(item));
                count++;
            } else {
                break;
            }
        }
        if ((count == note.size())) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
*/
    public static void main(String[] args) {
        //List<String> magazine = Arrays.asList("two","times","three","is","not","four");
        //List<String> note = Arrays.asList("two","times","two","is","four");
        List<String> magazine = Arrays.asList("give", "me", "one", "grand", "today", "tonight");
        List<String> note = Arrays.asList("give", "one", "grand", "today");

        checkMagazine(magazine, note);
    }
}
