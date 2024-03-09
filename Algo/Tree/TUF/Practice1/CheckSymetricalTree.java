public class CheckSymetricalTree {
    public static void main(String[] args) {
        new CheckSymetricalTree();
    }

    CheckSymetricalTree(){
        
        BST bst = new BST();
        //for(int i : arr) 
        bst.root= bst.buildMirrorTree(bst.root);
        //bst.root.lNode.lNode= bst.insertLeft(bst.root.lNode.lNode,9);
       
        
        System.out.println(checkSymetricalTree(bst.root,bst.root));
    }



    public boolean checkSymetricalTree(TreeNode node1,TreeNode node2){
        if(node1 == null || node2==null)
        return node1==node2;
       
       if(node1.data != node2.data) return false;
       boolean lNode = checkSymetricalTree(node1.lNode, node2.rNode);
       boolean rNode = checkSymetricalTree(node1.rNode, node2.lNode);
       return lNode && rNode;
    }
}
