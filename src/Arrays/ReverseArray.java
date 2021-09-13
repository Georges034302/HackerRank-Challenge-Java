/*
 An array is a type of data structure that stores elements of the same type in a contiguous block of memory. In an array, , of size , each memory location has some unique index,  (where ), that can be referenced as  or .

Reverse an array of integers.

Note: If you've already solved our C++ domain's Arrays Introduction challenge, you may want to skip this.

Example

Return .

Function Description

Complete the function reverseArray in the editor below.

reverseArray has the following parameter(s):

int A[n]: the array to reverse
Returns

int[n]: the reversed array
Input Format

The first line contains an integer, , the number of integers in .
The second line contains  space-separated integers that make up .

Constraints

Sample Input 1

CopyDownload
Array: arr
1
4
3
2

 
4
1 4 3 2
Sample Output 1

2 3 4 1
 */
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class ReverseArray {
    
    public static List<Integer> reverseArray(List<Integer> a) {
        List<Integer> reverse = new ArrayList<>();
        reverse = a.stream().sorted((x, y) -> -1).collect(Collectors.toList());
        return reverse;
    }
    
    
    public static void main(String[] args) {
        List<Integer> temp = new ArrayList(Arrays.asList(1, 2, 5, 3, 4));
        System.out.format("Array   : %-30s \n", temp);
        System.out.format("Reversed: %-30s \n", reverseArray(temp));
    }
    
}
