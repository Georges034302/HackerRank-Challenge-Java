/*
Lena is preparing for an important coding competition that is preceded by a number of sequential preliminary contests. Initially, her luck balance is 0. She believes in "saving luck", and wants to check her theory. Each contest is described by two integers,  and :

 is the amount of luck associated with a contest. If Lena wins the contest, her luck balance will decrease by ; if she loses it, her luck balance will increase by .
 denotes the contest's importance rating. It's equal to  if the contest is important, and it's equal to  if it's unimportant.
If Lena loses no more than  important contests, what is the maximum amount of luck she can have after competing in all the preliminary contests? This value may be negative.

Example



Contest		L[i]	T[i]
1		5	1
2		1	1
3		4	0
If Lena loses all of the contests, her will be . Since she is allowed to lose  important contests, and there are only  important contests, she can lose all three contests to maximize her luck at .

If , she has to win at least  of the  important contests. She would choose to win the lowest value important contest worth . Her final luck will be .

Function Description

Complete the luckBalance function in the editor below.

luckBalance has the following parameter(s):

int k: the number of important contests Lena can lose
int contests[n][2]: a 2D array of integers where each  contains two integers that represent the luck balance and importance of the  contest
Returns

int: the maximum luck balance achievable
Input Format

The first line contains two space-separated integers  and , the number of preliminary contests and the maximum number of important contests Lena can lose.
Each of the next  lines contains two space-separated integers,  and , the contest's luck balance and its importance rating.

Constraints

Sample Input

STDIN       Function
-----       --------
6 3         n = 6, k = 3
5 1         contests = [[5, 1], [2, 1], [1, 1], [8, 1], [10, 0], [5, 0]]
2 1
1 1
8 1
10 0
5 0
Sample Output

29
Explanation

There are  contests. Of these contests,  are important and she cannot lose more than  of them. Lena maximizes her luck if she wins the  important contest (where ) and loses all of the other five contests for a total luck balance of .
 */
package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class LuckBalance {
    public static int luckBalance(int k, List<List<Integer>> contests) {
        int[][] array = contests.stream()
                .map(list -> list.stream()
                .mapToInt(i -> i)
                .toArray())
                .toArray(int[][]::new);
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int max = 0;
    	
        for(int i=0; i<array.length; i++){
            if(array[i][1] == 1){
            	q.add(array[i][0]);
            }else {
            	max += array[i][0];
            }
        }
        
        int i=0;
        while(!q.isEmpty()) {
        	if(i < k) {
        		max += q.poll();	
        	}else {
        		max -= q.poll();
        	}
        	i++;
        }
        return max;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 1, 0, 0, 0, 0));
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 0, 2, 4, 4, 0));
        arr.add(Arrays.asList(0, 0, 0, 2, 0, 0));
        arr.add(Arrays.asList(0, 0, 1, 2, 4, 0));

        System.out.format("Max luck:  %d \n", luckBalance(3,arr));

    }
}
