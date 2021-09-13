/*
Declare a 2-dimensional array, , of  empty arrays. All arrays are zero indexed.
Declare an integer, , and initialize it to .

There are  types of queries, given as an array of strings for you to parse:

Query: 1 x y
Let .
Append the integer  to .
Query: 2 x y
Let .
Assign the value  to .
Store the new value of  to an answers array.
Note:  is the bitwise XOR operation, which corresponds to the ^ operator in most languages. Learn more about it on Wikipedia.  is the modulo operator.
Finally, size(arr[idx]) is the number of elements in arr[idx]

Function Description

Complete the dynamicArray function below.

dynamicArray has the following parameters:
- int n: the number of empty arrays to initialize in 
- string queries[q]: query strings that contain 3 space-separated integers

Returns

int[]: the results of each type 2 query in the order they are presented
Input Format

The first line contains two space-separated integers, , the size of  to create, and , the number of queries, respectively.
Each of the  subsequent lines contains a query string, .

Constraints

It is guaranteed that query type  will never query an empty array or index.
Sample Input

2 5
1 0 5
1 1 7
1 0 3
2 1 0
2 1 1
Sample Output

7
3
Explanation

Initial Values:


 = [ ]
 = [ ]

Query 0: Append  to .

 = [5]
 = [ ]

Query 1: Append  to .
 = [5]
 = [7]

Query 2: Append  to .

 = [5, 3]
 = [7]

Query 3: Assign the value at index  of  to , print .

 = [5, 3]
 = [7]

7
Query 4: Assign the value at index  of  to , print .

 = [5, 3]
 = [7]

3
 */
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author George
 */
public class DynamicArray {

    public static List<List<Integer>> emptyList(int n) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            list.add(new ArrayList<Integer>());
        }
        return list;
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> commands = emptyList(n);
        List<Integer> results = new ArrayList<>();

        int lastAnswer = 0;
        for (List<Integer> query : queries) {

            int index = (query.get(1) ^ lastAnswer) % n;

            if (query.get(0) == 1) {                
                commands.get(index).add(query.get(2));
            } else {
                List<Integer> subList = commands.get(index);
                lastAnswer = subList.get(query.get(2) % subList.size());
                results.add(lastAnswer);
            }
        }
        return results;
    }

    public static void showList(List<List<Integer>> arr) {
        arr.stream().map(list -> {
            list.forEach(i -> {
                System.out.print(i + " ");
            });
            return list;
        }).forEachOrdered(_item -> {
            System.out.println();
        });
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 0, 5));
        arr.add(Arrays.asList(1, 1, 7));
        arr.add(Arrays.asList(1, 0, 3));
        arr.add(Arrays.asList(2, 1, 0));
        arr.add(Arrays.asList(2, 1, 1));
        showList(arr);
        System.out.println("Result = " + dynamicArray(2, arr));
    }
}
