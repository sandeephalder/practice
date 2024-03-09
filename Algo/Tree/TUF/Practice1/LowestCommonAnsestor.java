public class LowestCommonAnsestor {
    public static void main(String[] args) {
        new LowestCommonAnsestor();
    }

    LowestCommonAnsestor(){
        
        BST bst = new BST(); 
        bst.root= bst.buildTree(bst.root);
        bst.root.lNode.lNode= bst.insertLeft(bst.root.lNode.lNode,9);
        bst.root.lNode.lNode.rNode= bst.insertRight(bst.root.lNode.lNode.rNode,19);
        System.out.println(lcaPath(bst.root,19,4));
    }



    public TreeNode lcaPath(TreeNode root,int source,int target){
        if(root == null)
        return null;
       if(root.data == source || root.data == target)
         return root;
       TreeNode lNode = lcaPath(root.lNode, source, target);
       TreeNode rNode = lcaPath(root.rNode, source, target);

       if(lNode != null && rNode != null)
        return root;
       if(lNode !=null) return lNode;
       if(rNode !=null) return rNode;
       return null;
    }
}
