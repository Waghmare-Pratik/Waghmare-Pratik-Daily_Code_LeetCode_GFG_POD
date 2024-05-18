/*
 * //{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
   
    int preIndex;
    HashMap<Integer,Integer> h=new HashMap<>();
    Node buildTree(int in[], int post[], int n) {
      
        for(int i=0;i<in.length;i++){
            h.put(in[i],i);
        }
        preIndex=n-1;
        return cTree(in,post,0,n-1);
    }
    public Node cTree(int in[],int pre[],int is,int ie){
        if(is>ie)return null;
        Node root=new Node(pre[preIndex--]);
        
        int inIndex=is;
        inIndex= h.get(root.data);
        root.right=cTree(in, pre, inIndex+1, ie);
        root.left=cTree(in, pre, is, inIndex-1);
       
        return root;
    }
    
    
}

 */