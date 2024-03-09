public class BST {
    public TreeNode root;
    
   

    public static void main(String[] args) {
        int[] arr = {7,4,5,3,6,2,5,1,8};
        BST bst = new BST();
        for(int i : arr) 
          bst.root= bst.insert(bst.root, i);

          bst.print(bst.root);
    }

    public TreeNode buildTree(TreeNode root){
        root= insertInto(root, 1);
        root= insertLeft(root, 2);
        root= insertRight(root, 3);
        root.lNode= insertLeft(root.lNode, 4);
        root.lNode= insertRight(root.lNode, 5);
        root.rNode= insertLeft(root.rNode, 6);
        root.rNode= insertRight(root.rNode, 7);
       return root;
    }

    public TreeNode buildMirrorTree(TreeNode root){
        root= insertInto(root, 1);
        root= insertLeft(root, 2);
        root= insertRight(root, 2);
        root.lNode= insertLeft(root.lNode, 3);
        root.lNode= insertRight(root.lNode, 4);
        root.rNode= insertLeft(root.rNode, 4);
        root.rNode= insertRight(root.rNode, 3);
       return root;
    }

    public TreeNode insertInto(TreeNode root,int value){
        TreeNode node = new TreeNode(value);
        if(root==null)
        {
            return node;
        }
        root.data = value;
        return root;
    }

    public TreeNode insertLeft(TreeNode root,int value){
        TreeNode node = new TreeNode(value);
        if(root==null)
        {
            return node;
        }
        root.lNode = node;
        return root;
    }

    public TreeNode insertRight(TreeNode root,int value){
        TreeNode node = new TreeNode(value);
        if(root==null)
        {
            return node;
        }
        root.rNode = node;
        return root;
    }


    public TreeNode insert(TreeNode node,int value){
        if(node==null)
        {
            return new TreeNode(value);
        }
        if(value < node.getData())
            node.lNode = insert(node.lNode, value);
        else if(value > node.getData())
        node.rNode = insert(node.rNode, value);
        else node.setData(value);

        return node;
    }

    public void print(TreeNode node){
    if(node ==null) return;
    print(node.lNode);
     System.out.print(" ===> "+node.getData());
     print(node.rNode);
    }

    public TreeNode getRoot() {
        return root;
    }


    public void setRoot(TreeNode root) {
        this.root = root;
    }


}
