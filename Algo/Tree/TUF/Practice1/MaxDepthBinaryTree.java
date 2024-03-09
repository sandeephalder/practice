public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        new MaxDepthBinaryTree();
    }

    MaxDepthBinaryTree(){
        
        BST bst = new BST();
        //for(int i : arr) 
        bst.root= bst.buildTree(bst.root);
        bst.root.lNode.lNode= bst.insertLeft(bst.root.lNode.lNode,9);
        System.out.print(height(bst.root));
    }

    public int height(TreeNode node){
        if(node == null)
        return 0;

       return 1+ Math.max(height(node.lNode),height(node.rNode));
    }

}
