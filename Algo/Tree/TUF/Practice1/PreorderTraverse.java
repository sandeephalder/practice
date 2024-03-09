import java.util.Stack;

public class PreorderTraverse {
    int[] arr = {1,2,7,3,4,5,6};
    public static void main(String[] args) {
        new PreorderTraverse();
    }

    PreorderTraverse(){
        
        BST bst = new BST();
       
        bst.root= bst.buildTree(bst.root);

        preOrderTraversalIterative(bst.root);


    }

    public void preOrderTraversal(TreeNode node){
        if(node == null)
        return;

        System.out.print(" ===> "+node.getData());
        preOrderTraversal(node.lNode);
        preOrderTraversal(node.rNode);
    }

    public void preOrderTraversalIterative(TreeNode node){
        if(node == null)
        return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(" ==> "+temp.getData());
            if(temp.rNode != null) stack.push(temp.rNode);
            if(temp.lNode != null) stack.push(temp.lNode);
        }
        
    }
}
