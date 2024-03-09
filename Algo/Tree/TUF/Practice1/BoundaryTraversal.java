import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
    public static void main(String[] args) {
        new BoundaryTraversal();
    }

    BoundaryTraversal(){
        
        BST bst = new BST();
        //for(int i : arr) 
        bst.root= bst.buildTree(bst.root);
        bst.root.lNode.lNode= bst.insertRight(bst.root.lNode.lNode,9);
        bst.root.lNode.lNode.rNode= bst.insertRight(bst.root.lNode.lNode.rNode,19);
        List<TreeNode> boundary = new  LinkedList<>();
        System.out.println(boundaryTraversal(bst.root,boundary));
    }



    public List<TreeNode> boundaryTraversal(TreeNode root,List<TreeNode> boundary){
        if(root == null)
        return boundary;
       Stack<TreeNode> rightboundary = new  Stack<>();
       leftboundaryTraversal(root, boundary);
       leafboundaryTraversal(root, boundary);
       rightboundaryTraversal(root, rightboundary);
       while(!rightboundary.isEmpty()) 
       boundary.add(rightboundary.pop());
       boundary.remove(boundary.size()-1);
       return boundary;
    }

    public boolean isLeaf(TreeNode root){
        if(root==null) return false;
        return  (root.lNode==null && root.rNode==null);
    }

    public void leftboundaryTraversal(TreeNode root,List<TreeNode> boundary){
        if(root == null)
        return ;
       TreeNode node = root;
       while(true){
        if(isLeaf(node)) break;
        boundary.add(node);
        if(node.lNode!=null) node = node.lNode;
        else if(node.rNode!=null) node =node.rNode; 
       }

       return ;
    }

    public void leafboundaryTraversal(TreeNode root,List<TreeNode> boundary){
        if(root == null)
        return ;
       if(isLeaf(root)) boundary.add(root);
       leafboundaryTraversal(root.lNode, boundary);
       leafboundaryTraversal(root.rNode, boundary);
       return ;
    }

    public void rightboundaryTraversal(TreeNode root,Stack<TreeNode> rightboundary){
        if(root == null)
        return ;
        TreeNode node = root;
       while(true){
           if(isLeaf(node)) break;
           rightboundary.push(node);
           if(node.rNode != null) node = node.rNode;
           else if(node.lNode!=null) node = node.lNode;
       }
       return ;
    }
}
