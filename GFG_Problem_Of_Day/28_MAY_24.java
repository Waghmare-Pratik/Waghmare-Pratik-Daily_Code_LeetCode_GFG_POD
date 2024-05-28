/*
 Given an array cost[] of positive integers of size n and an integer w, where cost[i] represents the cost of an i kg packet of oranges, the task is to find the minimum cost to buy exactly w kg of oranges. The cost array has a 1-based indexing. If buying exactly w kg of oranges is impossible, then return -1.
Note:
1. cost[i] = -1 means that i kg packet of orange is unavailable.
2. It may be assumed that there is an infinite supply of all available packet types.

Example 1:

Input: 
n = 5
cost[] = {20, 10, 4, 50, 100} 
w = 5
Output: 
14
Explanation: 
Purchase the 2kg packet for 10 coins and the 3kg packet for 4 coins to buy 5kg of oranges for 14 coins.
Example 2:

Input: 
n = 5
cost[] = {-1, -1, 4, 3, -1}
w = 5
Output: 
-1
Explanation: 
It is not possible to buy 5 kgs of oranges.
Your Task:  
You don't need to read input or print anything. Complete the function minimumCost() which takes integers n and w, and integer array cost[] as input parameters and returns the minimum cost to buy exactly w kg of oranges, If buying exactly w kg of oranges is impossible, then return -1.

Expected Time Complexity: O(n*w)
Expected Auxiliary Space: O(n*w)

Constraints:
1 ≤ n, w ≤ 2*102
1 ≤ cost[i] ≤ 105
cost[i] ≠ 0
 */

 // Solution
 
//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class IntArray {
        public static int[] input(BufferedReader br, int n) throws IOException {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
    
            return a;
        }
    
        public static void print(int[] a) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    
        public static void print(ArrayList<Integer> a) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
    
                int n;
                n = Integer.parseInt(br.readLine());
    
                int w;
                w = Integer.parseInt(br.readLine());
    
                int[] cost = IntArray.input(br, n);
    
                Solution obj = new Solution();
                int res = obj.minimumCost(n, w, cost);
    
                System.out.println(res);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    
    class Solution {
        public static int minimumCost(int n, int w, int[] cost) {
            int dp[] = new int[w + 1];
            for(int i = 0; i <= w; i++)
                dp[i] = Integer.MAX_VALUE;
            
            dp[0] = 0;
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j <= w; j++)
                    dp[j] = Math.min(dp[j], cost[i] + dp[j - i - 1]); 
        
            return dp[w];
        }
    }
    