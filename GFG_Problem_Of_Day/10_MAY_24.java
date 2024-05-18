/*
 * 
 * 
 * Given an array of integers arr, the length of the array n, and an integer k, find all the unique combinations in arr where the sum of the combination is equal to k. Each number can only be used once in a combination.
Return the combinations in the lexicographically sorted order, where each combination is in non-decreasing order.

Example 1:

Input: 
n = 5, k = 7
arr[] = { 1, 2, 3, 3, 5 }
Output:
{ { 1, 3, 3 }, { 2, 5 } }
Explanation:
1 + 3 + 3 = 7
2 + 5 = 7
Example 2:

Input:
n = 6, k = 30
arr[] = { 5, 10, 15, 20, 25, 30 }
Output:
{ { 5, 10, 15 }, { 5, 25 }, { 10, 20 }, { 30 } }
Explanation:
5 + 10 + 15 = 30
5 + 25 = 30
10 + 20 = 30
Your Task:
You don't need to read input or print anything. Your task is to complete the function CombinationSum2() which takes arr[],n, and k as input parameters and returns all the unique combinations.
 

Constraints:
1 <= n <= 100
1 <= arr[i] <= 50
1 <= k <= 30

let p = number of elements, at maximum, can sum up to the given value k.

Expected Time Complexity: O(2min(n,p))
Expected Auxiliary Space: O(n)
 */
//{ Driver Code Starts
    import java.io.*;
    import java.lang.*;
    import java.util.*;
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while (T-- > 0) {
                String s = br.readLine().trim();
                int n = Integer.parseInt(s);
                String S = br.readLine();
                String[] s1 = S.split(" ");
                List<Integer> a = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    a.add(Integer.parseInt(s1[i]));
                }
                Solution ob = new Solution();
                int ans = ob.findPeakElement(a);
                System.out.println(ans);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    class Solution {
        public int findPeakElement(List<Integer> a) {
            // Initialize two pointers: 'left' starting at the beginning of the array
            // and 'right' starting at the end of the array.
            int left = 0;
            int right = a.size() - 1;
            
            // Perform a binary search.
            while (left < right) {
                // Find the middle index to divide the array into two halves.
                int mid = left + (right - left) / 2;
                
                // Compare the middle element with its next element to decide which half to keep.
                // If the middle element is greater than the next element, the peak is in the left half (including mid).
                if (a.get(mid) > a.get(mid + 1)) {
                    right = mid; // Move the 'right' pointer to 'mid'.
                } else {
                    // If the middle element is less than the next element, the peak is in the right half.
                    left = mid + 1; // Move the 'left' pointer to 'mid + 1'.
                }
            }
            
            // When the pointers converge, 'left' will be pointing to the peak element.
            return a.get(left);
        }
    }