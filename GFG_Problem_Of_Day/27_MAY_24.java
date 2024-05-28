/*
 * Given an integer array a[] of size n, find the length of the longest subsequence such that the absolute difference between adjacent elements is 1.

Example 1:

Input:
n = 7
a[] = {10, 9, 4, 5, 4, 8, 6}
Output: 
3
Explaination: 
The three possible subsequences of length 3 are {10, 9, 8}, {4, 5, 4}, and {4, 5, 6}, where adjacent elements have a absolute difference of 1. No valid subsequence of greater length could be formed.
Example 2:

Input: 
n = 5
a[] = {1, 2, 3, 4, 5}
Output: 
5
Explaination: 
All the elements can be included in the valid subsequence.
Your Task:
You do not need to read input. Your task is to complete the function longestSubseq() which takes integer n and array a[] as input parameters and returns the length of the longest subsequence where the absolute difference of adjacent elements is 1.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 103
1 ≤ a[i] ≤ 103


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
    
                int[] a = IntArray.input(br, n);
    
                Solution obj = new Solution();
                int res = obj.longestSubseq(n, a);
    
                System.out.println(res);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    
    class Solution {
        public static int longestSubseq(int n, int[] a) {
            // code here
            int dp[]= new int[n];
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if(Math.abs(a[i]-a[j])==1){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
            }
            int ans=0;
            for(int u=0;u<n;u++){
                if(dp[u]>ans)ans=dp[u];
            }
            return ans+1;
        }
    }
