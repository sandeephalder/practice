public class maxPathSum {
    int max = 0;
    public static void main(String[] args) {
        new maxPathSum();
    }

    maxPathSum(){
        
        BST bst = new BST();
        //for(int i : arr) 
        bst.root= bst.buildTree(bst.root);
        bst.root.lNode.lNode= bst.insertLeft(bst.root.lNode.lNode,9);
        maxpath(bst.root);
        System.out.print(max);
    }

    public int maxpath(TreeNode node){
        if(node == null)
        return 0;
        int l = maxpath(node.lNode);
        int r = maxpath(node.rNode);
        int result = node.data+ Math.max(l,r);
        max = Math.max(max,l+r+node.data);
       return result;
    }

}
