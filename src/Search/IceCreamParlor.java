/*
Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool their money to buy ice cream. On any given day, the parlor offers a line of flavors. Each flavor has a cost associated with it.

Given the value of  and the  of each flavor for  trips to the Ice Cream Parlor, help Sunny and Johnny choose two distinct flavors such that they spend their entire pool of money during each visit. ID numbers are the 1- based index number associated with a . For each trip to the parlor, print the ID numbers for the two types of ice cream that Sunny and Johnny purchase as two space-separated integers on a new line. You must print the smaller ID first and the larger ID second.

Example



They would purchase flavor ID's  and  for a cost of . Use  based indexing for your response.

Note:

Two ice creams having unique IDs  and  may have the same cost (i.e., ).
There will always be a unique solution.
Function Description

Complete the function whatFlavors in the editor below.

whatFlavors has the following parameter(s):

int cost[n] the prices for each flavor
int money: the amount of money they have to spend
Prints

int int: the indices of the two flavors they will purchase as two space-separated integers on a line
Input Format

The first line contains an integer, , the number of trips to the ice cream parlor.

Each of the next  sets of  lines is as follows:

The first line contains .
The second line contains an integer, , the size of the array .
The third line contains  space-separated integers denoting the .
Constraints

Sample Input

STDIN       Function
-----       --------
2           t = 2
4           money = 4
5           cost[] size n = 5
1 4 5 3 2   cost = [1, 4, 5, 3, 2]
4           money = 4
4           cost[] size n = 4
2 2 4 3     cost = [2, 2, 4, 3]
Sample Output

1 4
1 2
Explanation

Sunny and Johnny make the following two trips to the parlor:

The first time, they pool together  dollars. There are five flavors available that day and flavors  and  have a total cost of .
The second time, they pool together  dollars. There are four flavors available that day and flavors  and  have a total cost of .
 */
package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 *
 * @author George
 */
public class IceCreamParlor {

    public static Set<Integer> getIDs(List<Integer> cost, int money) {
        Set<Integer> ids = new LinkedHashSet();
        IntStream.range(0, cost.size()-1)
                .forEach(i->{
                    IntStream.range(1, cost.size()).forEach(j->{
                        if(cost.get(i)+cost.get(j) == money){
                            ids.add(i+1);
                            ids.add(j+1);
                        }
                    });
                });
        return ids;
    }

    public static void buyIceCream(List<Integer> cost, int money) {
        HashMap<Integer, Integer> map = new HashMap(); 
        for (int i = 0; i < cost.size(); i++) {
            int icecreamID = i + 1;
            int price       = cost.get(i);            
            
            int otherCost  = money - price;
            if (map.containsKey(otherCost)) {
                System.out.println(map.get(otherCost) + " " + icecreamID);
            }            
            map.putIfAbsent(price, icecreamID);
        }
    }
    
    public static void whatFlavors(List<Integer> cost, int money) {
        /*
        Set<Integer> ids = getIDs(cost, money);
        List<Integer> sorted = new ArrayList<Integer>(ids) ;
        String output = "";
        output = sorted.stream().map(id -> id + " ").reduce(output, String::concat);
        System.out.println(output.trim());
        */
        buyIceCream(cost, money);
    }

    public static void main(String args[]) {
        List<Integer> cost1 = new ArrayList(Arrays.asList(1, 4, 5, 3, 2));
        int money1 = 4;
        whatFlavors(cost1, money1);

        List<Integer> cost2 = new ArrayList(Arrays.asList(2, 2, 4, 3));
        int money2 = 4;
        whatFlavors(cost2, money2);
    }
}
