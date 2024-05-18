/*
 Given a singly linked list having n nodes containing english alphabets ('a'-'z'). Rearrange the linked list in such a way that all the vowels come before the consonants while maintaining the order of their arrival. 

Example 1:

Input:
n = 9
linked list: a -> b -> c -> d -> e -> f -> g -> h -> i 
Output: 
a -> e -> i -> b -> c -> d -> f -> g -> h
Explanation: 
After rearranging the input linked list according to the condition the resultant linked list will be as shown in output.
Example 2:

Input:
n = 8
linked list: a -> b -> a -> b -> d -> e -> e -> d 
Output: 
a -> a -> e -> e -> b -> b -> d -> d
Explanation: 
After rearranging the input linked list according to the condition the resultant linked list will be as shown in output.
Your Task:
Your task is to complete the function arrangeCV(), which takes head of linked list and arranges the list in such a way that all the vowels come before the consonants while maintaining the order of their arrival and returns the head of the updated linked list.

Expected Time Complexity :  O(n)
Expected Auxiliary Space :  O(1)

Constraints:
1 <= n <= 104
'a' <= elements of linked list <= 'z'

 */
//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
/*
Structure of node class is:
class Node {
    char data;
    Node next;

    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        Node head1 = null;
        Node head2 = null;
        Node p1 = null;
        Node p2 = null;
        Node curr = head;
        while(curr!=null) {
            if(curr.data=='a' || curr.data=='e' || curr.data=='i' || curr.data=='o' || curr.data=='u') {
                if(head1==null) {
                    Node ele = new Node(curr.data);
                    head1=ele;
                    p1 = ele;
                } else {
                    Node ele = new Node(curr.data);
                    p1.next=ele;
                    p1 = p1.next;
                }
            } else{
                if(head2==null) {
                    Node ele = new Node(curr.data);
                    head2=ele;
                    p2 = ele;
                } else {
                    Node ele = new Node(curr.data);
                    p2.next=ele;
                    p2 = p2.next;
                }
            }
            curr = curr.next;
        }
        if(head1 == null) {
            return head2;
        }
        p1.next = head2;
        return head1;
    }
}

//{ Driver Code Starts.

class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        next = null;
    }
}

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node head = null, tail = null;

            char head_c = sc.next().charAt(0);
            head = new Node(head_c);
            tail = head;

            while (n-- > 1) {
                tail.next = new Node(sc.next().charAt(0));
                tail = tail.next;
            }

            Solution obj = new Solution();
            // show(head);
            show(obj.arrangeCV(head));
        }
    }

    public static void po(Object o) { System.out.println(o); }

    public static void show(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends
