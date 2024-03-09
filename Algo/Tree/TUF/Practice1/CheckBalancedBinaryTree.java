public class CheckBalancedBinaryTree {
    public static void main(String[] args) {
        new CheckBalancedBinaryTree();
    }

    CheckBalancedBinaryTree(){
        
        BST bst = new BST();
        //for(int i : arr) 
        bst.root= bst.buildTree(bst.root);
        //bst.root.lNode.lNode= bst.insertLeft(bst.root.lNode.lNode,9);
        System.out.print(checkbalanced(bst.root));
    }

    public int checkbalanced(TreeNode node){
        if(node == null)
        return 0;
        int left = checkbalanced(node.lNode);
        int right = checkbalanced(node.rNode);
        if(left ==-1 || right ==-1 || left-right !=0) return -1;
       return left+right + 1;
    }

}
