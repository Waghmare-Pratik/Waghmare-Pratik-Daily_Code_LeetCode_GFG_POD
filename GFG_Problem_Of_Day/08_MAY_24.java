/*
 * Given a Binary Tree of nodes, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.

Example 1:

Input:
       1
    /     \
   2       3
Output: 
1 2 
1 3 
Explanation: 
All possible paths:
1->2
1->3
Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 
10 20 40 
10 20 60 
10 30 
Your Task:
Your task is to complete the function Paths() which takes the root node as an argument and returns all the possible paths. (All the paths are printed in new lines by the driver's code.)

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(height of the tree)

Constraints:
1<=n<=104
 */
//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    
    class Node
    {
        int data;
        Node left;
        Node right;
    
        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    
        public static Node buildTree(String str)
        {
            // Corner Case
            if(str.length()==0 || str.charAt(0)=='N')
                return null;
    
            // Creating array of Strings from input
            // String after spliting by space
            String ip[] = str.split(" ");
    
            // Create the root of the tree
            Node root = new Node(Integer.parseInt(ip[0]));
    
            // Push the root to the queue
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
    
            // Starting from the second element
            int i = 1;
            while(queue.size()>0 && i < ip.length)
            {
    
                // Get and remove the front of the queue
                Node currNode = queue.peek();
                queue.remove();
    
                // Get the current node's value from the string
                String currVal = ip[i];
    
                // If the left child is not null
                if(!currVal.equals("N"))
                {
    
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
                if(!currVal.equals("N"))
                {
    
                    // Create the right child for the current node
                    currNode.right = new Node(Integer.parseInt(currVal));
    
                    // Push it to the queue
                    queue.add(currNode.right);
                }
                i++;
            }
    
            return root;
        }
    
        public static Node inputTree(BufferedReader br) throws IOException
        {
            return buildTree(br.readLine().trim());
        }
    
        public static void inorder(Node root)
        {
            if (root == null)
               return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    
    class IntMatrix
    {
        public static int[][] input(BufferedReader br, int n, int m) throws IOException
        {
            int[][] mat = new int[n][];
    
            for(int i = 0; i < n; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                mat[i] = new int[s.length];
                for(int j = 0; j < s.length; j++)
                    mat[i][j] = Integer.parseInt(s[j]);
            }
    
            return mat;
        }
    
        public static void print(int[][] m)
        {
            for(var a : m)
            {
                for(int e : a)
                    System.out.print(e + " ");
                System.out.println();
            }
        }
    
        public static void print(ArrayList<ArrayList<Integer>> m)
        {
            for(var a : m)
            {
                for(int e : a)
                    System.out.print(e + " ");
                System.out.println();
            }
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                
                Node root = Node.inputTree(br);
                
                Solution obj = new Solution();
                ArrayList<ArrayList<Integer>> res = obj.Paths(root);
                
                IntMatrix.print(res);
                
            }
        }
    }
    
    // } Driver Code Ends
    
    
    /*
    
    Definition for Binary Tree Node
    class Node
    {
        int data;
        Node left;
        Node right;
    
        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    */
    
    class Solution {
        static void solve(Node root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ds) {
            if(root == null)
                return;
                
            ds.add(root.data);
                
            if(root.left == null && root.right == null) {
                res.add(new ArrayList<>(ds));
                ds.remove(ds.size() - 1);
                return;
            }
            
            solve(root.left, res, ds);
            solve(root.right, res, ds);
            
            ds.remove(ds.size() - 1);
        }
    
        public static ArrayList<ArrayList<Integer>> Paths(Node root) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> ds = new ArrayList<>();
            
            solve(root, res, ds);
            return res;
        }
    } 
    