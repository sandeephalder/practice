public class DiameterOfBinaryTree {

    int max=0;
    public static void main(String[] args) {
        new DiameterOfBinaryTree();
    }

    DiameterOfBinaryTree(){
        
        BST bst = new BST();
        //for(int i : arr) 
        bst.root= bst.buildTree(bst.root);
        bst.root.lNode.lNode= bst.insertLeft(bst.root.lNode.lNode,9);
        diameter(bst.root);
        System.out.print(max);
    }

    public int diameter(TreeNode node){
        if(node == null)
        return 0;
         int l = diameter(node.lNode);
         int r = diameter(node.rNode);
         max = Math.max(max,l+r);
       return 1+Math.max(l,r);
    }

}
