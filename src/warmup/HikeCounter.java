package warmup;


/** 
An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly  steps, for every step it was noted if it was an uphill, , or a downhill,  step. Hikes always start and end at sea level, and each step up or down represents a  unit change in altitude. We define the following terms:
A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.

Function Description;
Complete the countingValleys function in the editor below.

countingValleys has the following parameter(s):
int steps: the number of steps on the hike
string path: a string describing the path
Returns

int: the number of valleys traversed
Input Format

The first line contains an integer , the number of steps in the hike.
The second line contains a single string , of  characters that describe the path.

Sample Input;

8
UDDDUDUU
Sample Output

1
Explanation

If we represent _ as sea level, a step up as /, and a step down as \, the hike can be drawn as:

_/\      _
   \    /
    \/\/
The hiker enters and leaves one valley.

**/

public class HikeCounter {
    
    public static int countingValleys(int steps, String path) {
        int valley = 0;
        int sea = 0;
        int level = 0;
        int[] track = new int[steps];
        
        for(int i = 0; i < path.length(); i++){              
            if(path.charAt(i) == 'D'){
                level--; 
                track[i] = level;
            }            
            if(path.charAt(i) == 'U'){
                level++;  
                track[i] = level;
            }           
        }    
        int i = 0;
        while(i < track.length-1){
            if(track[i] < 0 && track[i+1] ==0)
                valley++; 
            ++i;
        }
        return valley;
    }
    
    public static void main(String[] args) {
        String path ="DDUUDDUDUUUD";
        int steps = 12;
        System.out.println("Valley = " + countingValleys(steps, path));
    }
}
