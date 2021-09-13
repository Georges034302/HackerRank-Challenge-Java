/*
 Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an array. The Player class is provided in the editor below. It has two fields:

: a string.
: an integer.
Given an array of  Player objects, write a comparator that sorts them in order of decreasing score. If  or more players have the same score, sort those players alphabetically ascending by name. To do this, you must create a Checker class that implements the Comparator interface, then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method. In short, when sorting in ascending order, a comparator function returns  if ,  if , and  if .

Declare a Checker class that implements the comparator method as described. It should sort first descending by score, then ascending by name. The code stub reads the input, creates a list of Player objects, uses your method to sort the data, and prints it out properly.

Example
 

Sort the list as . Sort first descending by score, then ascending by name.

Input Format

The first line contains an integer, , the number of players.
Each of the next  lines contains a player's  and , a string and an integer.

Constraints

Two or more players can have the same name.
Player names consist of lowercase English alphabetic letters.
Output Format

You are not responsible for printing any output to stdout. Locked stub code in Solution will instantiate a Checker object, use it to sort the Player array, and print each sorted element.

Sample Input

5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150
Sample Output

aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
Explanation

The players are first sorted descending by score, then ascending by name.
 */
package sorting;

import java.text.Collator;
import java.util.Locale;

/**
 *
 * @author George
 */
public class Checker implements Comparator<Player> {

    /**
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Player a, Player b) {   
        Collator collator = Collator.getInstance(Locale.US);
        return a.score < b.score ? 1 : a.score > b.score ? -1 : collator.compare(a.name, b.name);
    }  
    
    public static void main(String[] args){
        Player p1 = new Player("amy",100);
        Player p2 = new Player("david",100);
        Player p3 = new Player("heraldo",100);
        Player p4 = new Player("aakansha",75);
        Player p5 = new Player("aleksa",50);
        
        System.out.println(new Checker().compare(p2,p3));
    }
}
