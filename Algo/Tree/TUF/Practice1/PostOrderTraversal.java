import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {
        new PostOrderTraversal();
    }

    PostOrderTraversal(){
        
        BST bst = new BST();
       
        bst.root= bst.buildTree(bst.root);

        postOrderTraversalIterativeTwoStack(bst.root);


    }

    public void postOrderTraversal(TreeNode node){
        if(node == null)
        return;

        
        postOrderTraversal(node.lNode);
        postOrderTraversal(node.rNode);
        System.out.print(" ===> "+node.getData());
    }

    public void postOrderTraversalIterativeTwoStack(TreeNode node){
        if(node == null)
        return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(node);
        while(!stack1.isEmpty()){
            TreeNode current = stack1.pop();
            stack2.push(current);
            if(current.lNode !=null) stack1.push(current.lNode);
            if(current.rNode !=null) stack1.push(current.rNode);
        }

        while(!stack2.isEmpty()){
        System.out.print(" ==> "+stack2.pop());
        }
    }

    public void postOrderTraversalIterativeOneStack(TreeNode node){
        TreeNode curr,temp;
        if(node == null)
        return;
        Stack<TreeNode> stack = new Stack<>();
        curr = node;
        while(!stack.isEmpty() || curr !=null){
            if(curr != null){
                stack.push(curr);
                curr= curr.lNode;
            }
            else{
                temp = stack.peek().rNode;
                if(temp == null)
                {
                    temp = stack.pop();
                    System.out.print(" ==> "+temp);
                    while(!stack.isEmpty() && temp == stack.peek().rNode){
                        temp = stack.pop();
                        System.out.print(" ==> "+temp);
                    }
                }
                else curr=temp;
            }
        }
       
    }
}
