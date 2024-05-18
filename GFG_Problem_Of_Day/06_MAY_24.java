/*
 * Given a Binary Tree of n nodes, find all the nodes that don't have any siblings. You need to return a list of integers containing all the nodes that don't have a sibling in sorted order (Increasing).

Two nodes are said to be siblings if they are present at the same level, and their parents are the same.

Note: The root node can not have a sibling so it cannot be included in our answer.

Example 1:

Input :
       37
      /   
    20
    /     
  113 

Output: 
20 113
Explanation: 
Nodes 20 and 113 dont have any siblings.

Example 2:

Input :
       1
      / \
     2   3 

Output: 
-1
Explanation: 
Every node has a sibling.
Your Task:  
You don't need to read input or print anything. Complete the function noSibling() which takes the root of the tree as input parameter and returns a list of integers containing all the nodes that don't have a sibling in sorted order. If all nodes have a sibling, then the returning list should contain only one element -1.

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(Height of the tree)

Constraints:
1 ≤ n ≤ 104
 */
//{ Driver Code Starts
    import java.util.LinkedList; 
    import java.util.Queue; 
    import java.io.*;
    import java.util.*;
    
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    
    class GfG {
        
        static Node buildTree(String str){
            
            if(str.length()==0 || str.charAt(0)=='N'){
                return null;
            }
            
            String ip[] = str.split(" ");
            // Create the root of the tree
            Node root = new Node(Integer.parseInt(ip[0]));
            // Push the root to the queue
            
            Queue<Node> queue = new LinkedList<>(); 
            
            queue.add(root);
            // Starting from the second element
            
            int i = 1;
            while(queue.size()>0 && i < ip.length) {
                
                // Get and remove the front of the queue
                Node currNode = queue.peek();
                queue.remove();
                    
                // Get the current node's value from the string
                String currVal = ip[i];
                    
                // If the left child is not null
                if(!currVal.equals("N")) {
                        
                    // Create the left child for the current node
                    currNode.left = new Node(Integer.parseInt(currVal));
                    // Push it to the queue
                    queue.add(currNode.left);
                }
                    
                // For the right child
                i++;
                if(i >= ip.length)
                    break;
                    
                currVal = ip[i];
                    
                // If the right child is not null
                if(!currVal.equals("N")) {
                        
                    // Create the right child for the current node
                    currNode.right = new Node(Integer.parseInt(currVal));
                        
                    // Push it to the queue
                    queue.add(currNode.right);
                }
                i++;
            }
            
            return root;
        }
        static void printInorder(Node root)
        {
            if(root == null)
                return;
                
            printInorder(root.left);
            System.out.print(root.data+" ");
            
            printInorder(root.right);
        }
        
        public static void main (String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
    
            while(t-- > 0){
                String s = br.readLine();
                Node root = buildTree(s);
                Tree g = new Tree();
                ArrayList<Integer> ans = g.noSibling(root);
    
                for (Integer val: ans) 
                    System.out.print(val+" "); 
                System.out.println();
            }
        }
    }
    // } Driver Code Ends
    
    
    //User function Template for Java
    
    /*  A Binary Tree nodea
    class Node
    {
        int data;
        Node left, right;
    
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    */
    class Tree
    {
        void find(Node root,ArrayList<Integer> list){
            if(root == null)return;
            // if(root.left == null && root.right == null)list.add(root.data);
            if(root.left == null && root.right != null){
                list.add(root.right.data);
                find(root.right,list);
            }else if(root.left != null && root.right == null){
                list.add(root.left.data);
                find(root.left,list);
            }else{
                find(root.left,list);
                find(root.right,list);
            }
        }
        ArrayList<Integer> noSibling(Node node)
        {
            // code here
            ArrayList<Integer> ans = new ArrayList<>();
            find(node,ans);
            Collections.sort(ans);
            if(ans.size() == 0)ans.add(-1);
            return ans;
        }
    }