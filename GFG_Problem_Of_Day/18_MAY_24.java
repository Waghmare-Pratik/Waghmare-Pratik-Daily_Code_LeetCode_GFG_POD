/*
 * Given an integer array a[] of size n, find the highest element of the array. The array will either be strictly increasing or strictly increasing and then strictly decreasing.

Note: a[i] != a[i+1] 

Example 1:

Input:
11
1 2 3 4 5 6 5 4 3 2 1
Output: 
6
Explanation: 
Highest element of array a[] is 6.
Example 2:

Input:
5
1 2 3 4 5
Output:
5
Explanation: 
Highest element of array a[] is 5.
Your Task:
You don't need to read or print anything. Your task is to complete the function findPeakElement() which takes the array a[] as the input parameter and returns the highest element of the array.

Expected Time Complexity: O(log(n))
Expected Space Complexity: O(1)

Constraints:
2 <= n <= 106
1 <= a[i] <= 106
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