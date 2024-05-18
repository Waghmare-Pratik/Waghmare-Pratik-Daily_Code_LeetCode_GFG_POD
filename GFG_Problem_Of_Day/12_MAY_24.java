/*
 * Given an infinite number line. You start at 0 and can go either to the left or to the right. The condition is that in the ith move, you must take i steps. Given a destination d, find the minimum number of steps required to reach that destination.

Example 1:

Input: d = 2
Output: 3
Explaination: The steps taken are +1, -2 and +3.
Example 2:

Input: d = 10
Output: 4
Explaination: The steps taken are +1, +2, +3 and +4.
Your Task:
You do not need to read input or print anything. Your task is to complete the function minSteps() which takes the value d as input parameter and returns the minimum number of steps required to reach the destination d from 0.

Expected Time Complexity: O(sqrt(d))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ d ≤ 10000
 */
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int d = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minSteps(d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minSteps(int d) {
        int steps = 0;
        int position = 0;

        while (position < d || (position - d) % 2 != 0) {
            steps++;
            position += steps;
        }

        return steps;
    }
}