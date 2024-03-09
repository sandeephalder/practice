public class CheckIdenticalTrees {
   
    public static void main(String[] args) {
        new CheckIdenticalTrees();
    }

    CheckIdenticalTrees(){
        
        BST bst1 = new BST();

        bst1.root= bst1.buildTree(bst1.root);


        BST bst2 = new BST();
  
        bst2.root= bst2.buildTree(bst2.root);
        bst1.root.lNode.lNode= bst1.insertLeft(bst1.root.lNode.lNode,9);
     
        System.out.print(checkTreeIdentical(bst1.root,bst2.root));
    }

    public boolean checkTreeIdentical(TreeNode node1,TreeNode node2){
      if(node1 ==null || node2 ==null) return node1 == node2;
      boolean l = checkTreeIdentical(node1.lNode, node2.lNode);
      boolean r = checkTreeIdentical(node1.rNode, node2.rNode);
      return (node1.data == node2.data)  && l && r;
    }

}
