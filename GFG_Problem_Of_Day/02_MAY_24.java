/* 
 Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions

serialize() : stores the tree into an array a and returns the array.
deSerialize() : deserializes the array to the tree and returns the root of the tree.
Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).

Example 1:

Input:
      1
    /   \
   2     3
Output: 
2 1 3
Example 2:

Input:
         10
       /    \
      20    30
    /   \
   40  60
Output: 
40 20 60 10 30
Your Task:
The task is to complete two functions serialize which takes the root node of the tree as input and stores the tree into an array and deSerialize which deserializes the array to the original tree and returns the root of it.

Expected Time Complexity: O(Number of nodes).
Expected Auxiliary Space: O(Number of nodes).

Constraints:
1 <= Number of nodes <= 104
1 <= Data of a node <= 109
*/

//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    import java.util.LinkedList;
    import java.util.Queue;
    
    class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    class GfG {
    
        static Node buildTree(String str) {
    
            if (str.length() == 0 || str.charAt(0) == 'N') {
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
            while (queue.size() > 0 && i < ip.length) {
    
                // Get and remove the front of the queue
                Node currNode = queue.peek();
                queue.remove();
    
                // Get the current node's value from the string
                String currVal = ip[i];
    
                // If the left child is not null
                if (!currVal.equals("N")) {
    
                    // Create the left child for the current node
                    currNode.left = new Node(Integer.parseInt(currVal));
                    // Push it to the queue
                    queue.add(currNode.left);
                }
    
                // For the right child
                i++;
                if (i >= ip.length) break;
    
                currVal = ip[i];
    
                // If the right child is not null
                if (!currVal.equals("N")) {
    
                    // Create the right child for the current node
                    currNode.right = new Node(Integer.parseInt(currVal));
    
                    // Push it to the queue
                    queue.add(currNode.right);
                }
                i++;
            }
    
            return root;
        }
    
        static void deletetree(Node root) {
            if (root == null) return;
            deletetree(root.left);
            deletetree(root.right);
            root.left = null;
            root.right = null;
        }
    
        static void printInorder(Node root) {
            if (root == null) return;
    
            printInorder(root.left);
            System.out.print(root.data + " ");
    
            printInorder(root.right);
        }
    
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String s = br.readLine();
                Node root = buildTree(s);
    
                Tree tr = new Tree();
                ArrayList<Integer> A = tr.serialize(root);
                deletetree(root);
                root = null;
    
                Node getRoot = tr.deSerialize(A);
                printInorder(getRoot);
                System.out.println();
            }
        }
    }
    // } Driver Code Ends
    
    
    /*Complete the given function
    Node is as follows:
    class Tree{
        int data;
        Tree left,right;
        Tree(int d){
            data=d;
            left=right=null;
        }
    }*/
    
    class Tree {
        // Function to serialize a tree and return a list containing nodes of tree.
        public ArrayList<Integer> serialize(Node root) {
            // code here
            if(root==null)
                return new ArrayList<Integer>();
                
            ArrayList<Integer> serializeLeft=serialize(root.left);
            ArrayList<Integer> serializeRight=serialize(root.right);
            
            serializeLeft.add(root.data);
            serializeLeft.addAll(serializeRight);
            return serializeLeft;
        }
    
        // Function to deserialize a list and construct the tree.
        public Node deSerialize(ArrayList<Integer> arr) {
            // code here
            if(arr.size()==0)
            {
                return null;
            }
            int mid=arr.size()/2;
            Node newNode=new Node(arr.get(mid));
            ArrayList<Integer> leftArr=new ArrayList<>(arr.subList(0, mid));
            Node leftNode=deSerialize(leftArr);
            ArrayList<Integer> rightArr=new ArrayList<>(arr.subList(mid+1, arr.size()));
            Node rightNode=deSerialize(rightArr);
            newNode.left=leftNode;
            newNode.right=rightNode;
            return newNode;
        }
    };
