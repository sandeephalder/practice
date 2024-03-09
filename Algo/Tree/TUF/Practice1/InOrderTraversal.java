
import java.util.Stack;

public class InOrderTraversal {
    int[] arr = {1,2,7,3,4,5,6};
    public static void main(String[] args) {
        new InOrderTraversal();
    }

    InOrderTraversal(){
        
        BST bst = new BST();
        //for(int i : arr) 
        bst.root= bst.buildTree(bst.root);

        inOrderTraversal(bst.root);


    }

    public void inOrderTraversal(TreeNode node){
        if(node == null)
        return;

        inOrderTraversal(node.lNode);
        System.out.print(" ===> "+node.getData());
        inOrderTraversal(node.rNode);
    }

    public void inOrderTraversalIterative(TreeNode node){
        if(node == null)
        return;
        Stack<TreeNode> stack = new Stack<>();
        
        while(true){
           if(node !=  null){
            stack.push(node);
            node= node.lNode;
           }
           else{
             if(stack.isEmpty()) break;
             node = stack.pop();
             System.out.print(" ==> "+node);
             node= node.rNode;
           }
            
        }
        
    }
}
